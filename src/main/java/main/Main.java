package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Main {

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
            WebElement loginButton = driver.findElement(By.className("login"));
            loginButton.click();
            WebElement loginTextField = driver.findElement(By.id("login_credential"));
            loginTextField.sendKeys(prop.getProperty("login"));
            WebElement passwordTextField = driver.findElement(By.id("login_password"));
            passwordTextField.sendKeys(prop.getProperty("password"));
            WebElement loginButton1 = driver.findElement(By.id("loginBtn"));
            loginButton1.click();

            WebElement username = driver.findElement(By.className("username"));

            if (username.getText().equals(prop.getProperty("login")))
                System.out.println("Successful login");
            else
                System.out.println("Login failed");

            WebElement exitButton = driver.findElement(By.className("fa-close"));
            exitButton.click();

            WebElement exitButton2 = driver.findElement(By.cssSelector("button[type='submit']"));
            exitButton2.click();

            WebElement loginButtonAfterExit = driver.findElement(By.className("login"));

            if (loginButtonAfterExit.getText().equals("Вход")) {
                System.out.println("Successful logout");
            } else {
                System.out.println("Failed logout");
            }

        } finally {
            driver.quit();
        }
    }
}