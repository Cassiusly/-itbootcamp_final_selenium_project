package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage extends BasePage{
    public CitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getNewItemButton() {
        return driver.findElement(By.xpath
                ("//div[contains(@class, 'text-right')]/button"));
    }

    public WebElement getSearchInput() {
        return driver.findElement(By.id("search"));
    }

    public void waitForEditNewDialog() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[contains(@class, 'dlgNewEditItem')]")));
    }

    public void waitForDeleteDialog() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[contains(@class, 'v-dialog--active')]/div")));
    }

    public WebElement getSaveButton() {
        return driver.findElement(By.xpath
                ("//button[contains(@class, 'btnSave')]"));

    }

    public WebElement getDeleteButton() {
        return driver.findElement(By.xpath
                ("//button[contains(@class, 'red--text')]"));
    }

    public WebElement getNameInput() {
        return driver.findElement(By.id("name"));

    }

    public void waitForNumberOfRows(int row) {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//table//tr" + "[" + row +"]")));
    }

    public WebElement getTableCell(int row, int cell) {
        return driver.findElement(By.xpath
                ("//table//tr" + "[" + row + "]" + "/td" + "[" + cell + "]"));
    }

    public WebElement getRowEditButton(int row) {
        return driver.findElement(By.xpath
                ("//table//tr" + "[" + row + "]" + "//button[1]"));
    }

    public WebElement getRowDeleteButton(int row) {
        return driver.findElement(By.xpath
                ("//table//tr" + "[" + row + "]" + "//button[2]"));
    }
}
