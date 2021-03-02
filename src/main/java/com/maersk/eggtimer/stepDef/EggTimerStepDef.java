package com.maersk.eggtimer.stepDef;

import com.maersk.eggtimer.pages.TimerDetails;
import com.maersk.eggtimer.pages.TimerPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EggTimerStepDef {


    @When("I enter time with {string}")
    public void i_enter_time_with(String string) {
        TimerPage timerPage= new TimerPage();
        timerPage.enterTimeInTextField(string);
    }


    @When("I click on Start button")
    public void i_click_on_start_button() {
        TimerPage timerPage= new TimerPage();
        timerPage.clickStartBtn();

    }
    @Then("I validate countdown timer")
    public void i_validate_countdown_timer() {
        TimerDetails timerDetails = new TimerDetails();
        timerDetails.validateTime();
        timerDetails.acceptAlert();
    }

    @Given("I navigate to url {string}")
    public void i_navigate_to_url(String string) {
        TimerPage timerPage= new TimerPage();
        timerPage.navigateToUrl(string);
    }
}
