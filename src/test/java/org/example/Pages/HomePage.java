package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    private WebElement signInLink;

    public HomePage(WebDriver driver) {
        signInLink = driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a/span"));
    }

    public void clickSignInLink() {
        signInLink.click();
    }
}

