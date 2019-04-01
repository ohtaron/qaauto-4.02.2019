import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkedInExample {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");

        String emailLogin = "ohta@i.ua";
        String emailPass = "";
        String verifyUrl = "https://www.linkedin.com/feed/";
        WebElement searchName = driver.findElement(By.xpath("//*[@id='login-email']"));
        searchName.sendKeys(emailLogin);
        WebElement searchPass = driver.findElement(By.xpath("//*[@id='login-password']"));
        searchPass.sendKeys(emailPass);
        WebElement signIn = driver.findElement(By.xpath("//*[@id='login-submit']"));
        signIn.click();
        String url = driver.getCurrentUrl();
        System.out.println(url);

        if (url.equals(verifyUrl)) {
            System.out.println("Login Successful");
        } else {
            System.out.println("Login failed");
        }


    }
}
