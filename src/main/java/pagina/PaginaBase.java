package pagina;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaginaBase {

    public WebDriver driver;
    public WebDriverWait espera;

    //Construtor
    public PaginaBase (WebDriver driver, WebDriverWait esp){
        this.driver = driver;
        this.espera = esp;
    }

    //Metodo clicar
    public void click (By caminhoElemento) {
        driver.findElement(caminhoElemento).click();
    }

    //Inserir dados
    public void inserirTexto (By caminhoElemento, String text) {
        driver.findElement(caminhoElemento).sendKeys(text);
    }

    //Ler dados
    public String lerTexto (By caminhoElemento) {
        return driver.findElement(caminhoElemento).getText();
    }

}
