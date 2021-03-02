package com.maersk.eggtimer.pages;

import com.maersk.eggtimer.utilities.TimerHandler;
import com.maersk.eggtimer.utilities.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TimerDetails extends BasePage {

    @FindBy(xpath="//p[@class='ClassicTimer-time']/span")
    WebElement timerValue;

    public TimerDetails() {
        PageFactory.initElements(driver,this);
    }

    public void getTime(){
        timerValue.getText();
    }

    public String acceptAlert(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String alertText =null;
        if(isAlertPresent()){
            Alert alert= driver.switchTo().alert();
            alert.accept();
        }
        return alertText;
    }

    public boolean isAlertPresent(){
        try{
            WebDriverWait wait = new WebDriverWait(driver,20);
            wait.until(WebDriver::switchTo).alert();
            return true;
        }
        catch (NoAlertPresentException Ex){
            return false;
        }
    }

    public void validateTime(){
        int time = TimerHandler.getTime();
        int i = Integer.parseInt(timerValue.getText().replace("seconds", " ").trim());
        int j=0;
        while(i<=time){
            j=i;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i=Integer.parseInt(timerValue.getText().replace("seconds", " ").replace("second", " ").trim());
            if( j == (i-1)){
                System.out.println("Fail "+i+" "+j);
            }else{
                System.out.println("Pass "+i+" "+j);
            }
            if(timerValue.getText().equalsIgnoreCase("0 second")){
                break;
            }
        }
    }
}
