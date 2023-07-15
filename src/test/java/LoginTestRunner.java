import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

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
        Assert.assertEquals(actual_header, expected_header);
        WebElement profileImage = driver.findElement(By.className("oxd-userdropdown-img"));
        Assert.assertTrue(profileImage.isDisplayed());
    }

    @Test(priority = 2, description = "User can view existing user list")
    public void searchEmployeeInfo() throws InterruptedException {
        dashboardPage = new DashboardPage(driver);
        Thread.sleep(2000);
        dashboardPage.menus.get(1).click();
        Thread.sleep(3000);
        String isUserFound = driver.findElements(By.className("oxd-text--span")).get(11).getText();
        Assert.assertTrue(isUserFound.contains("Records Found"));
    }

    @Test(priority = 3, description = "User can search employee by status")
    public void selectEmployeeStatus() throws InterruptedException {
        dashboardPage = new DashboardPage(driver);
        dashboardPage.dropdown.get(0).click();
        Thread.sleep(1000);
        dashboardPage.dropdown.get(0).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        dashboardPage.dropdown.get(0).sendKeys(Keys.ARROW_DOWN);
        dashboardPage.dropdown.get(0).sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector("[type=submit]")).click();
    }
}
