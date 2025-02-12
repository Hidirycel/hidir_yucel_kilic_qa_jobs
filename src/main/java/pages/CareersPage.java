package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CareersPage {
    WebDriver driver;

    @FindBy(xpath = "//h3[contains(text(), 'Our Locations')]")
    private WebElement locationsSection;

    @FindBy(xpath = "//h2[contains(text(), 'Life at Insider')]")
    private WebElement lifeAtInsiderSection;

    @FindBy(xpath = "//a[contains(text(), 'See all teams')]")
    private WebElement teamsSection;

    @FindBy(xpath = "//a[contains(text(), 'See all QA jobs')]")
    private WebElement allQaJobs;

    public CareersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyCareerPageLoaded() {
        String currentUrl=driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/careers"),"The URL does not contain '/careers'");
        Assert.assertTrue(locationsSection.isDisplayed(), "Locations section is missing.");
        Assert.assertTrue(teamsSection.isDisplayed(), "Teams section is missing.");
        Assert.assertTrue(lifeAtInsiderSection.isDisplayed(), "Life at Insider section is missing.");
    }

    public void goToQAJobs() {
        driver.get("https://useinsider.com/careers/quality-assurance/");
        allQaJobs.click();

    }
}