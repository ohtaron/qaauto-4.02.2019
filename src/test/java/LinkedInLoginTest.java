import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LinkedInLoginTest {

    @Test
    public void successfulLoginTest() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
        WebElement emailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));

        emailField.sendKeys("ohta@i.ua");
        passwordField.sendKeys("fghdfghd");
        signInButton.click();

        WebElement profileNavigationItem = driver.findElement(By.xpath("//li[@id='profile-nav-item']"));

        profileNavigationItem.isDisplayed();
        Assert.assertTrue(profileNavigationItem.isDisplayed(), "ProfileNavigationItem is not displayed on Home page");

        Assert.assertEquals(driver.getTitle(), "LinkedIn", "Home page title is wrong");

        driver.quit();

    }

    @Test
    public void negativeWithEmptyValuesTest() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
        WebElement emailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));

        emailField.sendKeys("");
        passwordField.sendKeys("");
        signInButton.click();

        WebElement logInHomePage = driver.findElement(By.xpath("//input[@id='login-submit']"));

        logInHomePage.isDisplayed();
        Assert.assertTrue(logInHomePage.isDisplayed(), "Home page is not displayed");

        //Assert.assertEquals(driver.getTitle(), "LinkedIn: Войти или зарегистрироваться", "Home page title is wrong");

        driver.quit();
    }


    @Test
    public void negativeWithEmptyPasswordValuesTest() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
        WebElement emailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));

        emailField.sendKeys("ohta@i.ua");
        passwordField.sendKeys("");
        signInButton.click();

        WebElement logInHomePage = driver.findElement(By.xpath("//input[@id='login-submit']"));

        logInHomePage.isDisplayed();
        Assert.assertTrue(logInHomePage.isDisplayed(), "Home page is not displayed");

        //Assert.assertEquals(driver.getTitle(), "LinkedIn: Войти или зарегистрироваться", "Home page title is wrong");

        driver.quit();
    }


    @Test
    public void negativeWithEmptyLoginValuesTest() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
        WebElement emailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));

        emailField.sendKeys("");
        passwordField.sendKeys("ohta@i.ua");
        signInButton.click();

        WebElement logInHomePage = driver.findElement(By.xpath("//input[@id='login-submit']"));

        logInHomePage.isDisplayed();
        Assert.assertTrue(logInHomePage.isDisplayed(), "Home page is not displayed");

        //Assert.assertEquals(driver.getTitle(), "LinkedIn: Войти или зарегистрироваться", "Home page title is wrong");

        driver.quit();
    }


    @Test
    public void negativeWithWrongPasswordValuesTest() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
        WebElement emailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));

        emailField.sendKeys("ohta@i.ua");
        passwordField.sendKeys("Test1234");
        signInButton.click();

        WebElement logInErrorMessage = driver.findElement(By.xpath("//div[@id='error-for-password']"));
        String logInErrorMessageString = logInErrorMessage.getText();

        Assert.assertEquals(logInErrorMessageString, "Это неверный пароль. Повторите попытку или измените пароль.",
                "Successful login with wrong password ");

        driver.quit();
    }


    @Test
    public void negativeWithShortWrongPasswordValuesTest() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
        WebElement emailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));

        emailField.sendKeys("ohta@i.ua");
        passwordField.sendKeys("1");
        signInButton.click();

        WebElement logInErrorMessage = driver.findElement(By.xpath("//div[@id='error-for-password']"));
        String logInErrorMessageString = logInErrorMessage.getText();

        Assert.assertEquals(logInErrorMessageString, "Это неверный пароль. Повторите попытку или измените пароль.",
                "Successful login with wrong password ");

        driver.quit();
    }


    @Test
    public void negativeWithLongWrongPasswordValuesTest() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
        WebElement emailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));

        emailField.sendKeys("ohta@i.ua");
        passwordField.sendKeys("Test1234567890123456789012345678901234567890123456789012345678901234567890");
        signInButton.click();

        WebElement logInErrorMessage = driver.findElement(By.xpath("//div[@id='error-for-password']"));
        String logInErrorMessageString = logInErrorMessage.getText();

        Assert.assertEquals(logInErrorMessageString, "Это неверный пароль. Повторите попытку или измените пароль.",
                "Successful login with wrong password ");

        driver.quit();
    }


    @Test
    public void negativeWithWrongLoginValuesTest() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
        WebElement emailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));

        emailField.sendKeys("ohta");
        passwordField.sendKeys("fghdfghd");
        signInButton.click();

        WebElement logInErrorMessage = driver.findElement(By.xpath("//div[@id='error-for-username']"));
        String logInErrorMessageString = logInErrorMessage.getText();

        Assert.assertEquals(logInErrorMessageString, "Укажите действительный адрес эл. почты.",
                "Successful login with wrong email");

        driver.quit();

    }



    @Test
    public void negativeWithWrongEmailValuesTest() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
        WebElement emailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));

        emailField.sendKeys("ohta@i.com.ua.ua.ru");
        passwordField.sendKeys("fghdfghd");
        signInButton.click();

        WebElement logInErrorMessage = driver.findElement(By.xpath("//div[@id='error-for-username']"));
        String logInErrorMessageString = logInErrorMessage.getText();

        Assert.assertEquals(logInErrorMessageString, "Этот адрес эл. почты не зарегистрирован в LinkedIn. Повторите попытку.",
                "Successful login with wrong email");

        driver.quit();

    }


    @Test
    public void negativeWithWrongNumberValuesTest() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
        WebElement emailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));

        emailField.sendKeys("0502134675");
        passwordField.sendKeys("fghdfghd");
        signInButton.click();

        WebElement logInErrorMessage = driver.findElement(By.xpath("//div[@id='error-for-username']"));
        String logInErrorMessageString = logInErrorMessage.getText();

        Assert.assertEquals(logInErrorMessageString, "Обязательно включите в номер значок «+» и код своей страны.",
                "Successful login with wrong phone number");

        driver.quit();

    }


    @Test
    public void negativeWithShortNumberValuesTest() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
        WebElement emailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));

        emailField.sendKeys("+38050");
        passwordField.sendKeys("fghdfghd");
        signInButton.click();

        WebElement logInErrorMessage = driver.findElement(By.xpath("//div[@id='error-for-username']"));
        String logInErrorMessageString = logInErrorMessage.getText();

        Assert.assertEquals(logInErrorMessageString, "Этот номер телефона не зарегистрирован в LinkedIn. Повторите попытку.",
                "Successful login with wrong phone number");

        driver.quit();

    }


    @Test
    public void negativeWithLongNumberValuesTest() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
        WebElement emailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));

        emailField.sendKeys("+3805000427429846284782674234247462");
        passwordField.sendKeys("fghdfghd");
        signInButton.click();

        WebElement logInErrorMessage = driver.findElement(By.xpath("//div[@id='error-for-username']"));
        String logInErrorMessageString = logInErrorMessage.getText();

        Assert.assertEquals(logInErrorMessageString, "Этот номер телефона не зарегистрирован в LinkedIn. Повторите попытку.",
                "Successful login with wrong phone number");

        driver.quit();

    }
}

