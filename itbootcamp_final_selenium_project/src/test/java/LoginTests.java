import jdk.jfr.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTests extends BaseTest{
    @Test(priority = 1)
    @Description("Test #1: Visits the login page")
    public void visitTheLoginPage() {
       navPage.getLanguageButton().click();
       navPage.getEnglishLanguage().click();
       navPage.getLoginLink().click();

       String actualResult = driver.getCurrentUrl();
       String expectedResult = "/login";
       Assert.assertTrue(actualResult.contains(expectedResult));
    }
    @Test(priority = 2)
    @Description("Test #2: Checks input types")
    public void checkInputTypes() {
       navPage.getLoginLink().click();
       String actualEmailResult =loginPage.getEmailInput().getAttribute("type");
       String expectedEmailResult = "email";
       Assert.assertEquals(actualEmailResult, expectedEmailResult,
               "Error: Attribute 'type' isn't 'email'");

       String actualPasswordResult =loginPage.getPasswordInput().getAttribute("type");
       String expectedPasswordResult = "password";
       Assert.assertEquals(actualPasswordResult, expectedPasswordResult,
               "Error: Attribute 'type' isn't 'password'");
    }

    @Test(priority = 3)
    @Description("Test #3: Displays errors when user does not exist")
    public void displayErrorWhenUserDoesNotExist() throws InterruptedException {

       navPage.getLoginLink().click();
       loginPage.getEmailInput().sendKeys("non-existing-user@gmal.com");
       loginPage.getPasswordInput().sendKeys("password123");
       loginPage.getLoginButton().click();
       messagePopUpPage.waitForUserError();

       String actualResult =messagePopUpPage.getLoginErrorElement().getText();
       String expectedResult = "User does not exists";

       // Assert doesn't work without Thread.sleep
       Thread.sleep(2000);
       Assert.assertTrue(actualResult.contains(expectedResult),
               "Error: User doesn't exist");
    }

    @Test(priority = 4)
    @Description("Test #4: Displays errors when password is wrong")
    public void displayErrorWhenPasswordIsWrong() throws InterruptedException {
       navPage.getLoginLink().click();
       loginPage.getEmailInput().sendKeys("admin@admin.com");
       loginPage.getPasswordInput().sendKeys("password123");
       loginPage.getLoginButton().click();
       messagePopUpPage.waitForUserError();

       String actualResult =messagePopUpPage.getLoginErrorElement().getText();
       String expectedResult = "Wrong password";

       // Assert doesn't work without Thread.sleep
       Thread.sleep(2000);
       Assert.assertTrue(actualResult.contains(expectedResult),
               "Error: Password is incorrect");
    }

    @Test(priority = 5)
    @Description("Test #6: Verifies valid Login inputs.")
    public void validLogin() throws InterruptedException {
       navPage.getLoginLink().click();
       loginPage.getEmailInput().sendKeys("admin@admin.com");
       loginPage.getPasswordInput().sendKeys("12345");
       loginPage.getLoginButton().click();
       wait.until(ExpectedConditions.urlContains("home"));

       String actualResult = driver.getCurrentUrl();
       String expectedResult = "/home";
       Assert.assertTrue(actualResult.contains(expectedResult),
               "Error: URL should contain '/home'");
    }

    @Test(priority = 6)
    @Description("Test #6: Checks Logout button.")
    public void logout() {

       Assert.assertTrue(navPage.getLogoutButton().isDisplayed());
       navPage.getLogoutButton().click();
    }

}
