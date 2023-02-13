package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage extends BasePage{
    public NavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getHomeLink(){
        return driver.findElement(By.xpath("//a[contains(@class,'v-btn--active')]"));
    }
    public WebElement getAboutLink(){
        return driver.findElement(By.xpath("//a[contains(@class,'btnAbout')]"));
    }
    public WebElement getmyProfileLink(){
        return driver.findElement(By.xpath("//a[contains(@class,'btnProfile')]"));
    }
    public WebElement getAdminButton(){
        return driver.findElement(By.xpath("//button[contains(@class, 'btnAdmin')]"));
    }
    public WebElement getCitiesButton() {
        return driver.findElement(By.xpath("//div[contains(@class, 'v-menu__content')]//a[1]"));
    }
    public WebElement getUsersDropDownLink() {
        return driver.findElement(By.xpath("//div[contains(@class, 'v-menu__content')]//a[2]"));
    }
    public WebElement getLogoutButton() {
        return driver.findElement(By.xpath("//button[contains(@class, 'btnLogout')]"));
    }

    public WebElement getLoginLink() {
        return driver.findElement(By.xpath("//a[contains(@class, 'btnLogin')]"));
    }

    public WebElement getSignUpButton() {
        return driver.findElement(By.xpath("//div[contains(@class, 'v-toolbar__items')]/a[4]"));
    }

    public WebElement getLanguageButton() {
        return driver.findElement(By.xpath("//button[contains(@class, 'btnLocaleActivation')]"));
    }

    public WebElement getEnglishLanguage() {
        return driver.findElement(By.xpath("//div[contains(@class, 'v-menu__content')]/div/div[1]"));
    }

    public WebElement getSpanishLanguage() {
        return driver.findElement(By.xpath("//div[contains(@class, 'v-menu__content')]/div/div[2]"));
    }

    public WebElement getFrenchLanguage() {
        return driver.findElement(By.xpath("//div[contains(@class, 'v-menu__content')]/div/div[3]"));
    }

    public WebElement getChineseLanguage() {
        return driver.findElement(By.xpath("//div[contains(@class, 'v-menu__content')]/div/div[4]"));
    }
    public WebElement getUkrainianLanguage() {
        return driver.findElement(By.xpath("//div[contains(@class, 'v-menu__content')]/div/div[5]"));
    }

}
