package pageobject_model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShoppingCartPage extends AbstractPage {


    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public int countResultsNumberWithSearchTerm() {
        List<WebElement> resultsNumberWithSearchTerm = driver.findElements(By.id("cart"));
        return resultsNumberWithSearchTerm.size();
    }

    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException("Please 'think twice' whether tou need");
    }
}

