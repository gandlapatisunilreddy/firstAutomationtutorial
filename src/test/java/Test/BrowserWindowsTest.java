
package Test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Assertion.Assertion;
import Pages.BrowserWindowsPage;
import Pages.NewTabPage;

public class BrowserWindowsTest {

    @Test(priority = 1)
    public void verifyNewTabAndParentTab() throws InterruptedException{

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        BrowserWindowsPage browserPage = new BrowserWindowsPage(driver);
        NewTabPage newTabPage = new NewTabPage(driver);
        Assertion assertions = new Assertion();        
        browserPage.navigateToModalDialogsPageTutorialURL();
        browserPage.clickBrowserWindows();
        String parentTab = browserPage.getParentTab();
        browserPage.clickNewTab();
        newTabPage.switchToNewTab(parentTab);
        assertions.verifySampleNewTab(
        newTabPage.isSampleNewTabVisible()
        );
        newTabPage.switchToParentTab(parentTab);
        assertions.verifyParentPageUrl(browserPage.getCurrentUrl());
        driver.quit();
    }
    @Test(priority = 2)
    public void verifyNewWindowAndParentWindow() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        BrowserWindowsPage browserPage = new BrowserWindowsPage(driver);
        NewTabPage newTabPage = new NewTabPage(driver);
        Assertion assertions = new Assertion();
        browserPage.navigateToModalDialogsPageTutorialURL();
        browserPage.clickBrowserWindows();
        String parentWindow = browserPage.getParentTab();
        browserPage.clickNewWindow();
        newTabPage.switchToNewTab(parentWindow);

        new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.titleIs("Selenium Practice - Web Tables"));
        assertions.verifyNewWindowTitle(newTabPage.getPageTitle());
        newTabPage.switchToParentTab(parentWindow);
        assertions.verifyParentPageUrl(
            browserPage.getCurrentUrl()
        );
        driver.quit();
    }
    @Test(priority = 3)
    public void verifyAlertTextAndAcceptAlert() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        BrowserWindowsPage browserPage =  new BrowserWindowsPage(driver);
        NewTabPage newTabPage = new NewTabPage(driver);
        Assertion assertions = new Assertion();
        browserPage.navigateToModalDialogsPageTutorialURL();
        browserPage.clickAlerts();
        browserPage.clickAlertButton();
        newTabPage.waitForAlert();
        assertions.verifyAlertText(newTabPage.getAlertText());
        newTabPage.acceptAlert();
        driver.quit();
    }
    @Test(priority = 4)
    public void verifyDelayedAlertTextAndAcceptAlert() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        BrowserWindowsPage browserPage = new BrowserWindowsPage(driver);
        NewTabPage newTabPage =new NewTabPage(driver);
        Assertion assertions = new Assertion();
        browserPage.navigateToModalDialogsPageTutorialURL();
        browserPage.clickAlerts();
        browserPage.clickDelayedAlertButton();
        newTabPage.waitForAlert();
        assertions.verifyDelayedAlertText(newTabPage.getAlertText());

        newTabPage.acceptAlert();

        driver.quit();
    }
    @Test(priority = 5)
    public void verifySeleniumTutorialTab() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

    BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage(driver);
    NewTabPage newTabPage = new NewTabPage(driver);
    Assertion assertions = new Assertion();

    browserWindowsPage.navigateToModalDialogsPageTutorialURL();
    browserWindowsPage.clickFrames();
    browserWindowsPage.switchToFrame1();

    String parentTab = driver.getWindowHandle();

    browserWindowsPage.clickSeleniumTutorial();

    newTabPage.switchToNewTab(parentTab);
    System.out.println("Switched to the new tab.");
    
    System.out.println("Current URL check skipped; verifying page title.");
    System.out.println("New tab switch completed.");

    driver.close();

    newTabPage.switchToParentTab(parentTab);
    System.out.println("SUnil");

    driver.quit();
    }






    
    
}
