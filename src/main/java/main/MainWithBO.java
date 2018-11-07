package main;

import BO.MainPageBO;
import PO.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class MainWithBO {

    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        InputStream input = new FileInputStream("src\\main\\resources\\data.properties");
        prop.load(input);

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            driver.get("https://www.dota2.ru/");

            MainPageBO mainPageBO = new MainPageBO(driver);
            mainPageBO.login(prop.getProperty("login"), prop.getProperty("password"));
            mainPageBO.logout();

        } finally {
            driver.quit();
        }
    }
}
