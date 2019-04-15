import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LinkedInLoginTest {

    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
        loginPage = new LoginPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
    }

    //@AfterMethod
    //public void afterMethod() {
      //  driver.quit();
    //}

    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
                { "ohta@i.ua", "fghdfghd" }
        };
    }


    @Test(dataProvider = "validDataProvider")
    public void successfulLoginTest(String userEmail, String userPassword) {


        Assert.assertTrue(loginPage.isPageLoaded(), "Login page was not loaded.");
        HomePage homePage = loginPage.login(userEmail , userPassword);

        //HomePage homePage = new HomePage(driver);

        Assert.assertTrue(homePage.isPageLoaded(), "Home page is not loaded");



        SearchPage searchPage = new SearchPage(driver);


        String searchTerm = "HR";
        /*WebElement searchField = driver.findElement(By.xpath("//input[@type='text']"));
        searchField.sendKeys(searchTerm);
        searchField.sendKeys((Keys.ENTER));*/

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



        Assert.assertTrue(searchPage.searchPageLoaded(), "Search page is not loaded");

        //Assert.assertTrue(searchPage.isPageLoaded(), "Home page is not loaded");



        List<WebElement> searchResults = driver.findElements(By.xpath("//div[@class='search-result__info pt3 pb4 ph0']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        System.out.println(searchResults.size());

        for (WebElement searchResult : searchResults) {
            String searchResultString = searchResult.getText();
            System.out.println(searchResult.getText());
            //System.out.println(searchResultString);

            if (searchResultString.contains(searchTerm)) {
                System.out.println("SearchTerm found");
            } else {
                System.out.println("SearchTerm not found");
            }
        }

    }

}

