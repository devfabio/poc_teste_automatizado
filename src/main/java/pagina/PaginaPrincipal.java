package pagina;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaginaPrincipal extends PaginaBase{

    //*********Construtor*********
    public PaginaPrincipal (WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //*********Pagina web*********
    String URLbase = "http://www.n11.com/";

    //*********Elementos web*********
    String btnLoginClass = "btnSignIn";


    //*********Metodos para as Paginas*********

    //Ir para pagina principal
    public void irNoSiteN11 (){
        driver.get(URLbase);
    }

    //Ir para pagina de login
    public void irParaPaginaDeLogin (){

        click(By.className(btnLoginClass));
    }
}
