package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

//	@FindBy(how=How.XPATH, using="//input[@name='session[username_or_email]'][@type='text']") WebElement userTextBox;
	@FindBy(how=How.XPATH, using="//input[@autocomplete='username']") WebElement userTextBox;

//	@FindBy(how=How.XPATH, using="//input[@name='session[password]'][@type='password']") WebElement passwordTextBox;
@FindBy(how=How.XPATH, using="//input[@name='password']") WebElement passwordTextBox;

	@FindBy(how=How.XPATH, using="//span[text()='Next']") WebElement nextButton;


//	@FindBy(how=How.XPATH, using="//div[@data-testid='LoginForm_Login_Button']") WebElement loginButton;
@FindBy(how=How.XPATH, using="//span[text()='Log in']") WebElement loginButton;

//	@FindBy(how=How.XPATH, using="//*[@id='react-root']/div/div/div[2]/main/div/div/div[1]/div/span") WebElement actualErrMsgLabel;

	@FindBy(how=How.XPATH, using="//span[text()='Wrong password!']") WebElement actualErrMsgLabel;

	@FindBy(how=How.XPATH, using="//*[@id='react-root']/div/div/div[2]/main/div/div/div/div/div/div[1]/div[1]/div/div/div/div/div[1]/div/h2/span") WebElement homePageName;
	@FindBy(how=How.XPATH, using="//div[@aria-label='Account menu'][@data-testid='SideNav_AccountSwitcher_Button']") WebElement accountNavButton;
	@FindBy(how=How.XPATH, using="//*[@data-testid='AccountSwitcher_Logout_Button']") WebElement logoutButton;
	
	@FindBy(how=How.XPATH, using="//*[@data-testid='confirmationSheetConfirm']") WebElement logoutConfButton;
	
	public WebElement getUser() {
		return userTextBox;
	}
	public WebElement getNextButton() {
		return nextButton;
	}
	public WebElement getPsw() {
		return passwordTextBox;
	}
	
	public WebElement getLogin() {
		return loginButton;
	}
			
	public WebElement getAccNavButton() {
		return accountNavButton;
	}
	
	public WebElement getLogoutButton() {
		return logoutButton;
	}
	
	public WebElement getHomePageName() {
		return homePageName;
	}

	public WebElement getErrMsg() {
		return actualErrMsgLabel;
	}
	
	public WebElement getLogoutConf() {
		return logoutConfButton;
	}
	
}