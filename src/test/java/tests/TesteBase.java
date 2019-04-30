package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TesteBase {

    public WebDriver driver;
    public WebDriverWait espera;

    public WebDriver getDriver(){
        return driver;
    }

    @BeforeClass
    public void configurar(){

        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");

        //Cria o driver. Todas as classes de teste usam esta.
        driver = new ChromeDriver();

        //Cria  espera.
        espera = new WebDriverWait(driver,25);

        //Maximize a janela
        //driver.manage().window().maximize();
    }

    @AfterClass
    public void terminar(){
        // encerra o test
        driver.quit();
    }
}
