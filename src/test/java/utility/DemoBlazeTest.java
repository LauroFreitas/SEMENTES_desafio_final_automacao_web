package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.junit.AfterClass;
import org.junit.jupiter.api.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ProductPage;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.Alert;

public class DemoBlazeTest extends Commum {

    private WebDriver driver;
    private String URL_DEMOBLAZE = "https://www.demoblaze.com/index.html";
    ProductPage page = new ProductPage(driver);
    public static ExtentSparkReporter report;
    public static ExtentReports extent;
    public static ExtentTest test;
    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        page = new ProductPage(driver);
        globalWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
@BeforeAll
public static void startReport() {
    initializeReport();
}

    @Test
    public void testeEfetuaLogin() {
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        test = extent.createTest(methodName,"Cadastra uma nova conta e efetua login");
        test.log(Status.INFO,"Abre a pagina e efetua o login");
        test.assignCategory("Teste Padrão");


        page.driver.get(URL_DEMOBLAZE);
        click(page.signUp());
        sendKeys(page.userName(), randomString(7));
        sendKeys(page.password(), randomString(8));
        click(page.botaoRegistrar());
        page.driver.get(URL_DEMOBLAZE);
    }
    @Test
    public void testeAdicionaNoCarrinho(){

        String methodName = new Exception().getStackTrace()[0].getMethodName();
        test = extent.createTest(methodName,"Adiciona um novo monitor ao carrinho");
        test.log(Status.INFO,"Entra nas opções de monitores escolhe o monitor Asus e adiciona no carrinho");
        test.assignCategory("Teste Padrão");

        click(page.campoMonitores());
        click(page.monitorAsus());
        click(page.botaoAdicionar());
        click(page.carrinho());

        Wait(2);
        Alert alert = driver.switchTo().alert();
        String alertaText = alert.getText();
        String texto = "Product added";
        Assertions.assertEquals(texto, alertaText);
        alert.accept();

    }
    @Test
    public void testePreencheFormulario() {

        String methodName = new Exception().getStackTrace()[0].getMethodName();
        test = extent.createTest(methodName,"Preenche formulário de compra");
        test.log(Status.INFO,"Preenche todos os campos do formulário, efetua compra clicando no botão e valida mensagem de compra com sucesso");
        test.assignCategory("Teste Padrão");

        click(page.botaoFinalizarCompra());
        sendKeys(page.campoName(),"Lauro");
        sendKeys(page.campoCountry(),"Brasil");
        sendKeys(page.campoCity(),"Alvorada");
        sendKeys(page.campoCard(),"4709692965393713");
        sendKeys(page.campoMonth(),"08");
        sendKeys(page.campoYear(),"2028");
        click(page.botaoPurchase());

        String msgDeCheckoutCampo = page.textoCompraEfetuadaComSucesso().getText();
        String msgDeCheckoutEsperada = "Thank you for your purchase!";
        Assertions.assertEquals(msgDeCheckoutEsperada, msgDeCheckoutCampo);


    }

    public static void initializeReport(){
        report = new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/extentSparkReport.html");
        report.config().setDocumentTitle("Report da automação");
        report.config().setReportName("Automation Test Rexecution report");
        report.config().setTheme(Theme.STANDARD);
        report.config().setTimeStampFormat("dd/MM/yyyy HH:mm:ss");
        extent = new ExtentReports();
        extent.attachReporter(report);
    }
    public static String captureScreenshot(WebDriver driver) throws IOException {
        String FileSeparator = System.getProperty("file.separator");
        String Extent_report_path = "."+FileSeparator+"Reports";
        String ScreenshotPath = Extent_report_path+FileSeparator+"screenshots";
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String screenshotName = "screenshot"+Math.random()+".png";
        String screenshotpath = ScreenshotPath+FileSeparator+screenshotName;
        FileUtils.copyFile(src,new File(screenshotpath));
        return "."+FileSeparator+"screenshots"+FileSeparator+screenshotName;
    }
    @AfterEach
    public void tearDown() {
        driver.quit();
        extent.flush();
    }

}
