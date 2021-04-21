package com.cws.main;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.cws.commons.CommonFunctions;
import com.cws.tests.Test_AddEvents;
import com.cws.tests.Test_AuditReport;
import com.cws.tests.Test_ControllerReportsBPS;
import com.cws.tests.Test_ControllerReportsComparison;
import com.cws.tests.Test_ControllerReportsFeeTypes;
import com.cws.tests.Test_ControllerReportsPayouts;
import com.cws.tests.Test_DailyAccrual;
import com.cws.tests.Test_DailyBreakage;
import com.cws.tests.Test_EquityCashReInvestCapGain;
import com.cws.tests.Test_EquityCashReInvestIncome;
import com.cws.tests.Test_EquityCustFundLetterSummary;
import com.cws.tests.Test_EquityCustFundingLetter;
import com.cws.tests.Test_EquityCustFundingLetterQC;
import com.cws.tests.Test_EquityDistributionQC;
import com.cws.tests.Test_EquityDivT;
import com.cws.tests.Test_EquityDividendLetter;
import com.cws.tests.Test_EquityMoneyMovement;
import com.cws.tests.Test_EquityRateNotification;
import com.cws.tests.Test_EquityRecordDateShares;
import com.cws.tests.Test_EquityRecordDateSharesComparison;
import com.cws.tests.Test_ExcelFileLoad;
import com.cws.tests.Test_FileStatus;
import com.cws.tests.Test_GenerateDailyEvents;
import com.cws.tests.Test_HalfpennyAdjustmentQuery;
import com.cws.tests.Test_HalfpennyDailyNAVBreakage;
import com.cws.tests.Test_HalfpennyDailyNAVBreakageHistory;
import com.cws.tests.Test_HalfpennyDetailsHistory;
import com.cws.tests.Test_HalfpennyNAVBreakageQuery;
import com.cws.tests.Test_HistoryCustFundLetterSummary;
import com.cws.tests.Test_HistoryCustFundingLetter;
import com.cws.tests.Test_HistoryCustFundingLetterQC;
import com.cws.tests.Test_HistoryDailyAccrual;
import com.cws.tests.Test_HistoryDailyBreakage;
import com.cws.tests.Test_HistoryDistributionQC;
import com.cws.tests.Test_HistoryDivT;
import com.cws.tests.Test_HistoryDividendLetter;
import com.cws.tests.Test_HistoryMoneyMovement;
import com.cws.tests.Test_HistoryRateNotification;
import com.cws.tests.Test_LetterVariables;
import com.cws.tests.Test_ProcessStatus;
import com.cws.tests.Test_QueryDataRanges;
import com.cws.utils.ExcelFileReader;
import com.cws.utils.PropertyFileReader;
import com.cws.utils.Reports;

/*
 * This class controls the Test Execution for CWS Application based on the Test Region & Browser name in config sheet.
 */
public class Base extends Reports {

	public static PropertyFileReader config = new PropertyFileReader();
	public static WebDriver driver;
	public static String timestamp = new SimpleDateFormat("EEE MM-dd-yyyy hh-mm-ss a").format(new Date());
	public static String resultsPath = System.getProperty("user.dir") + "\\results\\Test Results_" + timestamp;
	public static String extractDownloadedPath = resultsPath + "\\Extracts";
	public static String screenshotPath = resultsPath + "\\Screenshots";
	public static String reportPath = resultsPath + "\\Test Execution Report\\Report_" + timestamp + ".html";

	/*
	 * This method will return the WebDriver object for re-usability by the child classes.  
	 */
	public static WebDriver getDriver() {
		if (driver != null) {
			return driver;
		} else {
			return driver;
		}
	}

