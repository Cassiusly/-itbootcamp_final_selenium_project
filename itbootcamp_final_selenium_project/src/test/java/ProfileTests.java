import jdk.jfr.Description;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest {

    @Test(priority = 10)
    @Description("Test #1: Visits the profile page")
    public void visitTheProfilePage() throws InterruptedException {
        navPage.getLoginLink().click();
        loginPage.getEmailInput().sendKeys("admin@admin.com");
        loginPage.getPasswordInput().sendKeys("12345");
        loginPage.getLoginButton().click();
        navPage.getmyProfileLink().click();
        String actualUrlResult = driver.getCurrentUrl();
        String expectedUrlResult = "/profile";
        Assert.assertTrue(actualUrlResult.contains(expectedUrlResult), "URL should contain '/profile'");

        profilePage.waitForProgressBar();

        String actualEmailResult = profilePage.getEmailInput().getAttribute("value");
        String expectedEmailResult = "admin@admin.com";
        Assert.assertEquals(actualEmailResult, expectedEmailResult, "Email value should be 'admin@admin.com'");
        navPage.getLogoutButton().click();
    }
    @Test (priority = 20)
    @Description("Test #2: Checks input types")
    public void checkInputTypes() {
        navPage.getLoginLink().click();
        loginPage.getEmailInput().sendKeys("admin@admin.com");
        loginPage.getPasswordInput().sendKeys("12345");
        loginPage.getLoginButton().click();
        navPage.getmyProfileLink().click();

        // Waiter for progress bar to get invisible
        profilePage.waitForProgressBar();
        String actualEmailType = profilePage.getEmailInput().getAttribute("type");
        String expectedEmailType = "email";
        Assert.assertEquals(actualEmailType, expectedEmailType, "Error: Email attribute 'type' should be 'email'");

        String actualEmailDisabled = profilePage.getEmailInput().getAttribute("disabled");
        String expectedEmailDisabled = "true";
        Assert.assertEquals(actualEmailDisabled, expectedEmailDisabled,
                "Error: Email attribute should be 'disabled'");

        String actualNameType = profilePage.getNameInput().getAttribute("type");
        String expectedNameType = "text";
        Assert.assertEquals(actualNameType, expectedNameType,
                "Error: Name attribute 'type' should be 'text'");

        String actualCityType = profilePage.getCityInput().getAttribute("type");
        String expectedCityType = "text";
        Assert.assertEquals(actualCityType, expectedCityType,
                "Error: City attribute 'type' should be 'text'");

        String actualCountryType = profilePage.getCountryInput().getAttribute("type");
        String expectedCountryType = "text";
        Assert.assertEquals(actualCountryType, expectedCountryType,
                "Error: Country attribute 'type' should be 'text'");

        String actualPhoneType = profilePage.getPhoneInput().getAttribute("type");
        String expectedPhoneType = "tel";
        Assert.assertEquals(actualPhoneType, expectedPhoneType,
                "Error: Phone attribute 'type' should be 'tel'");

        String actualGitType = profilePage.getGitUrlInput().getAttribute("type");
        String expectedGitType = "url";
        Assert.assertEquals(actualGitType,expectedGitType,
                "Error: Git input attribute 'type' should be 'url'");

        String actualTwitterType = profilePage.getTwitterUrlInput().getAttribute("type");
        String expectedTwitterType = "url";
        Assert.assertEquals(actualTwitterType,expectedTwitterType,
                "Error: Twitter input attribute 'type' should be 'url'");

        navPage.getLogoutButton().click();
    }

    @Test(priority = 30)
    @Description("Test #3: Edits profile")
    public void editProfile() throws InterruptedException {
        navPage.getLoginLink().click();
        loginPage.getEmailInput().sendKeys("admin@admin.com");
        loginPage.getPasswordInput().sendKeys("12345");
        loginPage.getLoginButton().click();
        navPage.getmyProfileLink().click();
        profilePage.waitForProgressBar();

        // Clear method doesn't work
        profilePage.getNameInput().sendKeys(Keys.CONTROL, "A");
        profilePage.getNameInput().sendKeys(Keys.BACK_SPACE);
        profilePage.getPhoneInput().sendKeys(Keys.CONTROL, "A");
        profilePage.getPhoneInput().sendKeys(Keys.BACK_SPACE);
        profilePage.getCityInput().sendKeys(Keys.CONTROL, "A");
        profilePage.getCityInput().sendKeys(Keys.BACK_SPACE);
        profilePage.getCountryInput().sendKeys(Keys.CONTROL, "A");
        profilePage.getCountryInput().sendKeys(Keys.BACK_SPACE);
        profilePage.getTwitterUrlInput().sendKeys(Keys.CONTROL, "A");
        profilePage.getTwitterUrlInput().sendKeys(Keys.BACK_SPACE);
        profilePage.getGitUrlInput().sendKeys(Keys.CONTROL, "A");
        profilePage.getGitUrlInput().sendKeys(Keys.BACK_SPACE);

        profilePage.getNameInput().sendKeys("Anita Nestorovic");
        profilePage.getPhoneInput().sendKeys("+381612345678");
        profilePage.getCityInput().sendKeys("Bucaramanga");
        profilePage.getCityInput().sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        profilePage.getCountryInput().sendKeys("Colombia");
        profilePage.getTwitterUrlInput().sendKeys("https://twitter.com/profile/milan1232");
        profilePage.getGitUrlInput().sendKeys("https://github.com/Cassiusly");

        profilePage.getSaveButton().click();

        wait.until(webDriver -> messagePopUpPage.successDialog().isDisplayed());
        String actualResult = messagePopUpPage.getProfileSavedPopUp().getText();
        String expectedResult = "Profile saved successfuly";
        Assert.assertTrue(actualResult.contains(expectedResult),
                "Error: Popup should be 'Profile saved successfully'");
        String actualEmailValue = profilePage.getEmailInput().getAttribute("value");
        String expectedEmailValue = "admin@admin.com";
        Assert.assertEquals(actualEmailValue, expectedEmailValue,
                "Error: Email attribute 'value' should be 'admin@admin.com'");

        String actualNameValue = profilePage.getNameInput().getAttribute("value");
        String expectedNameValue = "Anita Nestorovic";
        Assert.assertEquals(actualNameValue, expectedNameValue,
                "Error: Name attribute 'type' should be 'Anita Nestorovic'");

        String actualCityValue = profilePage.getCityInput().getAttribute("value");
        String expectedCityValue = "Bucaramanga";
        Assert.assertEquals(actualCityValue, expectedCityValue,
                "Error: City attribute 'value' should be 'Bucaramanga'");

        String actualCountryValue = profilePage.getCountryInput().getAttribute("value");
        String expectedCountryValue = "Colombia";
        Assert.assertEquals(actualCountryValue, expectedCountryValue,
                "Error: Country attribute 'value' should be 'Colombia'");

        String actualPhoneValue = profilePage.getPhoneInput().getAttribute("value");
        String expectedPhoneValue = "+381612345678";
        Assert.assertEquals(actualPhoneValue, expectedPhoneValue,
                "Error: Phone attribute 'value' should be '+381612345678'");

        String actualGitValue = profilePage.getGitUrlInput().getAttribute("value");
        String expectedGitValue = "https://github.com/cassiusly";
        Assert.assertEquals(actualGitValue,expectedGitValue,
                "Error: Git input attribute 'value' should be 'https://github.com/cassiusly'");

        String actualTwitterValue = profilePage.getTwitterUrlInput().getAttribute("value");
        String expectedTwitterValue = "https://twitter.com/profile/milan1232";
        Assert.assertEquals(actualTwitterValue,expectedTwitterValue,
                "Error: Twitter input attribute 'type' should be 'https://twitter.com/profile/milan1232");

        navPage.getLogoutButton().click();
    }
}
