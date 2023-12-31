import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPage {
    @FindBy(className = "oxd-userdropdown-name")
    public WebElement btnProfileTab;
    @FindBy(partialLinkText = "Logout")
    public WebElement logoutBtn;
    @FindBy(className = "oxd-main-menu-item--name")
    public List<WebElement> menus;
    @FindBy(className = "oxd-select-text-input")
    public  List<WebElement> dropdown;

    public DashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public void doLogout(){
        btnProfileTab.click();
        logoutBtn.click();
    }
}
