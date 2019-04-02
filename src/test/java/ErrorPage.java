import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ErrorPage {

    WebDriver driver;

    WebElement errorPasswordMessage;
    WebElement logInErrorMessage;

    public ErrorPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    public void initElements() {
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
