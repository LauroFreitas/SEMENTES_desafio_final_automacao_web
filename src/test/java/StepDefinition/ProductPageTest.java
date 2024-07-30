package StepDefinition;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.AfterClass;
import utility.DemoBlazeTest;

public class ProductPageTest {
    DemoBlazeTest demoblazeTest = new DemoBlazeTest();

    @Given("acessar o site e loga no mesmo")
    public void acessar_o_site_e_loga_no_mesmo() {
        demoblazeTest.setup();
        demoblazeTest.startReport();
        demoblazeTest.testeEfetuaLogin();
    }
    @When("escolher o produto correspondente a um munitor")
    public void escolher_o_produto_correspondente_a_um_munitor() {
        demoblazeTest.testeAdicionaNoCarrinho();
    }
    @Then("valida de o munitor foi comprado corretamente")
    public void valida_de_o_munitor_foi_comprado_corretamente() {
        demoblazeTest.testePreencheFormulario();
        demoblazeTest.tearDown();
    }


}
