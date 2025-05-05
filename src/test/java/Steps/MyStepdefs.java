package Steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyStepdefs {

    @Given("user opens the application")
    public void user_opens_the_application() {
        System.out.println("Given print");
    }

    @When("user places his order")
    public void user_places_his_order() {
        System.out.println("When print");
    }

    @Then("the order should be placed successfully")
    public void the_order_should_be_placed_successfully() {
        System.out.println("Then print");
    }


}
