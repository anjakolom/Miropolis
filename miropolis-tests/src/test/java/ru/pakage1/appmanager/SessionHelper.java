package ru.pakage1.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class SessionHelper extends HelperBase {


    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void login(String username, String password) throws InterruptedException {
        if (isElementPresent(By.className("avatar-full-name"))) {
            return;
        }
        type(By.name("user"), username);
        type(By.name("password"), password);
        click(By.id("button_submit_login_form"));
        isElementPresent(By.className("avatar-full-name"));
        Assert.assertTrue(isElementPresent(By.className("avatar-full-name")));

    }

    public void loginError(String username, String password, String text) {
        if (isElementPresent(By.className("avatar-full-name"))) {
            return;
        }
        type(By.name("user"), username);
        type(By.name("password"), password);
        click(By.id("button_submit_login_form"));
        closeAlert(text);
    }

    public void assertUser(String username) {
        Assert.assertTrue(isElementPresent(By.className("avatar-full-name")));
        System.out.println(String.format("div.avatar-full-name[title='%s']", username));
        Assert.assertTrue(isElementPresent(By.cssSelector(String.format("div.avatar-full-name[title='%s']", username))));

    }

    public void restore() {
        Assert.assertTrue(isElementPresent(By.cssSelector("form#login_form_panel")));
        Assert.assertTrue(isElementPresent(By.cssSelector(".mira-default-login-page-link > div")));
        click(By.cssSelector(".mira-default-login-page-link > div"));
        Assert.assertTrue(isElementPresent(By.cssSelector("div.info-title")));
        Assert.assertTrue(isElementPresent(By.className("mira-forgot-password-form")));
        click(By.cssSelector("a.mira-page-forgot-password-link"));
        Assert.assertTrue(isElementPresent(By.cssSelector("form#login_form_panel")));

    }

    public void logout() {
        WebDriverWait wait = new WebDriverWait(wd, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("template")));
        click(By.className("template"));
        click(By.cssSelector("a.link.mira-link.request"));
    }
}
