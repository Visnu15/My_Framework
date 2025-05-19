package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public WebDriver driver;

    public HomePage(WebDriver d){
        driver = d;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Admin']")
    WebElement Admin;

    public WebElement admin(){
        return Admin;
    }

    @FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
    WebElement profile;

    public WebElement profile(){
        return profile;
    }

    @FindBy(xpath = "//a[text()='Logout']")
    WebElement logout;

    public WebElement logout(){
        return logout;
    }
}
