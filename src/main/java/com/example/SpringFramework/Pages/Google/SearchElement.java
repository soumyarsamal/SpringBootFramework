package com.example.SpringFramework.Pages.Google;


import com.example.SpringFramework.annotation.PageFragments;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.List;


@PageFragments
public class SearchElement extends Base {

    @FindBy(name = "q")
    private WebElement searchbox;

    @FindBy(name = "btnK")
    private List<WebElement> searchButton;

    public void searchElement(final String keyword) {
        this.searchbox.sendKeys(keyword);
        this.searchButton.stream().filter(i -> i.isDisplayed() && i.isEnabled()).findFirst().ifPresent(i -> i.click());
    }

    @Override
    public boolean isAt() {
        return this.wait.until((d) -> this.searchbox.isDisplayed());
    }
}
