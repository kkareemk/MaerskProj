package com.maersk.eggtimer.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

public class BasePage {

    public static WebDriver driver;

    public static void initialize() {
        String browser = null;
        try {
            browser = ReadProperties.readProperties("browser");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver","src/test/resources/drivers/geckodriver.exe");
            driver= new FirefoxDriver();
        }else if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
            driver= new ChromeDriver();
        }else{
            System.out.println("This is not valid browser, please enter valid browser names - firefox or chrome");
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(35,TimeUnit.SECONDS);
    }


    public static void navigateToUrl(String url){
        initialize();
        driver.get(url);
    }

    public static void tearDown(){
            driver.close();
    }

}
