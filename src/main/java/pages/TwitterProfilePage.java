package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.awt.Robot;
import java.awt.event.KeyEvent;

public class TwitterProfilePage {
	WebDriver driver;
	
	public TwitterProfilePage(WebDriver driver) {
		this.driver = driver;
	}
	@FindBy(how=How.XPATH, using="//*[@aria-label='Profile']") WebElement profileButton;
	@FindBy(how=How.XPATH, using="//div[@data-testid='primaryColumn']//a[@href='/settings/profile']") WebElement editProfileButton;
	
	@FindBy(how=How.XPATH, using="//div[@data-testid='Profile_Save_Button']") WebElement saveButton;
	@FindBy(how=How.XPATH, using="//textarea[@name='description']") WebElement bioText;
	@FindBy(how=How.XPATH, using="//input[@name='location']") WebElement locationText;
	@FindBy(how=How.XPATH, using="//input[@name='url']") WebElement urlText;
	
	@FindBy(how=How.XPATH, using="//div[@data-testid='UserDescription']") WebElement actualBioText;
	@FindBy(how=How.XPATH, using="//div[@data-testid='UserProfileHeader_Items']/span[1]/span/span") WebElement actaulLocationText;
	@FindBy(how=How.XPATH, using="//div[@data-testid='UserProfileHeader_Items']/a") WebElement actualUrlText;
	
	@FindBy(how=How.XPATH, using="//div[@aria-label='Add avatar photo']") WebElement profilePicButton;
	@FindBy(xpath = "//div[@aria-label='Add avatar photo']//following-sibling::input") WebElement inputProfilePic;
//	@FindBy(how=How.XPATH, using="//*[@id='layers']/div[2]/div[2]/div/div/div/div/div[2]/div[2]/div/div[1]/div/div/div/div[3]/div") WebElement picApplyButton;
	@FindBy(how=How.XPATH, using="//span[text()='Apply']") WebElement picApplyButton;


	public WebElement getInputProfilePic() {
		return inputProfilePic;
	}

	public WebElement getProfileButton() {
		return profileButton;
	}
	
	public WebElement getEditProfileButton() {
		return editProfileButton;
	}
		
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public WebElement getBioText() {
		return bioText;
	}
	
	public WebElement getLocationText() {
		return locationText;
	}
	
	public WebElement getUrlText() {
		return urlText;
	}
	
	public WebElement getActualBioText() {
		return actualBioText;
	}
	public WebElement getActualLocationText() {
		return actaulLocationText;
	}
	public WebElement getActualURLText() {
		return actualUrlText;
	}
	public WebElement getProfilePicButton() {
		return profilePicButton;
	}
	public WebElement getProfilePicApplyButton() {
		return picApplyButton;
	}
}