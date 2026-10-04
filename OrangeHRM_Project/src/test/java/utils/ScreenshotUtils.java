package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

    public static String takeScreenshot(
            WebDriver driver,
            String testName) throws IOException {

        byte[] screenshot =
                ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);

        Path destination = Paths.get(
                System.getProperty("user.dir"),
                "screenshots",
                testName + "_"
                + System.currentTimeMillis()
                + ".png"
        );

        Files.createDirectories(
                destination.getParent()
        );

        Files.write(
                destination,
                screenshot
        );

        System.out.println(
                "Screenshot saved: "
                + destination.toAbsolutePath()
        );

        return destination
                .toAbsolutePath()
                .toString();
    }
}