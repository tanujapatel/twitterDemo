package cucumber;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

import pages.LoginPage;
import tests.TestBase;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features/",
		glue= "stepDefinations",
		tags={"@invalidLogin"}
)  

public class TestRunner {
	
}