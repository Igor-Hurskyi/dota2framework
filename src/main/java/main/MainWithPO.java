package main;

import PO.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class MainWithPO {

    public static void main(String[] args) throws IOException {
        //load properties
        Properties prop = new Properties();
        InputStream input = new FileInputStream("src\\main\\resources\\data.properties");
        prop.load(input);

        //load webdriver
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            //setup driver and navigate to start page
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            driver.get("https://www.dota2.ru/");

            MainPage mainPage = new MainPage();

            mainPage.openLoginPopupButton.click();
            mainPage.loginTextField.sendKeys(prop.getProperty("login"));
            mainPage.passwordTextField.sendKeys(prop.getProperty("password"));
            mainPage.loginButton.click();

            if (mainPage.username.getText().equals(prop.getProperty("login")))
                System.out.println("Successful login");
            else
                System.out.println("Login failed");

            mainPage.exitButton.click();
            mainPage.acceptExitButton.click();

            if (mainPage.openLoginPopupButton.getText().equals("Вход"))
                System.out.println("Successful logout");
            else
                System.out.println("Failed logout");

        } finally {
            driver.quit();
        }
    }
}
