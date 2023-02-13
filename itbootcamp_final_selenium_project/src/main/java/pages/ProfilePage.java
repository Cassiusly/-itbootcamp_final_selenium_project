package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProfilePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor jsExecutor;

    public ProfilePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebElement getEmailInput() {

        return driver.findElement(By.id("email"));
    }

    public WebElement getNameInput() {
        return driver.findElement(By.id("name"));
    }

    public WebElement getPhoneInput() {
        return driver.findElement(By.id("phone"));
    }

    public WebElement getCityInput() {
        return driver.findElement(By.id("city"));
    }

    public WebElement getCountryInput() {
        return driver.findElement(By.id("country"));
    }

    public WebElement getTwitterUrlInput() {
        return driver.findElement(By.id("urlTwitter"));
    }

    public WebElement getGitUrlInput() {
        return driver.findElement(By.id("urlGitHub"));
    }

    //Waiter for progress bar to get invisible
    public void waitForProgressBar() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath
                ("//div[contains(@class, 'v-card__text')]")));
    }

    public WebElement getCityFromDropDown() {
        return driver.findElement(By.xpath
                ("//div[contains(text(), 'Bucaramanga')]"));
    }

    public WebElement getSaveButton() {
        return driver.findElement(By.xpath
                ("//button[contains(@class, 'btnSave')]"));
    }


}

