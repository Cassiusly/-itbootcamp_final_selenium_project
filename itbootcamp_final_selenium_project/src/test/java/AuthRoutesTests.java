import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class AuthRoutesTests extends BaseTest{
    private String login;
    private String home;
    private String profile;
    private String adminCities;
    private String adminUsers;

    @BeforeClass
    public void beforeClass() {
        login = "/login";
        home = "/home";
        profile = "/profile";
        adminCities = "/admin/cities";
        adminUsers = "/admin/users";
    }

    @Test(priority = 10)
    @Description("Test #1: Forbids visits to home url if not authenticated")
    public void forbidVisitToHomeUrlIfNotAuthenticated() {
        driver.get(baseUrl + home );
        String actualResult = driver.getCurrentUrl();
        String expectedResult = login;
        Assert.assertTrue(actualResult.contains(expectedResult),
                "Error: URL should contain '/login'");
    }
    @Test(priority =  20)
    @Description("Test #2: Forbids visits to profile url if not authenticated")
    public void forbidVisitToProfileUrlIfNotAuthenticated() {
        driver.get(baseUrl + profile);
        String actualResult = driver.getCurrentUrl();
        String expectedResult = login;
        Assert.assertTrue(actualResult.contains(expectedResult),
                "Error: URL should contain '/login'");
    }

    @Test(priority = 30)
    @Description("Test #3: Forbids visits to admin cities url if not authenticated")
    public void forbidVisitToAdminCitiesUrlIfNotAuthenticated() {
        driver.get(baseUrl + adminCities);
        String actualResult = driver.getCurrentUrl();
        String expectedResult = login;
        Assert.assertTrue(actualResult.contains(expectedResult),
                "Error: URL should contain '/login'");
    }
    @Test(priority = 40)
    @Description("Test #4: Forbids visits to admin users url if not authenticated")
    public void forbitVisitToAdminUsersUrlIfNotAuthenticated() {
        driver.get(baseUrl + adminUsers);
        String actualResult = driver.getCurrentUrl();
        String expectedResult = login;
        Assert.assertTrue(actualResult.contains(expectedResult),
                "Error: URL should contain '/login'");
    }
}
