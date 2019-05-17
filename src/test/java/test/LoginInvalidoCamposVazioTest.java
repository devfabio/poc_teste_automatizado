package test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pagina.PaginaLogin;
import pagina.PaginaPrincipal;
import utils.ExtentReports.ExtentTestManager;

import java.lang.reflect.Method;

public class LoginInvalidoCamposVazioTest extends BaseTeste {

    @Test(priority = 1, description="Cenário de login inválido com nome de usuário e senha vazios.")
    public void testeLoginInvalido_SenhaVaziaUsuarioVazio (Method method)  {
        //ExtentReports
        ExtentTestManager.startTest(method.getName(),"Cenário de login inválido com nome de usuário e senha vazios.");

        PaginaPrincipal naPaginaPrincipal = new PaginaPrincipal(driver,espera);
        PaginaLogin naPaginaDeLogin = new PaginaLogin(driver,espera);

        naPaginaPrincipal.irNoSiteN11();
        naPaginaPrincipal.irParaPaginaDeLogin();
        naPaginaDeLogin.loginSiteN11("","");

        //************* Verificaçoes***********************
        espera.until(ExpectedConditions
                .visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"loginForm\"]/div[2]/div/div ")));
        naPaginaDeLogin.verificarUsername("Lütfen e-posta adresinizi girin.");
        naPaginaDeLogin.verificarPassword("Bu alanın doldurulması zorunludur.");
    }
}
