package pageobject_model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IkeaBillyPage extends AbstractPage{

    private static final String HOMEPAGE_URL = "https://www.ikea.lt/en/products/living-room/shelving-units-systems/bookcases/billy-oxberg-bookcase-with-glass-door-black-brown-spr-19287399";


    @FindBy(xpath = "//*[@id=\"contentWrapper\"]/div/div/div/div[1]/div[2]/div/div[4]/div[3]/button[1]")
    private WebElement AddToShoppingCartBtn;

    @FindBy(xpath = "//*[@id=\"CybotCookiebotDialogBodyLevelButtonAccept\"]")
    private WebElement AgreeButton;


    public IkeaBillyPage(WebDriver driver) {
        super(driver);
    }

    public ShoppingCartPage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"CybotCookiebotDialogBodyLevelButtonAccept\"]")));
        AgreeButton.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"contentWrapper\"]/div/div/div/div[1]/div[2]/div/div[4]/div[3]/button[1]")));
        AddToShoppingCartBtn.click();

        new WebDriverWait(this.driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"modal\"]/div/div/div[3]/div[1]/div/div/button[2]")));
        new WebDriverWait(this.driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"modal\"]/div/div/div[3]/div[1]/div/div/button[2]")));

        new WebDriverWait(this.driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"modal\"]/div/div/div[3]/div[1]/div/div/button[2]")));

        WebElement ShoppingCartBtn = this.driver.findElement(By.xpath("//*[@id=\"modal\"]/div/div/div[3]/div[1]/div/div/button[2]"));;
        ShoppingCartBtn.click();

        return new ShoppingCartPage(this.driver);
    }
}
