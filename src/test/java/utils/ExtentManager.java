package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    public static ExtentReports getReport() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("reports/index.html");
        reporter.config().setReportName("Automation Test Results");
        reporter.config().setDocumentTitle("Test Results");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Naveen");
        return extent;
    }
}