package stepdefination;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

import static util.ConfigReader.getUrl;

public class SharedSD {


    static WebDriver driver;


    @Before
    public void OpenBrowser() throws IOException {
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(getUrl());
    }

    @After
    public void CloseBrowser(){
       driver.close();

    }

    public static WebDriver getDriver(){
        return driver;

    }
}
