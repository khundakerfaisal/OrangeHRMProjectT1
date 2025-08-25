package TestRunner;

import Config.BasePage;
import Pages.LoginPages;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

public class LoginTest extends BasePage {

    @Test
    public void doLoginWithValidCred() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        LoginPages loginPages=new LoginPages(driver);
        loginPages.hrmLoginPage("Admin","admin123");
        Thread.sleep(1000);
        String TextExpected=driver.findElement(By.xpath("//span/h6[text()='Dashboard']")).getText();
        String TextActual="Dashboard";
        Assert.assertEquals(TextActual,TextExpected);
        Thread.sleep(1000);
    }

}
