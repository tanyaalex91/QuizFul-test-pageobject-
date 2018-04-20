package by.htp.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServicesPage extends AbstractPage {

	private final Logger logger = LogManager.getRootLogger();
	private final String BASE_URL = "https://s.onliner.by/";

	@FindBy(xpath = "//*[@id=\"service-list\"]/div[2]/div/div/div[1]/div[1]/div[1]/div/div[2]/div[1]/ul/li[1]/label/span/span[1]")
	private WebElement checkBoxClick;

	@FindBy(xpath = "//*[@id=\"service-list\"]/div[2]/div/div/div[1]/div[1]/div[2]/div/div[2]/div/div/div[11]/div[2]/ul/li[1]/label/span/span[2]/span")
	private WebElement checkBoxcheck;

	public ServicesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
		logger.info("services page opened");
	}

	private void checkDefiniteService() throws InterruptedException {
		checkBoxClick.click();
		checkBoxcheck.click();

	}

}
