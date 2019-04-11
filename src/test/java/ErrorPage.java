import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ErrorPage {

    private WebDriver driver;

    @FindBy(xpath = "//div[@id='error-for-password']")
    private WebElement errorPasswordMessage;
    @FindBy(xpath = "//div[@id='error-for-username']")
    private WebElement logInErrorMessage;
    @FindBy(xpath = "//h1[@class='header__content__heading']")
    private WebElement errorMessage;

    public ErrorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public String isErrorPasswordMessage() {
        return errorPasswordMessage.getText();
    }

    public String isErrorLogInMessage() {
        return logInErrorMessage.getText();
    }

    public String isErrorMessage() {
        return errorMessage.getText();
    }
}
