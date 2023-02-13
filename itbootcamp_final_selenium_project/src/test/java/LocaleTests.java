import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.*;
import java.io.IOException;
public class LocaleTests extends BaseTest{

    @Test(priority = 10)
    @Description("Test #1: Set locale to ES")
    public void setLocaleToEs() throws IOException {

        navPage.getLanguageButton().click();
        navPage.getSpanishLanguage().click();
        Assert.assertTrue(driver.getPageSource().contains("Página de aterrizaje"),
                "Error: Header should contain 'Página de aterrizaje' text!");

    }
    @Test(priority = 20)
    @Description("Test #2: Set locale to EN")
    public void setLocaleToEn(){
        navPage.getLanguageButton().click();
        navPage.getEnglishLanguage().click();
        Assert.assertTrue(driver.getPageSource().contains("Landing"),
                "Error: Header should contain 'Landing' text!");
    }
    @Test(priority = 30)
    @Description("Test #3: Set locale to CN")
    public void setLocaleToCn(){
        navPage.getLanguageButton().click();
        navPage.getChineseLanguage().click();
        Assert.assertTrue(driver.getPageSource().contains("首页"),
                "Error: Header should contain '首页' text!");
    }
    @Test(priority = 40)
    @Description("Test #4: Set locale to FR")
    public void setLocaleToFr(){
        navPage.getLanguageButton().click();
        navPage.getFrenchLanguage().click();
        Assert.assertTrue(driver.getPageSource().contains("Page d'atterrissage"),
                "Error: Header should contain 'Page d'atterrissage' text!");
    }
    @Test(priority = 50)
    @Description("Test #5: Set locale to UA")
    public void setLocaleToUa(){
        navPage.getLanguageButton().click();
        navPage.getUkrainianLanguage().click();
        Assert.assertTrue(driver.getPageSource().contains("Лендінг"),
                "Error: Header should contain 'Лендінг' text!");
    }

}
