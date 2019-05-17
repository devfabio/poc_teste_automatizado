package test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pagina.PaginaLogin;
import pagina.PaginaPrincipal;
import utils.ExtentReports.ExtentTestManager;


import java.lang.reflect.Method;

public class LoginValidoTest extends BaseTeste {

    @Test(priority = 2, description="Cenário de login válido com nome de usuário e senha corretos.")
    public void testeLoginValido_NomeUsuarioValidoSenhaValida (Method method) {
        //ExtentReports - arpesenta as descriçoes no teste
        ExtentTestManager.startTest(method.getName(),"Cenário de login válido com nome de usuário e senha validos.");

        //************* Instancia as Paginas ************
        PaginaPrincipal naPaginaPrincipal = new PaginaPrincipal(driver,espera);
        PaginaLogin naPaginaDeLogin = new PaginaLogin(driver,espera);

        //************* PAGINA - Metodos ********************
        //Abrir pagina principal
        naPaginaPrincipal.irNoSiteN11();

        //Ir para pagina de Login
        naPaginaPrincipal.irParaPaginaDeLogin();

        //Login
        naPaginaDeLogin.loginSiteN11("testandotestesautomatizados@gmail.com", "teste12345");

        //*************testes - verificaçoes ***********************
        espera.until(ExpectedConditions
                .visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[1]/header/div/div/div[2]/div[2]/div[2]/div[1]/a[2]")));

        naPaginaDeLogin.verificarUsuarioLogado(("Testando Testes Automatizados"));
    }
}
