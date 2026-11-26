package com.demo;

import com.microsoft.playwright.*;
import io.cucumber.java.*;
import io.cucumber.java.en.*;
import static org.junit.jupiter.api.Assertions.*;

public class LoginSteps {
    static Playwright playwright;
    static Browser browser;
    Page page;

    @BeforeAll
    public static void launch() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
    }

    @AfterAll
    public static void close() {
        browser.close();
        playwright.close();
    }

    @Before
    public void newPage() { page = browser.newPage(); }

    @After
    public void closePage() { page.close(); }

    @Given("I open the login page")
    public void openLogin() { page.navigate("https://www.saucedemo.com"); }

    @When("I login with {string} and {string}")
    public void login(String user, String pass) {
        page.fill("#user-name", user);
        page.fill("#password", pass);
        page.click("#login-button");
    }

    @Then("I should see the products page")
    public void products() {
        assertTrue(page.url().contains("inventory"));
    }

    @Then("I should see an error message")
    public void error() {
        assertTrue(page.locator("[data-test='error']").isVisible());
    }
}
