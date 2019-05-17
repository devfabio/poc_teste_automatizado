package test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pagina.PaginaPrincipal;
import pagina.PaginaLogin;
import utils.ExtentReports.ExtentTestManager;

import java.lang.reflect.Method;

public class LoginInvalidoTest extends BaseTeste{

    @Test (priority = 0, description="Cenário de login inválido com nome de usuário e senha incorretos.")
    public void testeLoginInvalido_NomeUsuarioInvalidoSenhaInvalida (Method method) {
        //ExtentReports - arpesenta as descriçoes no teste
        ExtentTestManager.startTest(method.getName(),"Cenário de login inválido com nome de usuário e senha vazios.");

        //************* Instancia as Paginas ************
        PaginaPrincipal naPaginaPrincipal = new PaginaPrincipal(driver,espera);
        PaginaLogin naPaginaDeLogin = new PaginaLogin(driver,espera);

        //************* PAGINA - Metodos ********************
        //Abrir pagina principal
        naPaginaPrincipal.irNoSiteN11();

        //Ir para pagina de Login
        naPaginaPrincipal.irParaPaginaDeLogin();

        //Login
        naPaginaDeLogin.loginSiteN11("teste@teste.com", "11223344");

        //*************testes - verificaçoes ***********************
        espera.until(ExpectedConditions
                .visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"loginForm\"]/div[2]/div/div ")));
        naPaginaDeLogin.verificarPassword(("E-posta adresiniz veya şifreniz hatalı"));
    }
}
