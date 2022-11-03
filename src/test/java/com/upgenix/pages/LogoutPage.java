package com.upgenix.pages;

import com.upgenix.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

    public LogoutPage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(xpath = "//input[@name='login']")
    public WebElement usernameBox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//span[@class='oe_topbar_name']")
    public WebElement userMenu;

    @FindBy(xpath = "//a[@data-menu='logout']")
    public WebElement logoutButton;

    @FindBy(xpath = "(//span[@class='oe_menu_text'])[2]")
    public WebElement celandar;






}
