import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BadCodeExample {

    public static void main(String[] args) {
        System.out.println("Hello World");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");

        String searchTerm = "Selenium";
        //WebElement searchField = driver.findElement(By.name("q"));
        WebElement searchField = driver.findElement(By.xpath("//input[@name='q']"));
        searchField.sendKeys(searchTerm);
        searchField.sendKeys((Keys.ENTER));
        List<WebElement> searchResults = driver.findElements(By.xpath("//div[@class='srg']/div[@class='g']"));

        System.out.println(searchResults.size());

        for (WebElement searchResult : searchResults) {
            String searchResultString = searchResult.getText();
            System.out.println(searchResult.getText());
            //System.out.println(searchResultString);

            if (searchResultString.toLowerCase().contains(searchTerm.toLowerCase())) {
                System.out.println("SearchTerm found");
            } else {
                System.out.println("SearchTerm not found");
            }
        }


    }

}
