
package Pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewTabPage {

    // WebDriver and wait
    private WebDriver driver;
    private WebDriverWait wait;

    // New Tab locator
    private By sampleNewTabText = By.xpath("//*[contains(., 'Sample New Tab')]");


    // Constructor
    public NewTabPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(
                driver, Duration.ofSeconds(10)
        );
    }


    // Tab actions
    public void switchToNewTab(String parentTab) {
        wait.until(
            ExpectedConditions.numberOfWindowsToBe(2)
        );

        
        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(parentTab)) {
                driver.switchTo().window(tab);
                return;
            }
        }

        throw new IllegalStateException(
                "New tab was not found."
        );
    }

    public void switchToParentTab(String parentTab) {
        driver.switchTo().window(parentTab);
    }


    // Page verification and information
    public boolean isSampleNewTabVisible() {
        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                sampleNewTabText
            )
        ).isDisplayed();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }


    // Alert actions — review for consolidation
    public void waitForAlert() {
        wait.until(
            ExpectedConditions.alertIsPresent()
        );
    }

    public String getAlertText() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }
}
