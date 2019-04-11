import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LinkedInLoginTest {

    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
                //{ "ohta@i.ua", "fghdfghd" },
                //{ "ohTA@i.ua", "fghdfghd" },
                { " ohTA@i.ua ", "fghdfghd" }
        };
    }


    @Test(dataProvider = "validDataProvider")
    public void successfulLoginTest(String userEmail, String userPassword) {


        Assert.assertTrue(loginPage.isPageLoaded(), "Login page was not loaded.");
        HomePage homePage = loginPage.homePageLogin(userEmail , userPassword);

        //HomePage homePage = new HomePage(driver);

        Assert.assertTrue(homePage.isPageLoaded(), "Home page is not loaded");


    }

    @DataProvider
    public Object[][] emptyValuesDataProvider() {
        return new Object[][]{
                { "ohta@i.ua", "" },
                //{ "", "fghdfghd" },
                //{ "", "" }
        };
    }

    @Test (dataProvider = "emptyValuesDataProvider")
    public void negativeWithEmptyValuesTest(String userEmail, String userPassword) {


        Assert.assertTrue(loginPage.isPageLoaded(), "Login page was not loaded.");
        loginPage.loginPageLogin(userEmail , userPassword);

       Assert.assertTrue(loginPage.isPageLoaded(), "Login page is not loaded");


    }


    @DataProvider
    public Object[][] wrongDataProvider() {
        return new Object[][]{
                { "ohta@i.ua", "fghdfghd1234", "", "Это неверный пароль. Повторите попытку или измените пароль." },
                //{ "ohta@@i.ua", "fghdfghd", "Этот адрес эл. почты не зарегистрирован в LinkedIn. Повторите попытку.", "" },
                /*{ "ohta@i.ua", "Test2148197469832670286708640q02386402864720864702" },
                { "ohta", "fghdfghd" },
                { "ohta!", "fghdfghd" },
                { "ohta@ua.ru.ua.ua.ia", "fghdfghd" },
                { "ohta@", "fghdfghd" },
                { "0501236475", "fghdfghd" },
                { "438", "fghdfghd" },
                { "+380501", "fghdfghd" },
                { "+380501982365479283560295610896392865205967095376209260298639", "fghdfghd" }*/
        };
    }

    @Test(dataProvider = "wrongDataProvider")
    public void negativeWithWrongValuesTest(String userEmail, String userPassword, String emailValidation, String passwordValidation) {


        Assert.assertTrue(loginPage.isPageLoaded(), "Login page was not loaded.");
        ErrorPage errorPage = loginPage.errorPageLogin(userEmail, userPassword);

        //ErrorPage errorPage = new ErrorPage(driver);

        //Assert.assertTrue(loginPage.isPageLoaded(), "Login page was not loaded.");

        Assert.assertEquals(errorPage.isErrorLogInMessage(), emailValidation,
                "Successful login with wrong password ");

        Assert.assertEquals(errorPage.isErrorPasswordMessage(), passwordValidation,
                "Successful login with wrong email ");


    }

}

