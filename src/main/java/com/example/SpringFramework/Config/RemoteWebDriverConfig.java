package com.example.SpringFramework.Config;

import com.example.SpringFramework.annotation.LazyConfiguration;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.*;

import java.net.URL;
import java.time.Duration;

@LazyConfiguration
@Profile("remote")
public class RemoteWebDriverConfig {

    @Value("${selenium.grid.url}")
    private URL url;

    @Value("${default.timeout:30}")
    private int timeout;


    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public WebDriver initializeRemotefirefox() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setBrowserName("firefox");
        desiredCapabilities.setPlatform(Platform.LINUX);
        return new RemoteWebDriver(this.url, desiredCapabilities);

    }

    @Bean
    @Scope("prototype")
    @ConditionalOnMissingBean
    public WebDriver initializeRemoteChrome() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setBrowserName("chrome");
        desiredCapabilities.setPlatform(Platform.LINUX);
        return new RemoteWebDriver(this.url, desiredCapabilities);

    }

    @Bean
    public WebDriverWait webdriverwait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(this.timeout));
    }
}
