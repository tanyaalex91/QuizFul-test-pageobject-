package pages;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {
	private final Logger logger = LogManager.getRootLogger();
	private final String BASE_URL = "http://www.quizful.net/LoginAction.loginForm";

	@FindBy(id = "login")
	private WebElement inputLogin;

	@FindBy(name = "loginForm.password")
	private WebElement inputPassword;

	@FindBy(xpath = "//*[@id='login-form']/div[3]/form/p/input")
	private WebElement buttonSubmit;
	
	@FindBy(xpath= "//*[@id=\"user-panel\"]/li[1]/b/a")
	private WebElement linkLoggedInUser;

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
		logger.info("Login page opened");
	}

	public void login(String username, String password) {
		inputLogin.sendKeys(username);
		inputPassword.sendKeys(password);
		buttonSubmit.click();
		logger.info("Login performed");
	}
	
	public String getLoggedInUserName()
	{
		return linkLoggedInUser.getAttribute("content");
	}
	
	
}