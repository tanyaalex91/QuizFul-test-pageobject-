package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends AbstractPage {
	private final Logger logger = LogManager.getRootLogger();
	private final String BASE_URL = "http://www.quizful.net/LoginAction.registration";

	@FindBy(id = "login")
	private WebElement inputLogin;

	@FindBy(name = "registrationForm.password")
	private WebElement inputPassword;

	@FindBy(name = "registrationForm.repassword")
	private WebElement confirmPassword;

	@FindBy(name = "registrationForm.email")
	private WebElement enterEmail;

	@FindBy(xpath = "//*[@id=\"corporate\"]")
	private WebElement checkboxClick;

	@FindBy(xpath = "//*[@id=\"register-form\"]/div[3]/form/p[2]/input[1]")
	private WebElement buttonSubmit;

	public RegisterPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
		logger.info("Login page opened");
	}

	public void register (String username, String password, String email) throws InterruptedException

	{
		inputLogin.sendKeys(username);
		inputPassword.sendKeys(password);
		confirmPassword.sendKeys(password);
		enterEmail.sendKeys(email);
		checkboxClick.click();
		Thread.sleep(10000);
		buttonSubmit.click();
		logger.info("Login performed");

	}
	

	
	
	
	
	
	

}
