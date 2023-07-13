import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestRunner extends Setup {
    @Test
    public void doLogin() {
        LoginPage loginPage = new LoginPage(driver);
        driver.get("https://opensource-demo.orangehrmlive.com/");
        loginPage.doLogin("Admin", "admin123");
        WebElement headerTxt = driver.findElement(By.tagName("h6"));
        String actual_header = headerTxt.getText();
        String expected_header = "Dashboard";
        Assert.assertEquals(actual_header,expected_header);
        WebElement profileImage = driver.findElement(By.className("oxd-userdropdown-img"));
        Assert.assertTrue(profileImage.isDisplayed());
    }
}
