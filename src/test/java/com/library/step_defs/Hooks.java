package com.library.step_defs;

import com.library.utility.ConfigurationReader;
import com.library.utility.DB_Util;
import com.library.utility.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;

public class Hooks {
    @Before("@ui")
    public void setUp(){
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get(ConfigurationReader.getProperty("library_url"));

    }

    @After("@ui")
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenshotPNG=((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotPNG,"image/png","screenshot.png");

            final byte[] screenshotGIF=((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotGIF,"image/gif","screenshot.gif");
        }
        Driver.closeDriver();

    }

    @Before("@db")
    public void setUpDB(){
        System.out.println("Connecting to database...");
        DB_Util.createConnection();
    }

    @After("@db")
    public void tearDownDB(){
        System.out.println("close database connection...");
       DB_Util.destroy();
    }

}
