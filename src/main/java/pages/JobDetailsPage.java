package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.SleeperUtils;

import java.time.Duration;

public class JobDetailsPage {
    WebDriver driver;

    @FindBy(xpath = "(//p[contains(text(),'Senior Software')])[1]")
    private WebElement jobTitle;

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
        //SleeperUtils.wait(5);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Actions actions = new Actions(driver);

        WebElement jobTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Senior Software')]")));
        actions.moveToElement(jobTitle).perform();

        WebElement viewRoleButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(text(), 'View Role')])[1]")));
        actions.moveToElement(viewRoleButton).click().perform();

        //viewRoleButton.click();
    }
}