package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import utils.WebDriverManagerUtil;

public class InsiderTest {
    private WebDriver driver;
    private HomePage homePage;
    private CareersPage careersPage;
    private QAPage qaPage;
    private JobDetailsPage jobDetailsPage;

    @BeforeClass
    public void setup() {
        driver = WebDriverManagerUtil.getDriver();
        homePage = new HomePage(driver);
        careersPage = new CareersPage(driver);
        qaPage = new QAPage(driver);
        jobDetailsPage = new JobDetailsPage(driver);
    }

    @Test
    public void testQAJobFilter() {
        driver.get("https://useinsider.com/");
        homePage.verifyHomePageLoaded();
        homePage.navigateToCareers();

        careersPage.verifyCareerPageLoaded();
        careersPage.goToQAJobs();

        qaPage.filterJobs();
        qaPage.verifyJobsDisplayed();
    }

    @Test
    public void testQAJobDetails() {
        jobDetailsPage.openJobApplication();
        jobDetailsPage.verifyJobDetails();
    }

    @AfterClass
    public void tearDown() {
        WebDriverManagerUtil.quitDriver();
    }
}