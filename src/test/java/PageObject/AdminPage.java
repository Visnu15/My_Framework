package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdminPage {

    public WebDriver driver;

    public AdminPage(WebDriver d){
        driver = d;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h6[text()='Admin']")
    WebElement admintitle;

    public WebElement admintitle(){
        return admintitle;
    }

    @FindBy(xpath = "//button[text()=' Add ']")
    WebElement add;

    public WebElement add(){
        return add;
    }

    @FindBy(xpath = "//h6[text()='Add User']")
    WebElement addUser;

    public WebElement addUser(){
        return addUser;
    }

    @FindBy(xpath = "(//div[contains(@class,'oxd-select-text')])[3]")
    WebElement dropdown;

    public WebElement dropdown(){
        return dropdown;
    }

    @FindBy(xpath = "//div[@role='listbox']//span")
    List<WebElement> option;

    public List<WebElement> userRoleOption(){
        return option;
    }

    public List<WebElement> statusOption(){
        return option;
    }

    @FindBy(xpath = "(//div[contains(@class,'oxd-select-text')])[6]")
    WebElement dropdown2;

    public WebElement dropdown2(){
        return dropdown2;
    }

//    @FindBy(xpath = "//div[@role='option']/span[text()='Enabled']")
//    WebElement optionStatus;
//
//    public WebElement optionStatus(){
//        return optionStatus;
//    }

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement employeeName;

    public WebElement employeeName(){
        return employeeName;
    }

    @FindBy(xpath = "(//div[@role='listbox']//span)[1]")
    WebElement employeeNameOption;

    public WebElement employeeNameOption(){
        return employeeNameOption;
    }

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    WebElement username;

    public WebElement username(){
        return username;
    }

    @FindBy(xpath = "(//input[@type='password'])[1]")
    WebElement password;

    public WebElement password(){
        return password;
    }

    @FindBy(xpath = "(//input[@type='password'])[2]")
    WebElement confirmPassword;

    public WebElement confirmPassword(){
        return confirmPassword;
    }

    @FindBy(xpath = "//button[text()=' Save ']")
    WebElement save;

    public WebElement save(){
        return save;
    }

    @FindBy(xpath = "//p[text()='Successfully Saved']")
    WebElement saveVerify;

    public WebElement saveVerify(){
        return saveVerify;
    }
}
