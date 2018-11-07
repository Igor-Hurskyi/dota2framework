package PO;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {

    static String url = "https://dota2.ru/";

    @FindBy(className = "login")
    public WebElement openLoginPopupButton;

    @FindBy(id = "login_credential")
    public WebElement loginTextField;

    @FindBy(id = "login_password")
    public WebElement passwordTextField;

    @FindBy(id = "loginBtn")
    public WebElement loginButton;

    @FindBy(className = "username")
    public WebElement username;

    @FindBy(className = "fa-close")
    public WebElement exitButton;

    @FindBy(css = "button[type='submit")
    public WebElement acceptExitButton;

}
