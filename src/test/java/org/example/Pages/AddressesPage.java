package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddressesPage {

    private WebDriver driver;
    private WebElement createNewAddressButton;

    public AddressesPage(WebDriver driver) {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        createNewAddressButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#content > div.addresses-footer > a > span")));
    }

    public void clickCreateNewAddressButton() {
        createNewAddressButton.click();
    }

    private WebElement getLastAddedAddress() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[starts-with(@id, 'address-')][last()]")));
    }

    public String getAliasFromLastAddedAddress() {
        return getLastAddedAddress().findElement(By.cssSelector("h4")).getText();
    }

    private String[] getAddressDetails() {
        String addressText = getLastAddedAddress().getText();
        return addressText.split("\\n");
    }

    public String getAddressFromLastAddedAddress() {
        String[] addressDetails = getAddressDetails();
        return addressDetails.length > 2 ? addressDetails[2].trim() : "";
    }

    public String getCityFromLastAddedAddress() {
        String[] addressDetails = getAddressDetails();
        return addressDetails.length > 3 ? addressDetails[3].trim() : "";
    }

    public String getZipCodeFromLastAddedAddress() {
        String[] addressDetails = getAddressDetails();
        return addressDetails.length > 4 ? addressDetails[4].trim() : "";
    }

    public String getCountryFromLastAddedAddress() {
        String[] addressDetails = getAddressDetails();
        return addressDetails.length > 5 ? addressDetails[5].trim() : "";
    }

    public String getPhoneFromLastAddedAddress() {
        String[] addressDetails = getAddressDetails();
        return addressDetails.length > 6 ? addressDetails[6].trim() : "";
    }
}