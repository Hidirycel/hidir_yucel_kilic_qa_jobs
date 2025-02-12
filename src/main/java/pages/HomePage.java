package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
    WebDriver driver;

    @FindBy(css = "img[alt='insider_logo']")
    private WebElement logo;

    @FindBy(xpath = "//a[contains(text(), 'Company')]")
    private WebElement companyMenu;


    @FindBy(css = "a.dropdown-sub[href^='https://useinsider.com/careers']")
    private WebElement careersOption;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyHomePageLoaded() {
        Assert.assertTrue(logo.isDisplayed(), "Home page did not load successfully.");
    }

    public void navigateToCareers() {
        companyMenu.click();
        careersOption.click();
    }
}