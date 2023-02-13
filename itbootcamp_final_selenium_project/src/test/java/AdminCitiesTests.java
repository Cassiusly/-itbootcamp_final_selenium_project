import jdk.jfr.Description;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
public class AdminCitiesTests extends BaseTest {

    @Test(priority = 10)
    @Description("Test #1: Visits the admin cities page and list cities")
    public void visitTheAdminCitiesPageAndListCities() {
        navPage.getLoginLink().click();
        loginPage.getEmailInput().sendKeys("admin@admin.com");
        loginPage.getPasswordInput().sendKeys("12345");
        loginPage.getLoginButton().click();
        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();
        String actualUrlResult = driver.getCurrentUrl();
        String expectedUrlResult = "/admin/cities";
        Assert.assertTrue(actualUrlResult.contains(expectedUrlResult),
                "Error: URL route should be '/admin/cities'");

    }

    @Test(priority = 20)
    @Description("Test #2: Checks input types for create/edit new city")
    public void checkInputTypesForCreateEditNewCity() {
        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitForEditNewDialog();
        String actualResult = citiesPage.getNameInput().getAttribute("type");
        String expectedResult = "text";
        Assert.assertEquals(actualResult, expectedResult,
                "Error: Input type should be 'text'");
    }

    @Test(priority = 30)
    @Description("Test #3: Create new city")
    public void createNewCity() {
        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitForEditNewDialog();
        citiesPage.getNameInput().sendKeys("Anita's city");
        citiesPage.getSaveButton().click();
        wait.until(webDriver -> messagePopUpPage.successDialog().isDisplayed());
        String actualResult = messagePopUpPage.getTextFromUserError();
        String expectedResult = "Saved successfully";
        Assert.assertTrue(actualResult.contains(expectedResult),
                "Error: Popup should be 'Saved successfully'");
    }

    @Test(priority = 40)
    @Description("Test #4: Edit city")
    public void editCity() {
        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();
        citiesPage.getSearchInput().sendKeys("Anita's city");
        citiesPage.waitForNumberOfRows(1);
        citiesPage.getRowEditButton(1).click();
        // Not working with clear() method
        citiesPage.getNameInput().sendKeys(Keys.CONTROL, "A");
        citiesPage.getNameInput().sendKeys(Keys.BACK_SPACE);
        citiesPage.getNameInput().sendKeys("Anita's city Edited");
        citiesPage.getSaveButton().click();
        wait.until(webDriver -> messagePopUpPage.successDialog().isDisplayed());
        String actualResult = messagePopUpPage.getTextFromUserError();
        String expectedResult = "Saved successfully";
        Assert.assertTrue(actualResult.contains(expectedResult),
                "Error: Popup should be 'Saved successfully'");
    }

    @Test(priority = 50)
    @Description("Test #5: Search city")
    public void searchCity() {
        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();
        citiesPage.getSearchInput().sendKeys("Anita's city Edited");
        citiesPage.waitForNumberOfRows(1);
        String actualResult = citiesPage.getTableCell(1, 2).getText();
        String expectedResult = citiesPage.getSearchInput().getAttribute("value");
        Assert.assertEquals(actualResult, expectedResult,
                "Error: Name value should be equal to search value");
    }

    @Test(priority = 60)
    @Description("Test #6: Delete city")
    public void deleteCity() {
        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();
        citiesPage.getSearchInput().sendKeys("Anita's city Edited");
        citiesPage.waitForNumberOfRows(1);
        String actualResult = citiesPage.getTableCell(1, 2).getText();
        String expectedResult = citiesPage.getSearchInput().getAttribute("value");
        Assert.assertEquals(actualResult, expectedResult, "Name value should be equal to search value");
        citiesPage.getRowDeleteButton(1).click();
        citiesPage.waitForDeleteDialog();

        citiesPage.getDeleteButton().click();
        wait.until(webDriver -> messagePopUpPage.successDialog().isDisplayed());
        String actualTextResult = messagePopUpPage.getTextFromUserError();
        String expectedTextResult = "Deleted successfully";
        Assert.assertTrue(actualTextResult.contains(expectedTextResult),
                "Error: Message popup should be 'Deleted successfully'");
    }
}