package pagina;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.assertj.core.api.Assertions.*;


public class PaginaLogin extends PaginaBase{

    //*********Construtor*********
    public PaginaLogin(WebDriver driver, WebDriverWait esp) {

        super(driver, esp);
    }

    //*********Web Elementos*********
    String usenameId = "email";
    String passwordId = "password";
    String loginButtonId = "loginButton";
    String errorMessageUsernameXpath = "//*[@id=\"loginForm\"]/div[1]/div/div";
    String errorMessagePasswordXpath = "//*[@id=\"loginForm\"]/div[2]/div/div ";
    String userLogado = "/html/body/div[1]/header/div/div/div[2]/div[2]/div[2]/div[1]/a[2]";
    //*********Paginas web - metodos *********

    public void loginSiteN11 (String email, String senha){
        //inserir Username(Email)
        inserirTexto(By.id(usenameId),email);
        //inserir Password
        inserirTexto(By.id(passwordId), senha);
        //Clicar botao login
        click(By.id(loginButtonId));
    }

    //Verificar Username
    public void verificarUsername (String txtEsperado) {

        assertThat(lerTexto(By.xpath(errorMessageUsernameXpath))).isEqualTo(txtEsperado);
    }

    //Verificar Password
    public void verificarPassword (String txtEsperado) {

        assertThat(lerTexto(By.xpath(errorMessagePasswordXpath))).isEqualTo(txtEsperado);
    }

    public void verificarUsuarioLogado (String txtEsperado) {

        assertThat(lerTexto(By.xpath(userLogado))).isEqualTo(txtEsperado);
    }
}
