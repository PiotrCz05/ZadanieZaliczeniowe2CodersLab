package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YourAccountPage {

    private WebElement addressLink;

    public YourAccountPage(WebDriver driver) {
        addressLink = driver.findElement(By.xpath("//*[@id=\"footer_account_list\"]/li[4]/a"));
    }

    public void clickAddressLink() {
        addressLink.click();
    }


}

