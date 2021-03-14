package veroxosAutomator;

import dataTransferObjects.JuniorDeveloper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import veroxosWebConstants.HTMLIdentifiers;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactFormHandler {

    private static final String VEROXOS_URL= "https://www.veroxos.com/";

    private static final String DRIVER_TYPE = "webdriver.chrome.driver";

    private static final String CHROME_DRIVER_PATH = "drivers/chromedriver.exe";

    private static final int WAIT_IN_SECONDS = 10;

    private final WebDriver driver;

    private final JuniorDeveloper developer;

    private final WebDriverWait driverInterrupt;

    /**
     *
     * @param developer - developer data object
     */
    public ContactFormHandler(JuniorDeveloper developer){
        System.setProperty(DRIVER_TYPE, CHROME_DRIVER_PATH);
        this.developer = developer;
        this.driver = new ChromeDriver();
        this.driverInterrupt = new WebDriverWait(this.driver, WAIT_IN_SECONDS);
    }

    /**
     *
     * @param chromeDriverPath - path to driver executables
     * @param developer - developer data object
     */
    public ContactFormHandler(String chromeDriverPath, JuniorDeveloper developer){
        System.setProperty(DRIVER_TYPE, chromeDriverPath);
        this.developer = developer;
        this.driver = new ChromeDriver();
        this.driverInterrupt = new WebDriverWait(this.driver, WAIT_IN_SECONDS);
    }

    public void initialisePageAndSelenium() {
        driver.get(VEROXOS_URL);
        driver.manage().window().setSize(new Dimension(1500, 1200));
        driverInterrupt.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText(HTMLIdentifiers.HOME_CONTACT_LINK_TEXT)));
    }

    public void submitContactForm(){
        try{
            fillVeroxosContactForm();
            driver.findElement(By.xpath(HTMLIdentifiers.CONTACT_SUBMIT_FORM_SPAN_IDENTIFIER)).click();
        }catch (Exception e){
            System.out.println("Ooops something went wrong");
            System.out.println(e.getMessage());
            System.exit(0);
        } finally {
            System.out.println("Contact Form has been successfully submitted to Veroxos");
        }
    }

    private void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = driver1 -> ((JavascriptExecutor) driver1).executeScript("return document.readyState").equals("complete");
        WebDriverWait wait = new WebDriverWait(driver, WAIT_IN_SECONDS);
        wait.until(pageLoadCondition);
    }

    private void fillVeroxosContactForm(){
        driver.findElement(By.linkText(HTMLIdentifiers.HOME_CONTACT_LINK_TEXT)).click();
        waitForLoad(driver);
        driver.findElement(By.id(HTMLIdentifiers.CONTACT_FULL_NAME_FIELD_ID)).sendKeys(this.developer.getName());
        driver.findElement(By.id(HTMLIdentifiers.CONTACT_JOB_TITLE_FIELD_ID)).sendKeys(this.developer.getJobPosition());
        driver.findElement(By.id(HTMLIdentifiers.CONTACT_ORGANISATION_FIELD_ID)).sendKeys(this.developer.getCompany().getName());
        driver.findElement(By.id(HTMLIdentifiers.CONTACT_PHONE_FIELD_ID)).sendKeys(this.developer.getPhone());
        driver.findElement(By.id(HTMLIdentifiers.CONTACT_EMAIL_FIELD_ID)).sendKeys(this.developer.getEmail());
        driver.findElement(By.id(HTMLIdentifiers.CONTACT_MESSAGE_FIELD_ID)).sendKeys(this.developer.getAutomatedMessage());
    }
}
