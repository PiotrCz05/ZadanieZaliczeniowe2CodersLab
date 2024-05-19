package org.example.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NewAddressFormPage {

    WebDriver driver;

    private WebElement aliasInput;
    private WebElement addressInput;
    private WebElement cityInput;
    private WebElement zipCodeInput;
    private WebElement countryInput;
    private WebElement phoneInput;
    private WebElement confirmButton;

    public NewAddressFormPage(WebDriver driver) {
        this.driver = driver;
        initializeElements();
    }

    private void initializeElements() {

            aliasInput = driver.findElement(By.id("field-alias"));
            addressInput = driver.findElement(By.id("field-address1"));
            cityInput = driver.findElement(By.id("field-city"));
            zipCodeInput = driver.findElement(By.id("field-postcode"));
            countryInput = driver.findElement(By.id("field-id_country"));
            phoneInput = driver.findElement(By.id("field-phone"));
            confirmButton = driver.findElement(By.cssSelector("#content > div > div > form > footer > button"));
        }

        public void typeAlias (String alias){
            aliasInput.clear();
            aliasInput.sendKeys(alias);
        }

        public void typeAddress (String address){
            addressInput.clear();
            addressInput.sendKeys(address);
        }

        public void typeCity (String city){
            cityInput.clear();
            cityInput.sendKeys(city);
        }

        public void typeZipCode (String zip){
            zipCodeInput.clear();
            zipCodeInput.sendKeys(zip);
        }

        public void selectCountry (String country){
            countryInput.getAccessibleName();
        }

        public void typePhone (String phone){
            phoneInput.clear();
            phoneInput.sendKeys(phone);
        }

        public void clickConfirmButton () {
            confirmButton.click();
        }
    }