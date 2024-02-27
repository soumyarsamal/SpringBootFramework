package com.example.SpringFramework.Pages.Google;

import com.example.SpringFramework.annotation.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Page
public class GooglePage extends Base {

    @Autowired
    private SearchElement searchElement;

    @Autowired
    private SearchResults searchResults;

    @Value("${application.url}")
    private String url;

    public void goTo() {
        this.driver.get(url);
    }

    public SearchElement getSearchElement() {
        return this.searchElement;
    }

    public SearchResults getSearchResults() {
        return this.searchResults;
    }


    @Override
    public boolean isAt() {
        return this.searchElement.isAt();
    }
}
