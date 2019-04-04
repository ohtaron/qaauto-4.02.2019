import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ErrorPage {

    private WebDriver driver;

    private WebElement errorPasswordMessage;
    private WebElement logInErrorMessage;

    public ErrorPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        errorPasswordMessage = driver.findElement(By.xpath("//div[@id='error-for-password']"));
        logInErrorMessage = driver.findElement(By.xpath("//div[@id='error-for-username']"));
    }


    public String isErrorPasswordMessage() {
        return errorPasswordMessage.getText();
    }

    public String isErrorLogInMessage() {
        return logInErrorMessage.getText();
    }
}
