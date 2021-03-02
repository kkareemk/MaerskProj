package com.maersk.eggtimer.pages;

import com.maersk.eggtimer.utilities.TimerHandler;
import com.maersk.eggtimer.utilities.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class TimerPage extends BasePage{

    @FindBy(id="EggTimer-start-time-input-text")
    WebElement inputTimeField;

    @FindBy(xpath="//*[@class='EggTimer-start-time-input-wrapper']/following::button[text()='Start']")
    WebElement startBtn;

    public TimerPage() {
        PageFactory.initElements(driver,this);
    }


    public void enterTimeInTextField(String time){
        inputTimeField.sendKeys(time);
        TimerHandler timerHandler= new TimerHandler();
        timerHandler.setTime(Integer.parseInt(time));
    }

    public TimerPage clickStartBtn()  {
        startBtn.click();
        return new TimerPage();
    }


}
