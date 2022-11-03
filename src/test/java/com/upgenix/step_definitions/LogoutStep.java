package com.upgenix.step_definitions;

import com.upgenix.pages.LogoutPage;
import com.upgenix.utilities.BrowserUtils;
import com.upgenix.utilities.ConfigurationReader;
import com.upgenix.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class LogoutStep {

    LogoutPage logoutPage = new LogoutPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
    Actions actions = new Actions(Driver.getDriver());
    String otherWindow;


    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("website"));
    }
    @When("User enters valid username")
    public void user_enters_valid_username() {
        logoutPage.usernameBox.sendKeys("salesmanager15@info.com");
    }
    @When("User enters valid password")
    public void user_enters_valid_password() {
        logoutPage.passwordBox.sendKeys("salesmanager");
    }
    @When("User click the login button")
    public void user_click_the_login_button() {
        logoutPage.loginButton.click();
    }
    @Then("User should see in title and it should contains {string}")
    public void user_should_see_in_title_and_it_should_contains(String titleHomePage) {
        wait.until(ExpectedConditions.titleContains(titleHomePage));
        Assert.assertTrue(Driver.getDriver().getTitle().contains(titleHomePage));
    }
    @When("As a user click the open new tab and go to celander")
    public void as_a_user_click_the_open_new_tab_and_go_to_celander() throws InterruptedException {
        String celander = "window.open('https://qa.upgenix.net/web?#view_type=calendar&model=calendar.event&action=136','_blank');";
        ((JavascriptExecutor)Driver.getDriver()).executeScript(celander);

    }
    @When("As a user click the open new tab button for random page")
    public void as_a_user_click_the_open_new_tab_button_for_random_page() throws InterruptedException {
        String randomPage = "window.open('https://www.google.com/','_blank');";
        ((JavascriptExecutor)Driver.getDriver()).executeScript(randomPage);
    }
    @When("As a user go and click the usermenu top right of the page")
    public void as_a_user_go_and_click_the_usermenu_top_right_of_the_page() {
        actions.moveToElement(logoutPage.userMenu).click().perform();
    }
    @When("As a user go and click to logout button")
    public void as_a_user_go_and_click_to_logout_button() {
        actions.moveToElement(logoutPage.logoutButton).click().perform();
    }
    @When("As a close the upgenix tabs")
    public void as_a_close_the_upgenix_tabs() throws InterruptedException {
        Set<String> allWindows = Driver.getDriver().getWindowHandles();
        Set<String> windows = new HashSet<>();

        for (String each : allWindows) {
            Thread.sleep(1000);
            Driver.getDriver().switchTo().window(each);
            if (Driver.getDriver().getCurrentUrl().contains("upgenix")){
                windows.add(each);
            }else{
                otherWindow = each;
            }
        }
        for (String each : windows) {
            Driver.getDriver().switchTo().window(each);
            Driver.getDriver().close();
        }
        Driver.getDriver().switchTo().window(otherWindow);
    }

    @And("As a user go to upgenix homepage")
    public void asAUserGoToUpgenixHomepage() {
        Driver.getDriver().get("https://qa.upgenix.net/web?#menu_id=115&action=120&active_id=channel_inbox");
    }
    @When("User should see login page, title should contains {string}")
    public void user_should_see_login_page_title_should_contains(String loginPageTitle) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(loginPageTitle));
    }

    @And("As a user click the back button")
    public void asAUserClickTheBackButton() {
        Driver.getDriver().navigate().back();
    }

    @Then("User shouldn't see the home page")
    public void userShouldnTSeeTheHomePage() {
        Assert.assertTrue(!(Driver.getDriver().getTitle().equalsIgnoreCase("#Inbox - Odoo")));
    }

    @When("User should see login page, title should contains the {string}")
    public void user_should_see_login_page_title_should_contains_the(String loginPageTitle) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(loginPageTitle));
    }
}
