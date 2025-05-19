package PageObject;

import Steps.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage{

    public WebDriver driver;

    public LoginPage(WebDriver d){
        driver = d;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h5[contains(@class,'login-title')]")
    WebElement title;

    public WebElement title(){
        return title;
    }

    @FindBy(xpath = "//input[@name='username']")
    WebElement username;

    public WebElement username(){
        return username;
    }

    @FindBy(xpath = "//input[@name='password']")
    WebElement password;

    public WebElement password(){
        return password;
    }

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submit;

    public WebElement submit(){
        return submit;
    }

    @FindBy(xpath = "//h6[text()='Dashboard']")
    WebElement dashboard;

    public WebElement dashboard(){
        return dashboard;
    }
}
