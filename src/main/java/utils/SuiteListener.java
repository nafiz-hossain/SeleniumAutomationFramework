package main.java.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;
import test.java.BaseTest;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class SuiteListener implements ITestListener, IAnnotationTransformer {
    @Override
    public void onTestStart(ITestResult iTestResult) {
        ITestListener.super.onTestStart(iTestResult);
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        ITestListener.super.onTestSuccess(iTestResult);
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
            String fileName =  System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + iTestResult.getMethod().getMethodName();
            File f = ((TakesScreenshot)  BaseTest.driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(f, new File(fileName + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        ITestListener.super.onTestSkipped(iTestResult);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(iTestResult);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult iTestResult) {
        ITestListener.super.onTestFailedWithTimeout(iTestResult);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }

    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class testClass, Constructor testConstructor, Method testMethod) {
            iTestAnnotation.setRetryAnalyzer(RetryAnalyser.class);
    }
}
