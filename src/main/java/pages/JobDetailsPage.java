package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class JobDetailsPage {
    WebDriver driver;

    @FindBy(xpath = "(//a[contains(text(), 'View Role')])[1]")
    private WebElement viewRoleButton;
    public JobDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyJobDetails() {
        String expectedUrl="https://jobs.lever.co/useinsider/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl), "Redirected job url does not match." );

    }

    public void openJobApplication() {
        viewRoleButton.click();

    }
}