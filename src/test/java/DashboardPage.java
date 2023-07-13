import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
    @FindBy(className = "oxd-userdropdown-name")
    public WebElement btnProfileTab;
    @FindBy(partialLinkText = "Logout")
    public WebElement logoutBtn;

    public DashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public void doLogout(){
        btnProfileTab.click();
        logoutBtn.click();
    }
}
