import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    private WebDriver driver;

    @FindBy(linkText = "https://www.linkedin.com/search/results/all/?keywords=HR&origin=GLOBAL_SEARCH_HEADER")
    private WebElement urlSearchItem;
    @FindBy(xpath = "//input[@type='text']")
    private WebElement searchField;


    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        searchField.sendKeys("HR");
        searchField.sendKeys((Keys.ENTER));

    }

    /*public void search(String searchRequest) {
        searchField.sendKeys(searchRequest);
        searchField.sendKeys((Keys.ENTER));
    }*/


    public boolean searchPageLoaded() {
            return driver.getTitle().contains("LinkedIn");
        }


}