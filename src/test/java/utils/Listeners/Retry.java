package utils.Listeners;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import tests.TesteBase;
import utils.ExtentReports.ExtentTestManager;

public class Retry implements IRetryAnalyzer{
    private int count = 0;
    private static int maxTry = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {                      //Verifica se o teste não passou
            if (count < maxTry) {                            //Verifica se a contagem maxima eh atingida
                count++;                                     //incermenta mais 1
                iTestResult.setStatus(ITestResult.FAILURE);  //Marca o teste como falho
                extendReportsFailOperations(iTestResult);    //Marca no relatorio as operacoes com falha
                return true;                                 //Diz ao TestNG para executar novamente o teste
            }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS);      //Se passar o teste, TestNG marca que passou
        }
        return false;
    }

    public void extendReportsFailOperations (ITestResult iTestResult) {
        Object testClass = iTestResult.getInstance();
        WebDriver webDriver = ((TesteBase) testClass).getDriver();
        String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)webDriver).getScreenshotAs(OutputType.BASE64);
        ExtentTestManager.getTest().log(LogStatus.FAIL,"Teste Falhou",
                ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
    }

}
