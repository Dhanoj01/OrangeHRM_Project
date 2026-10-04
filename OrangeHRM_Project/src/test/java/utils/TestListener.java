package utils;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.BaseTest;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getInstance();

    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail(result.getThrowable());

        BaseTest baseTest =
                (BaseTest) result.getInstance();

        WebDriver driver = baseTest.getDriver();

        try {

            if (driver != null) {

                String screenshotPath =
                        ScreenshotUtils.takeScreenshot(
                                driver,
                                result.getName()
                        );
                
                Thread.sleep(3000);

                // Path relative to reports/ExtentReport.html
                String relativePath =
                        "../screenshots/" +
                        new File(screenshotPath).getName();

                test.addScreenCaptureFromPath(
                        relativePath,
                        "Failure Screenshot"
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.skip("Test Skipped");
    }

    @Override
    public void onFinish(
            org.testng.ITestContext context) {

        extent.flush();
    }
}