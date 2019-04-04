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

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isPageLoaded(), "Login page was not loaded.");
        loginPage.login("ohta@i.ua" , "fghdfghd");

        HomePage homePage = new HomePage(driver);

        Assert.assertTrue(homePage.isPageLoaded(), "Home page is not loaded");

        driver.quit();

    }

    @Test
    public void negativeWithEmptyValuesTest() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");

        LoginPage loginPage = new LoginPage(driver);
        //Assert.assertTrue(loginPage.isPageLoaded(), "Login page was not loaded.");
        loginPage.login("" , "");

       Assert.assertTrue(loginPage.isPageLoaded(), "Home page is not loaded");

        driver.quit();
    }


    @Test
    public void negativeWithEmptyPasswordValuesTest() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");

        LoginPage loginPage = new LoginPage(driver);
        //Assert.assertTrue(loginPage.isPageLoaded(), "Login page was not loaded.");
        loginPage.login("ohta@i.ua" , "");

        Assert.assertTrue(loginPage.isPageLoaded(), "Home page is not loaded");

        driver.quit();
    }


    @Test
    public void negativeWithEmptyLoginValuesTest() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");

        LoginPage loginPage = new LoginPage(driver);
        //Assert.assertTrue(loginPage.isPageLoaded(), "Login page was not loaded.");
        loginPage.login("" , "fghdfghd");

        Assert.assertTrue(loginPage.isPageLoaded(), "Home page is not loaded");

        driver.quit();
    }


    @Test
    public void negativeWithWrongPasswordValuesTest() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isPageLoaded(), "Login page was not loaded.");
        loginPage.login("ohta@i.ua" , "fghdfghd1234");

        ErrorPage errorPage = new ErrorPage(driver);

        Assert.assertEquals(errorPage.isErrorPasswordMessage(), "Это неверный пароль. Повторите попытку или измените пароль.",
                "Successful login with wrong password ");

        driver.quit();
    }


    @Test
    public void negativeWithShortWrongPasswordValuesTest() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isPageLoaded(), "Login page was not loaded.");
        loginPage.login("ohta@i.ua" , "1");

        ErrorPage errorPage = new ErrorPage(driver);

        Assert.assertEquals(errorPage.isErrorPasswordMessage(), "Это неверный пароль. Повторите попытку или измените пароль.",
                "Successful login with wrong password ");

        driver.quit();
    }


    @Test
    public void negativeWithLongWrongPasswordValuesTest() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isPageLoaded(), "Login page was not loaded.");
        loginPage.login("ohta@i.ua" , "Test2148197469832670286708640q02386402864720864702");

        ErrorPage errorPage = new ErrorPage(driver);

        Assert.assertEquals(errorPage.isErrorPasswordMessage(), "Это неверный пароль. Повторите попытку или измените пароль.",
                "Successful login with wrong password ");

        driver.quit();
    }


    @Test
    public void negativeWithWrongLoginValuesTest() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isPageLoaded(), "Login page was not loaded.");
        loginPage.login("ohta" , "fghdfghd");

        ErrorPage errorPage = new ErrorPage(driver);

        Assert.assertEquals(errorPage.isErrorLogInMessage(), "Укажите действительный адрес эл. почты.",
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

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isPageLoaded(), "Login page was not loaded.");
        loginPage.login("ohta@ua.ru.ua.ua.ia" , "fghdfghd");

        ErrorPage errorPage = new ErrorPage(driver);

        Assert.assertEquals(errorPage.isErrorLogInMessage(), "Этот адрес эл. почты не зарегистрирован в LinkedIn. Повторите попытку.",
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

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isPageLoaded(), "Login page was not loaded.");
        loginPage.login("0501236475" , "fghdfghd");

        ErrorPage errorPage = new ErrorPage(driver);

        Assert.assertEquals(errorPage.isErrorLogInMessage(), "Обязательно включите в номер значок «+» и код своей страны.",
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

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isPageLoaded(), "Login page was not loaded.");
        loginPage.login("+380501" , "fghdfghd");

        ErrorPage errorPage = new ErrorPage(driver);

        Assert.assertEquals(errorPage.isErrorLogInMessage(), "Этот номер телефона не зарегистрирован в LinkedIn. Повторите попытку.",
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

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isPageLoaded(), "Login page was not loaded.");
        loginPage.login("+380501982365479283560295610896392865205967095376209260298639" , "fghdfghd");

        ErrorPage errorPage = new ErrorPage(driver);

        Assert.assertEquals(errorPage.isErrorLogInMessage(), "Этот номер телефона не зарегистрирован в LinkedIn. Повторите попытку.",
                "Successful login with wrong phone number");

        driver.quit();

    }
}

