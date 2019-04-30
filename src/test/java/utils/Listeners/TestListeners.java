package utils.Listeners;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.TesteBase;
import utils.ExtentReports.ExtentManager;
import utils.ExtentReports.ExtentTestManager;

public class TestListeners extends TesteBase implements ITestListener{
    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("Estou no metodo " + iTestContext.getName());
        iTestContext.setAttribute("WebDriver", this.driver);
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("Estou no metodo " + iTestContext.getName());

        ExtentTestManager.endTest();
        ExtentManager.getReporter().flush();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Estou no metodo " +  getTestMethodName(iTestResult) + " iniciar");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Estou no metodo " +  getTestMethodName(iTestResult) + " sucesso");

        ExtentTestManager.getTest().log(LogStatus.PASS, "Teste passou");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("Estou no metodo " +  getTestMethodName(iTestResult) + " falhou");

        //Obtenha o driver do TesteBase e atribua à variável webdriver local.
        Object testClass = iTestResult.getInstance();
        WebDriver webDriver = ((TesteBase) testClass).getDriver();

        //
        String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)webDriver).
                getScreenshotAs(OutputType.BASE64);

        //
        ExtentTestManager.getTest().log(LogStatus.FAIL,"Teste Falhou",
                ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("Estou no metodo "+  getTestMethodName(iTestResult) + " ignorado");
        //Operação de log do extentreports para testes ignorados.
        ExtentTestManager.getTest().log(LogStatus.SKIP, "Teste ignorados");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Teste falhou, mas está como taxa definido suceso " + getTestMethodName(iTestResult));
    }
}
