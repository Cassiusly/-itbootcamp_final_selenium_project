package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage extends BasePage {

    public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void waitForUserError() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'v-snack__wrapper')]")));
    }

    public WebElement successDialog() {
        return driver.findElement(By.xpath("//div[contains(@class, 'success')]"));
    }

    public String getTextFromUserError() {
        return driver.findElement(By.xpath("//div[contains(@class, 'success')]/div[1]")).getText();
    }

    public WebElement getLoginErrorElement() {
        return driver.findElement(By.xpath("//div[contains(@class, 'v-snack__content')]//li"));
    }

    public WebElement getErrorButton() {
        return driver.findElement(By.xpath("//div[contains(@class, 'v-snack__content')]//button"));
    }

    public void waitForVerifyError() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'v-dialog--active')]")));
    }

    public String getTextFromVerifyError() {
        return driver.findElement(By.xpath("//div[contains(@class, 'lgVerifyAccount')]")).getText();
    }

    public WebElement getVerifyCloseButton() {
        return driver.findElement(By.xpath("//button[contains(@class, 'btnClose')]"));
    }

    public WebElement getProfileSavedPopUp() {
        return driver.findElement(By.xpath("//div[contains(text(), 'Profile saved successfuly')]"));
    }
}
