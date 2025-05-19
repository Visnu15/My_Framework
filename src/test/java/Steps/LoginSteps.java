package Steps;

import PageObject.AdminPage;
import PageObject.HomePage;
import PageObject.LoginPage;
import Utilities.ExcelReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginSteps extends BaseClass {

    LoginPage lp;
    HomePage hp;
    AdminPage ap;
    WebDriverWait wait;

    public LoginSteps(){
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        ChromeOptions op = new ChromeOptions();
        op.addArguments("--start-maximized", "--disable-notifications");
        driver = new ChromeDriver(op);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        lp = new LoginPage(driver);
        hp = new HomePage(driver);
        ap = new AdminPage(driver);
    }

    @Given("user launches the application")
    public void user_launches_the_application() {
        try {
            driver.get("https://opensource-demo.orangehrmlive.com/");
            wait.until(ExpectedConditions.visibilityOf(lp.title()));
            String ExpectedTitle = "OrangeHRM";
            String ActualTitle = driver.getTitle();
            Assert.assertEquals(ActualTitle, ExpectedTitle, "URL is not loaded successfully. Title mismatch.");
            Hooks.log("URL loaded successfully");
            System.out.println("URL loaded successfully");
        }
        catch (Throwable t) {
            t.printStackTrace();
            Hooks.log("URL is not loaded successfully" + t.getMessage());
            System.out.println("URL is not loaded successfully");
            Assert.fail();
        }
    }

    @And("user enters the credentials {string} and {string}")
    public void userLogsInUsingUsernameAndPassword(String un , String pass) {
        try {
            wait.until(ExpectedConditions.visibilityOf(lp.username())).sendKeys(un);
            wait.until(ExpectedConditions.visibilityOf(lp.password())).sendKeys(pass);
            Hooks.log("Credentials entered successfully");
            System.out.println("Credentials entered successfully");

        }
        catch (Throwable t) {
            t.printStackTrace();
            Hooks.log("Credentials not entered successfully" + t.getMessage());
            Assert.fail();
        }
    }

    @Then("user logs in to the application")
    public void user_logs_in_to_application(){
        try {
            wait.until(ExpectedConditions.visibilityOf(lp.submit())).click();
            Hooks.log("Submit button clicked");
            System.out.println("Submit button clicked");
            String actual = lp.dashboard().getText();
            String exp = "Dashboard";
            Assert.assertEquals(actual, exp, "Login failed - Dashboard not visible");
            Hooks.log("Successful login");
            System.out.println("Successful login");
        }
        catch (Throwable t) {
            t.printStackTrace();
            Hooks.log("Login not successful" + t.getMessage());
            System.out.println("Login not successful");
            Assert.fail();
        }
    }

    @When("user navigates to Admin")
    public void user_navigates_to_Admin_Add_user() {
        try{
            wait.until(ExpectedConditions.elementToBeClickable(hp.admin())).click();
            String actual = ap.admintitle().getText();
            String expected = "Admin";
            Assert.assertEquals(actual, expected, "Navigation to Admin page failed");
            Hooks.log("Successfully navigated to Admin page");
            System.out.println("Successfully navigated to Admin page");
        }
        catch (Throwable t) {
            t.printStackTrace();
            Hooks.log("Navigation to Admin page failed" + t.getMessage());
            System.out.println("Navigation to Admin page failed");
        }

    }

    @Then("user adds a new user")
    public void user_adds_a_new_user() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(ap.add())).click();
            String actual = ap.addUser().getText();
            String exp = "Add User";
            Assert.assertEquals(actual, exp, "Add user form not loaded properly");
            Hooks.log("Add user form loaded successfully");
            System.out.println("Add user form loaded successfully");

            ExcelReader.excelData("AddUser", "AddUser");
            String role = ExcelReader.data.getFirst();
            String status = ExcelReader.data.get(1);
            String empname = ExcelReader.data.get(2);
            String un = ExcelReader.data.get(3);
            String pass = ExcelReader.data.get(4);
            String confirmpass = ExcelReader.data.get(5);

            wait.until(ExpectedConditions.elementToBeClickable(ap.dropdown())).click();

            for(WebElement userrole: ap.userRoleOption()){
                String userroleText = userrole.getText();
                if (userroleText.equals(role)){
                    wait.until(ExpectedConditions.elementToBeClickable(userrole)).click();
                    break;
                }
            }
//            wait.until(ExpectedConditions.visibilityOf(ap.userRoleOption()));
            wait.until(ExpectedConditions.elementToBeClickable(ap.dropdown2())).click();

            for(WebElement userstatus: ap.statusOption()){
                String userstatusText = userstatus.getText();
                if (userstatusText.equals(status)){
                    wait.until(ExpectedConditions.elementToBeClickable(userstatus)).click();
                    break;
                }
            }
//            wait.until(ExpectedConditions.visibilityOf(ap.optionStatus())).click();
            wait.until(ExpectedConditions.visibilityOf(ap.employeeName())).sendKeys(empname);
            wait.until(ExpectedConditions.elementToBeClickable(ap.employeeNameOption())).click();
            wait.until(ExpectedConditions.visibilityOf(ap.username())).sendKeys(un);
            wait.until(ExpectedConditions.visibilityOf(ap.password())).sendKeys(pass);
            wait.until(ExpectedConditions.visibilityOf(ap.confirmPassword())).sendKeys(confirmpass);
            wait.until(ExpectedConditions.elementToBeClickable(ap.save())).click();
            String actualVerify = ap.saveVerify().getText();
            String expVerify = "Successfully Saved";
            Assert.assertEquals(actualVerify, expVerify, "User not saved successfully");
            Hooks.log("User added successfully");
            System.out.println("User added successfully");
            Thread.sleep(2000);
        }
        catch (Throwable t){
            t.printStackTrace();
            Hooks.log("Some exception/error occurred during adding user" + t.getMessage());
            System.out.println("Some exception/error occurred during adding user");
            Assert.fail("Some exception/error occurred during adding user");
        }
    }

    @Then("user logs out from the application")
    public void user_logs_out_from_the_application() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(hp.profile())).click();
            wait.until(ExpectedConditions.elementToBeClickable(hp.logout())).click();
            String actual = lp.title().getText();
            String exp = "Login";
            Assert.assertEquals(actual, exp, "Logout failed");
            Hooks.log("Logout successful");
            System.out.println("Logout successful");
        }
        catch (Throwable t) {
            t.printStackTrace();
            Hooks.log("Logout failed due to some exception/error" + t.getMessage());
            System.out.println("Logout failed due to some exception/error");
            Assert.fail("Logout failed");
        }
    }
}
