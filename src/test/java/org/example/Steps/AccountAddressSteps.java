package org.example.Steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;

public class AccountAddressSteps {

    private WebDriver driver;

    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.close();
        }
    }

    @Given("the user is logged in to their account")
    public void theUserIsLoggedInToTheirAccount() {
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        HomePage homePage = new HomePage(driver);
        homePage.clickSignInLink();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeEmailAddress();
        loginPage.typePassword();
        loginPage.clickSignInButton();
    }

    @When("the user clicks on the {string} tile")
    public void theUserClicksOnTheTile(String arg0) {
        YourAccountPage yourAccountPage = new YourAccountPage(driver);
        yourAccountPage.clickAddressLink();
    }

    @And("the user clicks on the {string} button")
    public void theUserClicksOnTheButton(String arg0) {
        AddressesPage addressesPage = new AddressesPage(driver);
        addressesPage.clickCreateNewAddressButton();
    }

    @And("the user fills out the New address form with {string}, {string}, {string}, {string}, {string}, {string}")
    public void theUserFillsOutTheNewAddressFormWith(String alias, String address, String city, String zip, String country, String phone) {
        NewAddressFormPage newAddressFormPage = new NewAddressFormPage(driver);
        newAddressFormPage.typeAlias(alias);
        newAddressFormPage.typeAddress(address);
        newAddressFormPage.typeCity(city);
        newAddressFormPage.typeZipCode(zip);
        newAddressFormPage.selectCountry(country);
        newAddressFormPage.typePhone(phone);
    }

    @And("the user clicks on the {string} button to add the address")
    public void theUserClicksOnTheButtonToAddTheAddress(String arg0) {
        NewAddressFormPage newAddressFormPage = new NewAddressFormPage(driver);
        newAddressFormPage.clickConfirmButton();
    }

    @Then("the new address should be displayed with {string}, {string}, {string}, {string}, {string}, {string}")
    public void theNewAddressShouldBeDisplayedWith(String alias, String address, String city, String zip, String country, String phone) {
        AddressesPage addressesPage = new AddressesPage(driver);

        String actualAlias = addressesPage.getAliasFromLastAddedAddress();
        String actualAddress = addressesPage.getAddressFromLastAddedAddress();
        String actualCity = addressesPage.getCityFromLastAddedAddress();
        String actualZip = addressesPage.getZipCodeFromLastAddedAddress();
        String actualCountry = addressesPage.getCountryFromLastAddedAddress();
        String actualPhone = addressesPage.getPhoneFromLastAddedAddress();

        assertEquals(alias, actualAlias);
        assertEquals(address, actualAddress);
        assertEquals(city, actualCity);
        assertEquals(zip, actualZip);
        assertEquals(country, actualCountry);
        assertEquals(phone, actualPhone);


    }
}
