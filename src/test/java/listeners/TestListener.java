package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BaseTest;
import utils.ExtentManager;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getReport();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, result.getThrowable());
        WebDriver driver = ((BaseTest) result.getInstance()).driver;
        String path = ScreenshotUtil.capture(driver, result.getName());
        test.addScreenCaptureFromPath(path, result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}