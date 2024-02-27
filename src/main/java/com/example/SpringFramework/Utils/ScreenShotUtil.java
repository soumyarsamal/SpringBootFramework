package com.example.SpringFramework.Utils;

import jakarta.annotation.PostConstruct;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

@Lazy
@Component
public class ScreenShotUtil {


    @Autowired
    private TakesScreenshot screenshot;

    @Value("${screenshot.path}/img.png")
    private Path path;

    @PostConstruct
    public void waiting() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            System.out.println("Waiting ......");

        }
    }

    public void takeScreenShot() throws IOException {
        File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
        FileCopyUtils.copy(sourceFile,this.path.toFile());

    }



}
