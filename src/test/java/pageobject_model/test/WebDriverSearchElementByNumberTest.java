package pageobject_model.test;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.page.IkeaHomePage;


public class WebDriverSearchElementByNumberTest {
    private WebDriver driver = new ChromeDriver();
    @BeforeMethod (alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void CommonSearchTest(){

        int expectedResult =  new IkeaHomePage(driver)
                .openPage()
                .searchForTerms("205.221.07")
                .countResultsNumberWithSearchTerm();


        Assert.assertEquals(expectedResult, 1, "Search result is not searchable!");

    }
    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
