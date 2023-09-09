package Contrato.empresarial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;


public class Login extends Base{
    //Url - Credenciales y Login
    String Url = "https://previexappdev.azurewebsites.net/";
    By BotonSesion = By.cssSelector("#header > nav > div > button > span");
    By BoxUsuario = By.id("i0116");
    String usuario = "usrglohits@central.jbgye.org.ec";
    By BoxContrasena = By.id("i0118");
    String contrasena = "s0D4hd@4d8KG";
    By BotonSiguiente = By.id("idSIButton9");
    By BotonNo = By.id("idBtn_Back");

    private WebDriver navegador;

    public Login(WebDriver navegador) {

        super(navegador);
    }

    public void Loguearme () throws InterruptedException {
        String parentHandle = navegador.getWindowHandle();
        //System.out.println("Pagina Principal - " + parentHandle);
        click(BotonSesion);
        Set<String> handles = navegador.getWindowHandles();
        //recorrer lista
        for (String handle : handles) {
            //System.out.println(handle);
                if(!handle.equals(parentHandle)) {
                    //trasladarse a la segunda ventana - inicio de sesión
                    navegador.switchTo().window(handle);
                    type(usuario, BoxUsuario);
                    click(BotonSiguiente);
                    type(contrasena, BoxContrasena);
                    Thread.sleep(1000);
                    click(BotonSiguiente);
                    click(BotonNo);
                }
        }
        //regresear a la primera ventana
        navegador.switchTo().window(parentHandle);
        System.out.println("Me llamaron");
    }

}
