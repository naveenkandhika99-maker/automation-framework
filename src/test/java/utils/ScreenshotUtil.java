package utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    public static String capture(WebDriver driver, String testName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File(System.getProperty("user.dir") + "/screenshots/" + testName + ".png");
        try {
            FileUtils.copyFile(src, dest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dest.getAbsolutePath();
    }
}