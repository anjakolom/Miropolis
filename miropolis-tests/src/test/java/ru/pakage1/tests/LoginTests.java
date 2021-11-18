package ru.pakage1.tests;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{


    @Test
    public void LoginTest1(){
        app.session().loginError("", "",
                "Неверные данные для авторизации.");
    }

    @Test
    public void LoginTest2(){
        app.session().loginError("11111111111111111111111111111111111111111111",
                "", "Неверные данные для авторизации.");
    }

    @Test
    public void LoginTest3(){
        app.session().loginError("",
                "11111111111111111111111111111111111111111111",
                "Неверные данные для авторизации.");
    }

    @Test
    public void LoginTest4(){
        app.session().loginError("", app.getProperty("web.Password"),
                "Неверные данные для авторизации.");
    }

    @Test
    public void LoginTest5(){
        app.session().loginError(app.getProperty("web.Login"),
                "11111111111111111111111111111111111111111111",
                "Неверные данные для авторизации");
    }


    @Test
    public void LoginTest6() throws InterruptedException {
        app.session().login(app.getProperty("web.Login"), app.getProperty("web.Password"));
        app.session().assertUser(app.getProperty("web.Name"));
        app.session().logout();
    }

    @Test
    public void RestorePassword(){
        app.session().restore();
    }
}
