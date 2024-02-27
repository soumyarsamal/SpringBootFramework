package com.example.SpringFramework;

import com.example.SpringFramework.Pages.Google.GooglePage;
import com.example.SpringFramework.Utils.ScreenShotUtil;
import com.google.common.util.concurrent.Uninterruptibles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class Google1Test extends SpringBasetestNGTest{

    @Autowired
    private GooglePage googlePage;

    @Lazy
    @Autowired
    private ScreenShotUtil screenShotUtil;

    @Test
    public void startGoogleTest() throws IOException {
        this.googlePage.goTo();
        Assert.assertTrue(this.googlePage.isAt());
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
        this.googlePage.getSearchElement().searchElement("Selenium ");
        System.out.println(this.googlePage.getSearchResults().getCount());
        Assert.assertTrue(this.googlePage.getSearchResults().getCount()>2);
        //screenShotUtil.takeScreenShot();

    }
}