	/*
	 * This method is used to initialize WebDriver based on browser.
	 * Once WebDriver has been initialized, the browser will then navigate to the application.
	 */
	public static void launchApplicationInBrowser() {
		String browser_name = config.getProperty("Browser");
		if (browser_name.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", config.getProperty("ChromeDriver") );

			//Setup download directory path to save all Excel extracts.
			Map<String,Object>chromePref = new HashMap<>();
			chromePref.put("download.default_directory", extractDownloadedPath);
			ChromeOptions opt = new ChromeOptions();
			opt.setExperimentalOption("prefs", chromePref);

			driver = new ChromeDriver(opt);
		} else if (browser_name.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", config.getProperty("IEDriver"));
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();

		String test_region = config.getProperty("Region");
		if (test_region.equalsIgnoreCase("DEV")) {
			driver.get(config.getProperty("DEV_URL"));
		} else if (test_region.equalsIgnoreCase("MOD")) {
			driver.get(config.getProperty("MOD_URL"));
		}
	}

	/*
	 * This method will close the browser session once execution has been completed.
	 */
	public static void closeBrowserSession() {
		if (driver != null) {
			driver.quit();
		}
		System.out.println("Closed the browser session.");
	}

	/*
	 * This method is responsible to setup the Report configurations & starting WebDriver instance.
	 */
	public static void setup() {
		System.out.println("Setting up the Report configurations.");
		Reports.init_Report();
		System.out.println("Launching the application as per below configurations:");
		System.out.println("\tRegion:  " + config.getProperty("Region"));
		System.out.println("\tBrowser: " + config.getProperty("Browser"));
		launchApplicationInBrowser();
	}

	/*
	 * This method is responsible to end WebDriver instance & generate Test Reports.
	 * Once reports have been generated, the User will be navigated to the Results folder.
	 */
	public static void teardown() {
		closeBrowserSession();
		Reports.flushReport();
		System.out.println("Generating the Test Results.");
		try {
			Desktop.getDesktop().open(new File(".\\results"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * This method will control the test case execution based on 'Run_Flag' value.
	 */
	public static void executionFlow() {
		/*
		 * Negative Test Cases for File Utilities Module.
		 */
		Test_ExcelFileLoad excelFileLoad = new Test_ExcelFileLoad();
		if (ExcelFileReader.readData("Modules", 7, 2).equalsIgnoreCase("Yes")) {
			excelFileLoad.validate_excelFileLoad();
		}

		/*
		 * Test Cases for Dividends Module.
		 */
		Test_AddEvents addEvents = new Test_AddEvents();
		//Test_ModifyEvents modifyEvents = new Test_ModifyEvents();
		Test_GenerateDailyEvents generateDailyEvents = new Test_GenerateDailyEvents();
		Test_LetterVariables letterVariables = new Test_LetterVariables();
		
		Test_DailyAccrual dailyAccrual = new Test_DailyAccrual();
		Test_DailyBreakage dailyBreakage = new Test_DailyBreakage();
		CommonFunctions cf = new CommonFunctions();
		
		Test_HistoryDailyAccrual histDailyAccrual = new Test_HistoryDailyAccrual();
		Test_HistoryDailyBreakage histDailyBreakage = new Test_HistoryDailyBreakage();
		Test_HistoryDistributionQC histDistQC = new Test_HistoryDistributionQC();
		Test_HistoryCustFundingLetterQC histCustFundLetterQC = new Test_HistoryCustFundingLetterQC();
		Test_HistoryCustFundingLetter histCustFundLetter = new Test_HistoryCustFundingLetter();
		Test_HistoryCustFundLetterSummary histCustFundLetterSummary = new Test_HistoryCustFundLetterSummary();
		Test_HistoryRateNotification histRateNotif = new Test_HistoryRateNotification();
		Test_HistoryDivT histDivT = new Test_HistoryDivT();
		Test_HistoryMoneyMovement histMoneyMove = new Test_HistoryMoneyMovement();
		Test_HistoryDividendLetter histDivLetter = new Test_HistoryDividendLetter();
		
		Test_EquityCashReInvestIncome eqCashReinvestIncome = new Test_EquityCashReInvestIncome();
		Test_EquityCashReInvestCapGain eqCashReinvestCapGain = new Test_EquityCashReInvestCapGain();
		Test_EquityRecordDateShares eqRecordDateShares = new Test_EquityRecordDateShares();
		Test_EquityDistributionQC eqDistQC = new Test_EquityDistributionQC();
		Test_EquityRateNotification eqRateNotif = new Test_EquityRateNotification();
		Test_EquityCustFundingLetterQC eqCustFundLetterQC = new Test_EquityCustFundingLetterQC();
		Test_EquityCustFundingLetter eqCustFundLetter = new Test_EquityCustFundingLetter();
		Test_EquityRecordDateSharesComparison eqRecordDateSharesComp = new Test_EquityRecordDateSharesComparison();
		Test_EquityCustFundLetterSummary eqCustFundLetterSummary = new Test_EquityCustFundLetterSummary();
		Test_EquityDivT eqDivT = new Test_EquityDivT();
		Test_EquityMoneyMovement eqMoneyMovement = new Test_EquityMoneyMovement();
		Test_EquityDividendLetter eqDividendLetter = new Test_EquityDividendLetter();
		if (ExcelFileReader.readData("Modules", 8, 2).equalsIgnoreCase("Yes")) {
			//Dividends Administration.
			addEvents.validate_addEventsPage();
			//modifyEvents.validate_modifyEventsPage();
			generateDailyEvents.validate_generateDailyEventsPage();
			letterVariables.validate_letterVariablesPage();
			
			//Daily Accrual Process
			dailyAccrual.validate_dailyAccrualPage();
			dailyBreakage.validate_dailyBreakagePage();
			
			//Click Dividends folder.
			getDriver().findElement(By.xpath("//img[@alt='Expand Dividends']//parent::a")).click();
			cf.sleepWait(1000);
			
			//History -> Daily History
			histDailyAccrual.validate_historyDailyAccrualPage();
			histDailyBreakage.validate_histDailyBreakagePage();
			histDistQC.validate_histDistQCPage();
			histCustFundLetterQC.validate_historyCustFundingLetterQC();
			histCustFundLetter.validate_histCustFundingLetterPage();
			histCustFundLetterSummary.validate_custFundLetterSummaryPage();
			histRateNotif.validate_histRateNotificationPage();
			histDivT.validate_histDivTPage();
			histMoneyMove.validate_histMoneyMovementPage();
			histDivLetter.validate_histDividendLetterPage();
			
			//Close Daily History folder.
			getDriver().findElement(By.xpath("//img[@alt='Collapse Daily History']//parent::a")).click();
			
			//History -> Equity History
			eqCashReinvestIncome.validate_eqCashReinvestIncomePage();
			eqCashReinvestCapGain.validate_eqCashReinvestCapGainPage();
			eqRecordDateShares.validate_eqRecordDateSharesPage();
			eqDistQC.validate_equityDistQCPage();
			eqRateNotif.validate_equityRateNotificationPage();
			eqCustFundLetterQC.validate_equityCustFundingLetterQC();
			eqCustFundLetter.validate_equityCustFundingLetterPage();
			eqRecordDateSharesComp.validate_equityRecordDateSharesCompPage();
			eqCustFundLetterSummary.validate_equityCustFundLetterSummaryPage();
			eqDivT.validate_equityDivTPage();
			eqMoneyMovement.validate_equityMoneyMovementPage();
			eqDividendLetter.validate_histDividendLetterPage();	
			
			//Close Dividends folder.
			getDriver().findElement(By.xpath("//img[@alt='Collapse Dividends']/parent::a")).click();
			cf.sleepWait(1500);
		}
		
		/*
		 * Test Cases for Halfpenny module.
		 */
		Test_HalfpennyDailyNAVBreakage navBreakage = new Test_HalfpennyDailyNAVBreakage();
		navBreakage.validate_DailyNAVBreakage();
		
		Test_HalfpennyDailyNAVBreakageHistory navBreakageHist = new Test_HalfpennyDailyNAVBreakageHistory();
		navBreakageHist.validate_DailyNAVBreakageHistory();
		
		//Test_HalfpennyDetails details = new Test_HalfpennyDetails();
		//details.validate_Details();
		
		Test_HalfpennyDetailsHistory detailsHist = new Test_HalfpennyDetailsHistory();
		detailsHist.validate_DetailsHistory();
		
		Test_HalfpennyNAVBreakageQuery navBreakageQuery = new Test_HalfpennyNAVBreakageQuery();
		navBreakageQuery.validate_NAVBreakageQuery();
		
		Test_HalfpennyAdjustmentQuery adjQuery = new Test_HalfpennyAdjustmentQuery();
		adjQuery.validate_AdjQuery();
		
		getDriver().findElement(By.xpath("//img[@alt='Collapse Halfpenny']/parent::a")).click();
		cf.sleepWait(1000);
		
		/*
		 * Test Cases for Controller Reports Module.
		 */
		Test_ControllerReportsPayouts payouts = new Test_ControllerReportsPayouts();
		payouts.validatePayoutsTab();
		
		Test_ControllerReportsComparison comparison = new Test_ControllerReportsComparison();
		comparison.validateComparisonTab();
		
		Test_ControllerReportsFeeTypes feeTypes = new Test_ControllerReportsFeeTypes();
		feeTypes.validateFeeTypes();
		
		//Test_ControllerReportsPayoutTypes payoutTypes = new Test_ControllerReportsPayoutTypes();
		//payoutTypes.validatePayoutsTab();
		
		//Test_ControllerReportsFeePayoutTypes feePayoutTypes = new Test_ControllerReportsFeePayoutTypes();
		//feePayoutTypes.validateFeePayoutTypesTab();
		
		Test_ControllerReportsBPS bps = new Test_ControllerReportsBPS();
		bps.validateBPSTab();		
		
		/*
		 * Test Cases for Reports Module.
		 */
		Test_AuditReport auditReport = new Test_AuditReport();
		if (ExcelFileReader.readData("Modules", 25, 2).equalsIgnoreCase("Yes")) {
			auditReport.validate_auditReportPage();
		}

		Test_FileStatus fileStatus = new Test_FileStatus();
		if (ExcelFileReader.readData("Modules", 26, 2).equalsIgnoreCase("Yes")) {
			fileStatus.validate_fileStatusReportPage();
		}

		Test_ProcessStatus processStatus = new Test_ProcessStatus();
		if (ExcelFileReader.readData("Modules", 27, 2).equalsIgnoreCase("Yes")) {
			processStatus.validate_processStatusReportPage();
		}

		//Test_UserListReport userListReport = new Test_UserListReport();
		if (ExcelFileReader.readData("Modules", 28, 2).equalsIgnoreCase("Yes")) {
			//userListReport.validate_userListReportPage();
		}
		
		getDriver().findElement(By.xpath("//img[@alt='Collapse Reports']/parent::a")).click();
		cf.sleepWait(1000);

		/*
		 * Test Cases for Fund Audits Module.
		 */
		Test_QueryDataRanges queryDateRanges = new Test_QueryDataRanges();
		if (ExcelFileReader.readData("Modules", 29, 2).equalsIgnoreCase("Yes")) {
			queryDateRanges.validate_queryDateRangePage();
		}
		
		System.out.println("Test Execution completed.");
	}

	public static void main(String[] args) {
		setup();
		executionFlow();
		teardown();

	}
}

