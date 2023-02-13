import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
public class SignupTests extends BaseTest{

    @Test(priority = 10)
    @Description("Test #1: Visits the signup page")
    public void visitTheSignupPage() {
        navPage.getSignUpButton().click();
        String actualResult = driver.getCurrentUrl();
        String expectedResult = "/signup";
        Assert.assertTrue(actualResult.contains(expectedResult),
                "Error: URL route should be '/signup'");
    }

    @Test(priority = 20)
    @Description("Test #2: Checks input types")
    public void checkInputTypes() {
        navPage.getSignUpButton().click();
        String actualEmailResult = signupPage.getEmailInput().getAttribute("type");
        String actualPasswordResult = signupPage.getPasswordInput().getAttribute("type");
        String expectedEmailResult = "email";
        String expectedPasswordResult = "password";
        Assert.assertEquals(actualEmailResult, expectedEmailResult,
                "Error: Attribute 'type' should be 'email'");
        Assert.assertEquals(actualPasswordResult, expectedPasswordResult,
                "Error: Attribute 'type' should be 'password'");
    }
    @Test(priority = 30)
    @Description("Test #3: Displays errors when user already exists")
    public void displayErrorWhenUserAlreadyExist() {
        navPage.getSignUpButton().click();
        String actualUrlResult = driver.getCurrentUrl();
        String expectedUrlResult = "/signup";
        Assert.assertTrue(actualUrlResult.contains(expectedUrlResult),
                "Error: URL route should be '/signup'");
        signupPage.getNameInput().sendKeys("Another User");
        signupPage.getEmailInput().sendKeys("admin@admin.com");
        signupPage.getPasswordInput().sendKeys("12345");
        signupPage.getConfirmPasswordInput().sendKeys("12345");
        signupPage.getSignupButton().click();
        messagePopUpPage.waitForUserError();
        String actualErrorResult = messagePopUpPage.getLoginErrorElement().getText();
        String expectedErrorResult = "E-mail already exists";
        Assert.assertEquals(actualErrorResult, expectedErrorResult,
                "Error: Message popup should be 'E-mail already exists'");
        String actualUrlAfterResult = driver.getCurrentUrl();
        String expectedUrlAfterResult = "/signup";
        Assert.assertTrue(actualUrlAfterResult.contains(expectedUrlAfterResult),
                "Error: URL route should be '/signup'");
    }
    @Test(priority = 40)
    @Description("Test #4: Signup with trainee's credentials")
    public void signup() throws InterruptedException {
        navPage.getSignUpButton().click();
        signupPage.getNameInput().sendKeys("Anita Nestorovic");
        signupPage.getEmailInput().sendKeys("anita@itbootcamp.rs");
        signupPage.getPasswordInput().sendKeys("12345");
        signupPage.getConfirmPasswordInput().sendKeys("12345");
        signupPage.getSignupButton().click();
        Thread.sleep(2000);
        messagePopUpPage.waitForVerifyError();
        String actualResult = messagePopUpPage.getTextFromVerifyError();
        String expectedResult = "IMPORTANT: Verify your account";
        Assert.assertTrue(actualResult.contains(expectedResult),
                "Error: Dialog should contain 'IMPORTANT: Verify your account'");
        messagePopUpPage.getVerifyCloseButton().click();
        navPage.getLogoutButton().click();
    }
}
