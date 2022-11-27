package pageobject_model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class IkeaSearchResult extends AbstractPage {


    public IkeaSearchResult(WebDriver driver){
        super(driver);
    }



    public int countResultsNumberWithSearchTerm() {
        List<WebElement> resultsNumberWithSearchTerm = driver.findElements(By.xpath("//*[@id=\"contentWrapper\"]/div[2]/div/div[2]"));
        return resultsNumberWithSearchTerm.size();
    }


    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException("Please 'think twice' whether tou need");
    }
}
