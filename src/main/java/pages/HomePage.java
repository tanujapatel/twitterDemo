package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how=How.XPATH, using="//*[@aria-label='Search and explore']") WebElement searchButton;
	@FindBy(how=How.XPATH, using="//input[@aria-label='Search query'][@data-testid='SearchBox_Search_Input']") WebElement searchBar;
	@FindBy(how=How.XPATH, using="//div[@data-testid='tweetText']") List<WebElement> tweetText;
	@FindBy(how=How.XPATH, using="//div[contains(@class,'css-1dbjc4n')]//time")
	List<WebElement> tweetTime;
	@FindBy(how=How.XPATH, using="//div/h2[@role='heading']//div/div/div/span[1]/span/span") WebElement pageHeader;
	
	public WebElement getSearchButton() {
		return searchButton;
	}
	public WebElement getSearchBar() {
		return searchBar;
	}
	public List<WebElement> getTweetText() {
		return tweetText;
	}
	public List<WebElement> getTweetTime() {
		return tweetTime;
	}
	public WebElement getPageHeader() {
		return pageHeader;
	}
}