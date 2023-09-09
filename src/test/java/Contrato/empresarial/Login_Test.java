package Contrato.empresarial;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


import java.util.concurrent.TimeUnit;

public class Login_Test {
    private WebDriver navegador;
    Login login;

    @Before
    public void setUp() {
    login = new Login(navegador);
    navegador = login.chromeDriverConnection();
    login.visit(login.Url);
    navegador.manage().window().maximize();
    navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void test() throws InterruptedException {
        login.Loguearme();
        Thread.sleep(2000);
    }

    @After
    public void tearDown(){
        //navegador.quit();
    }
}
