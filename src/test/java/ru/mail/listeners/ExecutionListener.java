package ru.mail.listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import ru.mail.BaseTest;
import ru.yandex.qatools.allure.annotations.Attachment;

public class ExecutionListener extends TestListenerAdapter {
    private WebDriver driver = null;

    @Override
    public void onTestFailure(ITestResult result) {

        Reporter.setCurrentTestResult(result);
        Object currentClass = result.getInstance();
        driver = ((BaseTest) currentClass).getDriver();
        createAttachment();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    }

    @Attachment()
    public byte[] createAttachment() {
        return captureScreenShot();
    }

    private byte[] captureScreenShot() {
        byte[] output;
        try {
            output = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            return output;
        } catch (Exception e) {
            return ("Can not parse screen shot data \n" + e).getBytes();
        }
    }
}
