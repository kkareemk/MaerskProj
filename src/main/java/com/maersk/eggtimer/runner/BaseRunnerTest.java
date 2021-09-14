package com.maersk.eggtimer.runner;


import com.maersk.eggtimer.utilities.BasePage;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.After;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = "com.maersk.eggtimer.stepDef",
        plugin = {"pretty", "html:target/cucumber-reports","json:target/cucumber.json"},
        monochrome = true
)

public class BaseRunnerTest {
    @After
    public static void tearDown(){
        System.out.println("inside teardown");
        BasePage.tearDown();
    }
}
