package com.tsi.AnimalKingdom.tests.cucumber;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;

//        glue = "src/test/java/com/tsi/davis/gareth/cucumber/cats/FeedCatStepDefs.java" )

class MyBowl {
    String bowlState;
    
    public MyBowl() {
        this.bowlState = "Empty";
    }

    public String getBowlState() {
        return this.bowlState;
    }
     public void setBowlState(String state) {
        this.bowlState = state;
     }

     public String catMeow() {
        return "Meow";
     }


}
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/cucumber" )
public class RunCucumberTest {
    String catHunger;
    MyBowl bowl = new MyBowl();
    String bowlState;

    @Given("The cat is hungry")
    public void the_cat_is_hungry() {
        catHunger = "Hungry";
    }

    @When("The bowl is empty")
    public void the_bowl_is_empty(){
        bowlState = bowl.getBowlState();
    }

    @Then("The cat should {string}")
    public void theCatShould(String arg0) {
        Assertions.assertEquals(bowl.catMeow(), "Meow");
    }

}
