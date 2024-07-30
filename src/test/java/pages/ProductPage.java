package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class ProductPage {
    public WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//a[normalize-space()='Monitors'])[1]")
    WebElement campoMonitores;

    public WebElement campoMonitores(){return campoMonitores;
    }

    @FindBy(xpath = "//a[normalize-space()='ASUS Full HD']")
    WebElement monitorAsus;

    public WebElement monitorAsus()
    {
        return monitorAsus;
    }

    @FindBy(xpath = "//a[normalize-space()='Add to cart']")
    WebElement botaoAdicionar;

    public WebElement botaoAdicionar(){return botaoAdicionar;
    }

    @FindBy(xpath = "(//a[normalize-space()='Sign up'])[1]")
    WebElement signUp;

    public WebElement signUp(){return signUp;}


    @FindBy(xpath = "//input[@id='sign-username']")
    WebElement userName;

    public WebElement userName(){return userName;}

    @FindBy(xpath = "//input[@id='sign-password']")
    WebElement password;

    public WebElement password(){return password;}

    @FindBy(xpath = "//button[normalize-space()='Sign up']")
    WebElement botaoRegistrar;

    public WebElement botaoRegistrar(){return botaoRegistrar;}

    @FindBy(xpath = "//a[normalize-space()='Cart']")
    WebElement carrinho;

    public WebElement carrinho(){return carrinho;}

    @FindBy(xpath = "//button[normalize-space()='Place Order']")
    WebElement botaoFinalizarCompra;
    public WebElement botaoFinalizarCompra(){return botaoFinalizarCompra;}

    @FindBy(xpath = "//input[@id='name']")
    WebElement campoNome;
    public WebElement campoName(){return campoNome;}

    @FindBy(xpath = "//input[@id='country']")
    WebElement campoCountry;
    public WebElement campoCountry(){return campoCountry;}

    @FindBy(xpath = "//input[@id='city']")
    WebElement campoCity;
    public WebElement campoCity(){return campoCity;}

    @FindBy(xpath = "//input[@id='card']")
    WebElement campoCard;
    public WebElement campoCard(){return campoCard;}

    @FindBy(xpath = "//input[@id='month']")
    WebElement campoMonth;
    public WebElement campoMonth(){return campoMonth;}

    @FindBy(xpath = "//input[@id='year']")
    WebElement campoYear;
    public WebElement campoYear(){return campoYear;}

    @FindBy(xpath = "//button[normalize-space()='Purchase']")
    WebElement botaoPurchase;
    public WebElement botaoPurchase(){return botaoPurchase;}

    @FindBy(xpath = "//h2[normalize-space()='Thank you for your purchase!']")
    WebElement textoCompraEfetuadaComSucesso;
    public WebElement textoCompraEfetuadaComSucesso(){return textoCompraEfetuadaComSucesso;}
}
