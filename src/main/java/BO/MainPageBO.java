package BO;

import PO.MainPage;
import org.openqa.selenium.WebDriver;

public class MainPageBO {

    MainPage mp;

    public MainPageBO(WebDriver driver) {
        mp = new MainPage(driver);
    }

    public void login(String login, String password) {
        mp.openLoginPopupButton.click();
        mp.loginTextField.sendKeys(login);
        mp.passwordTextField.sendKeys(password);
        mp.loginButton.click();

        if (mp.username.getText().equals(login))
            System.out.println("Successful login");
        else
            System.out.println("Login failed");
    }

    public void logout() {
        mp.exitButton.click();
        mp.acceptExitButton.click();

        if (mp.openLoginPopupButton.getText().equals("Вход"))
            System.out.println("Successful logout");
        else
            System.out.println("Failed logout");
    }

}
