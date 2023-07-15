import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTestRunner extends Setup {
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test(priority = 1, description = "user can do login")
    public void doLogin() {
        loginPage = new LoginPage(driver);
        driver.get("https://opensource-demo.orangehrmlive.com/");
        loginPage.doLogin("Admin", "admin123");
        WebElement headerTxt = driver.findElement(By.tagName("h6"));
        String actual_header = headerTxt.getText();
        String expected_header = "Dashboard";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actual_header, expected_header);
        WebElement profileImage = driver.findElement(By.className("oxd-userdropdown-img"));
        softAssert.assertTrue(profileImage.isDisplayed());
        softAssert.assertAll();
    }
}
