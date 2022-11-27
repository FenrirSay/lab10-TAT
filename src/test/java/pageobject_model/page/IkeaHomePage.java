package pageobject_model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IkeaHomePage extends AbstractPage{

    private static final String HOMEPAGE_URL = "https://www.ikea.lt/lt";

    @FindBy(id = "header_searcher_desktop_input")
    private WebElement searchElement;

    @FindBy(xpath = "//*[@id=\"headerMainToggler\"]/div/div[2]/div[1]/div/div/button")
    private WebElement searchBtn;

    public IkeaHomePage(WebDriver driver){
        super(driver);
    }

    public IkeaHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("header_searcher_desktop_input")));
        return this;
    }

    public IkeaSearchResult searchForTerms(String term){
        searchElement.sendKeys(term);
        searchBtn.click();
        return new IkeaSearchResult(driver);
    }
}
