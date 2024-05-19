package org.example;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/account-address.feature/",
        plugin = {"pretty", "html:google-report.html"}
)

public class TestAccountAddressFeature {
}
