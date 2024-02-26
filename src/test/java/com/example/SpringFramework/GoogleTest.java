package com.example.SpringFramework;
import com.example.SpringFramework.Pages.Google.GooglePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends SpringBasetestNGTest {

    @Autowired
    private GooglePage googlePage;

    @Test
    public void startGoogleTest()
    {
        this.googlePage.goTo();
        Assert.assertTrue(this.googlePage.isAt());
        this.googlePage.getSearchElement().searchElement("Spring boot");
        System.out.println(this.googlePage.getSearchResults().getCount());
        Assert.assertTrue(this.googlePage.getSearchResults().getCount()>2);
    }
}
