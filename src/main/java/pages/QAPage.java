package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.SleeperUtils;

import java.time.Duration;

public class QAPage {
    WebDriver driver;

    @FindBy(id = "select2-filter-by-location-container")
    private WebElement locationFilter;

    @FindBy( id = "select2-filter-by-location-result-dvqr-Istanbul, Turkiye")
    private WebElement locationIstanbul;

    @FindBy(id = "select2-filter-by-department-container")
    private WebElement departmentFilter;

    @FindBy( id = "select2-filter-by-department-result-i017-Quality Assurance")
    private WebElement departmentQa;

    @FindBy(xpath = "//p[contains(text(),'Senior Software')]")
    private WebElement jobTitle;

    @FindBy(xpath = "//span[contains(text(),'Quality Assurance')]")
    private WebElement jobSubTitle;

    @FindBy(xpath = "//div[contains(text(),'Istanbul, Turkiye')]")
    private WebElement jobLocation;

    public QAPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void filterJobs() {
        SleeperUtils.wait(5);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Actions actions = new Actions(driver);

        WebElement locationFilter = wait.until(ExpectedConditions.elementToBeClickable(By.id("select2-filter-by-location-container")));
        actions.moveToElement(locationFilter).click().perform();

        WebElement locationIstanbul = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(@class, 'select2-results__option') and text()='Istanbul, Turkiye']")));
        actions.moveToElement(locationIstanbul).click().perform();

    }

    public void verifyJobsDisplayed() {
        Assert.assertTrue(jobTitle.isDisplayed(), "Filtered job title is not displayed.");
        Assert.assertTrue(jobSubTitle.isDisplayed(), "Filtered job subtitle is not displayed.");
        Assert.assertTrue(jobLocation.isDisplayed(), "Filtered job location is not displayed.");

    }
}