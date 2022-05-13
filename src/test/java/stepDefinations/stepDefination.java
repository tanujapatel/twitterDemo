package stepDefinations;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.TwitterProfilePage;
import tests.TestBase;
import tests.ConnectTwitter;
import twitter4j.TwitterException;

public class stepDefination extends TestBase {
	
	
	HomePage homePage = PageFactory.initElements(driver, HomePage.class);
	TwitterProfilePage profilePage = PageFactory.initElements(driver, TwitterProfilePage.class);
	
	@Given("^User launches Twitter Sign In page$")
	public void User_launches_Twitter_Sign_In_page() throws Exception {
		driver=initializeDriver();
		driver.get("https://twitter.com/login");
	}
	
	@When("^User logs into Twitter using available username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void user_logs_into_twitter_using_available_username_as_something_and_password_as_something(String strArg1, String strArg2) throws Throwable {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", loginPage.getUser());
				loginPage.getUser().sendKeys(strArg1);
		loginPage.getNextButton().click();
		loginPage.getPsw().sendKeys(strArg2);
		loginPage.getLogin().click();
	}
	
	@Then("^Login is successful$")
	public void Login_is_successful() throws Exception {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		if (loginPage.getHomePageName().getText().equals("Home")) {
			System.out.println("Login Successful!");
		} else {
			System.out.println("Login Failed!");
		}
	}
	
	@And("^User logs out$")
	public void User_logs_out() throws Exception {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		driver.switchTo().activeElement();
		loginPage.getAccNavButton().click();
		Thread.sleep(2000);
		loginPage.getLogoutButton().click();
		
		loginPage.getLogoutConf().click();	
	}
	
   
    
    @Then("^Error message is shown for invalid login$")
    public void error_message_is_shown_for_invalid_login(String errorMessage) throws Throwable {
    	LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    	String actualErrMsg = loginPage.getErrMsg().getText();
    	if (actualErrMsg.equals(errorMessage)) {
    		System.out.println("InvalidLoginTest : Passed!");
    		Assert.assertEquals(errorMessage, actualErrMsg);
    	} else{
			System.out.println("Error Message not matched... Please check");
		}
    }

    @And("^User set profile details bio as \"([^\"]*)\" and location as \"([^\"]*)\" and url as \"([^\"]*)\"$")
    public void user_set_profile_details_bio_as_something_and_location_as_something_and_url_as_something(String strArg1, String strArg2, String strArg3) throws Throwable {
    	TwitterProfilePage profilePage = PageFactory.initElements(driver, TwitterProfilePage.class);
    	profilePage.getProfileButton().click();
    	profilePage.getEditProfileButton().click();

    	profilePage.getBioText().clear();	
    	profilePage.getBioText().sendKeys(strArg1);
    	
    	profilePage.getLocationText().clear();
    	profilePage.getLocationText().sendKeys(strArg2);
    	
    	profilePage.getUrlText().clear();
    	profilePage.getUrlText().sendKeys(strArg3);
    	
    	profilePage.getSaveButton().click();
    }

    @And("^User verifies profile details as \"([^\"]*)\" and location as \"([^\"]*)\" and url as \"([^\"]*)\"$")
    public void user_verifies_profile_details_as_something_and_location_as_something_and_url_as_something(String strArg1, String strArg2, String strArg3) throws Throwable {
    	TwitterProfilePage profilePage = PageFactory.initElements(driver, TwitterProfilePage.class);
    	if(profilePage.getActualBioText().getText().equals(strArg1)){
			System.out.println("Bio text updated to : "+ strArg1); 	}
		else { 
			System.out.print("|"+profilePage.getActualBioText().getText()+"|");
			throw new Exception("Error : Bio text not updated!");	}
		
		if(profilePage.getActualLocationText().getText().equals(strArg2)){
			System.out.println("Location updated to : "+ strArg2); 	}
		else { 
			System.out.print("|"+profilePage.getActualLocationText().getText()+"|");
			throw new Exception("Error : Location not updated!");
		}
		
		if(profilePage.getActualURLText().getText().equals(strArg3)){
			System.out.println("URL updated to : "+ strArg3);	}  
		else { 
			System.out.print("|"+profilePage.getActualURLText().getText()+"|");
			throw new Exception("Error : URL not updated!");
		}
	}

    private boolean equals(String text, String strArg1) {
		return false;
	}

	@And("^User selects profile picture as \"([^\"]*)\" and set the picture$")
    public void user_selects_profile_picture_as_something_and_set_the_picture(String strArg1) throws Throwable {
    	TwitterProfilePage profilePage = PageFactory.initElements(driver, TwitterProfilePage.class);
    	profilePage.getProfileButton().click();
    	profilePage.getEditProfileButton().click();
		profilePage.getInputProfilePic().sendKeys(strArg1);
		
		driver.switchTo().activeElement();
		profilePage.getProfilePicApplyButton().click();
		profilePage.getSaveButton().click();
    }
    
    @And("^User searches for tweets using search string as \"([^\"]*)\"$")
    public void user_searches_for_tweets_using_search_string_as_something(String strArg1) throws Throwable {
          
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		
		homePage.getSearchButton().click();
		homePage.getSearchBar().sendKeys(strArg1);
		homePage.getSearchBar().sendKeys(Keys.ENTER);
		for(int i=0;i<homePage.getTweetTime().size();i++) {
			String text = homePage.getTweetTime().get(i).getText();
			if (text.contains("s") || text.contains("m")) {
				System.out.println(homePage.getTweetText().get(i));
			}else if(text.contains("1h")||text.contains("2h")){
				System.out.println(homePage.getTweetText().get(i));
			}
		}
    }

 	@And("^User closes browser$")
	public void user_closes_browser() throws Throwable {
		closeDriver();
	}
    
 	 @Given("^User creates Twitter instance$")
     public void user_creates_twitter_instance()  {
 		ConnectTwitter connectTwitter = new ConnectTwitter();
 		connectTwitter.getTwitterinstance();
     }

     @When("^User searches for tweets$")
     public void user_searches_for_tweets() {
		 try {
			 ConnectTwitter.searchtweets("Query string");
		 } catch (TwitterException e) {
			 e.printStackTrace();
		 }
     }

}
