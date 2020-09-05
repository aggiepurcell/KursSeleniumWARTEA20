package helpers;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public class ScreenshotShooter {

    private String path = "src/Screenshots/";

    public void captureScreenshot(WebDriver driver) {

        String screenshotTimestamp = LocalDateTime.now().toString();
        screenshotTimestamp = screenshotTimestamp.replace(':','_');
        screenshotTimestamp = screenshotTimestamp.replace('.','_');
        screenshotTimestamp = screenshotTimestamp.replace('-','_');
        String screenshotName = screenshotTimestamp + ".png";

        File source_file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(source_file, new File(path + screenshotName ));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
