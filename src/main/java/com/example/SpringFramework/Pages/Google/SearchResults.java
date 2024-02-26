package com.example.SpringFramework.Pages.Google;

import com.example.SpringFramework.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchResults extends Base {


    @FindBy(xpath="//div[@class='ULSxyf']")
    private List<WebElement> results;


    public int getCount()
    {
        return this.results.size();
    }

    @Override
    public boolean isAt() {
        return this.wait.until((d)-> !this.results.isEmpty());
    }
}
