package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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
        locationFilter.click();
        locationIstanbul.click();
        departmentFilter.click();
        departmentQa.click();
    }

    public void verifyJobsDisplayed() {
        Assert.assertTrue(jobTitle.isDisplayed(), "Filtered job title is not displayed.");
        Assert.assertTrue(jobSubTitle.isDisplayed(), "Filtered job subtitle is not displayed.");
        Assert.assertTrue(jobLocation.isDisplayed(), "Filtered job location is not displayed.");

    }
}