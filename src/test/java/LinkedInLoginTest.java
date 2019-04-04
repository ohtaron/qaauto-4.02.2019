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
                { "ohta@i.ua", "fghdfghd" },
                { "ohTA@i.ua", "fghdfghd" }
        };
    }

    @Test(dataProvider = "validDataProvider")
    public void successfulLoginTest(String userEmail, String userPassword) {


        Assert.assertTrue(loginPage.isPageLoaded(), "Login page was not loaded.");
        loginPage.login(userEmail , userPassword);

        HomePage homePage = new HomePage(driver);

        Assert.assertTrue(homePage.isPageLoaded(), "Home page is not loaded");


    }

    @Test
    public void negativeWithEmptyValuesTest() {


        Assert.assertTrue(loginPage.isPageLoaded(), "Login page was not loaded.");
        loginPage.login("" , "");

       Assert.assertTrue(loginPage.isPageLoaded(), "Login page is not loaded");


    }


    @Test
    public void negativeWithEmptyPasswordValuesTest() {


        //Assert.assertTrue(loginPage.isPageLoaded(), "Login page was not loaded.");
        loginPage.login("ohta@i.ua" , "");

        Assert.assertTrue(loginPage.isPageLoaded(), "Login page is not loaded");


    }


    @Test
    public void negativeWithEmptyLoginValuesTest() {


        //Assert.assertTrue(loginPage.isPageLoaded(), "Login page was not loaded.");
        loginPage.login("" , "fghdfghd");

        Assert.assertTrue(loginPage.isPageLoaded(), "Login page is not loaded");


    }


    @Test
    public void negativeWithWrongPasswordValuesTest() {


        Assert.assertTrue(loginPage.isPageLoaded(), "Login page was not loaded.");
        loginPage.login("ohta@i.ua" , "fghdfghd1234");

        ErrorPage errorPage = new ErrorPage(driver);

        Assert.assertEquals(errorPage.isErrorPasswordMessage(), "Это неверный пароль. Повторите попытку или измените пароль.",
                "Successful login with wrong password ");


    }


    @Test
    public void negativeWithShortWrongPasswordValuesTest() {


        Assert.assertTrue(loginPage.isPageLoaded(), "Login page was not loaded.");
        loginPage.login("ohta@i.ua" , "1");

        ErrorPage errorPage = new ErrorPage(driver);

        Assert.assertEquals(errorPage.isErrorPasswordMessage(), "Это неверный пароль. Повторите попытку или измените пароль.",
                "Successful login with wrong password ");


    }


    @Test
    public void negativeWithLongWrongPasswordValuesTest() {


        Assert.assertTrue(loginPage.isPageLoaded(), "Login page was not loaded.");
        loginPage.login("ohta@i.ua" , "Test2148197469832670286708640q02386402864720864702");

        ErrorPage errorPage = new ErrorPage(driver);

        Assert.assertEquals(errorPage.isErrorPasswordMessage(), "Это неверный пароль. Повторите попытку или измените пароль.",
                "Successful login with wrong password ");


    }


    @Test
    public void negativeWithWrongLoginValuesTest() {


        Assert.assertTrue(loginPage.isPageLoaded(), "Login page was not loaded.");
        loginPage.login("ohta" , "fghdfghd");

        ErrorPage errorPage = new ErrorPage(driver);

        Assert.assertEquals(errorPage.isErrorLogInMessage(), "Укажите действительный адрес эл. почты.",
                "Successful login with wrong email");



    }



    @Test
    public void negativeWithWrongEmailValuesTest() {


        Assert.assertTrue(loginPage.isPageLoaded(), "Login page was not loaded.");
        loginPage.login("ohta@ua.ru.ua.ua.ia" , "fghdfghd");

        ErrorPage errorPage = new ErrorPage(driver);

        Assert.assertEquals(errorPage.isErrorLogInMessage(), "Этот адрес эл. почты не зарегистрирован в LinkedIn. Повторите попытку.",
                "Successful login with wrong email");


    }


    @Test
    public void negativeWithWrongNumberValuesTest() {


        Assert.assertTrue(loginPage.isPageLoaded(), "Login page was not loaded.");
        loginPage.login("0501236475" , "fghdfghd");

        ErrorPage errorPage = new ErrorPage(driver);

        Assert.assertEquals(errorPage.isErrorLogInMessage(), "Обязательно включите в номер значок «+» и код своей страны.",
                "Successful login with wrong phone number");


    }


    @Test
    public void negativeWithShortNumberValuesTest() {


        Assert.assertTrue(loginPage.isPageLoaded(), "Login page was not loaded.");
        loginPage.login("+380501" , "fghdfghd");

        ErrorPage errorPage = new ErrorPage(driver);

        Assert.assertEquals(errorPage.isErrorLogInMessage(), "Этот номер телефона не зарегистрирован в LinkedIn. Повторите попытку.",
                "Successful login with wrong phone number");


    }


    @Test
    public void negativeWithLongNumberValuesTest() {


        Assert.assertTrue(loginPage.isPageLoaded(), "Login page was not loaded.");
        loginPage.login("+380501982365479283560295610896392865205967095376209260298639" , "fghdfghd");

        ErrorPage errorPage = new ErrorPage(driver);

        Assert.assertEquals(errorPage.isErrorLogInMessage(), "Этот номер телефона не зарегистрирован в LinkedIn. Повторите попытку.",
                "Successful login with wrong phone number");


    }

}

