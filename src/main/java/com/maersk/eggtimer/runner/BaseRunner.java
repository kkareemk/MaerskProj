package com.maersk.eggtimer.runner;


import com.maersk.eggtimer.utilities.BasePage;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features/EggTimer.feature",
        glue = "com.maersk.eggtimer.stepDef",
        plugin = {"pretty", "html:target/cucumber-reports","json:target/cucumber.json"},
        monochrome = true
)

public class BaseRunner  {
    @AfterClass
    public static void tearDown(){
        BasePage.tearDown();
    }
}
