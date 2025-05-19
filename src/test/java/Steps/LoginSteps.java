package Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginSteps extends BaseClass {

//    public WebDriver d;

    @Given("user launches the application")
    public void user_launches_the_application() {
        try {
            System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
            ChromeOptions op = new ChromeOptions();
            op.addArguments("--start-maximized", "--disable-notifications");
            driver = new ChromeDriver(op);
            driver.get("https://opensource-demo.orangehrmlive.com/");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='Login']")));
            String ExpectedTitle = "OrangeHRM";
            String ActualTitle = driver.getTitle();
            Assert.assertEquals(ActualTitle, ExpectedTitle, "URL is not loaded successfully. Title mismatch.");
            Hooks.log("URL loaded successfully");
            System.out.println("URL loaded successfully");
        }
        catch (Throwable t) {
            t.printStackTrace();
            Hooks.log("URL is not loaded successfully");
            System.out.println("URL is not loaded successfully");
            Assert.fail();
        }
    }

    @And("user logs in using {string} and {string}")
    public void userLogsInUsingUsernameAndPassword(String un , String pass) {

    }

    @When("user navigates to Admin - Add user")
    public void user_navigates_to_Admin_Add_user() {
        System.out.println("Test2");
    }

    @Then("user adds a new user")
    public void user_adds_a_new_user() {
        System.out.println("Test3");
    }

    @Then("user logs out from the application")
    public void user_logs_out_from_the_application() {
        System.out.println("Test4");
    }
}
