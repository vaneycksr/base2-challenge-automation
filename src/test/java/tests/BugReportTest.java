package tests;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import support.Web;

import static org.junit.Assert.*;

public class BugReportTest {

    private WebDriver driver;

    @Before
    public void setUp(){
        driver = Web.creatChrome();
    }

    @Test
    public void testPreencherCamposObrigatoriosNoCadastroDeBug(){

        boolean mensagemDeSucessoAoCadastrarBug = new LoginPage(driver)
                .realizarLogin("van.eyck","123Mudar")
                .clicarEmReportIssue()
                .selecionarProjeto("Desafio jMeter Project 1")
                .clicarEmSelectProject()
                .selecionaCategoria("[All Projects] Teste")
                .preencherCampoSummary("teste - summary")
                .preencherCampoDescription("teste - description")
                .submeterCadastroDoBug()
                .retornaMensagemDeSucessoAoCadastrarBug();

        // ou seja, a mensagem de sucesso esta visivel na tela
        assertTrue(mensagemDeSucessoAoCadastrarBug);
    }



    @Ignore
    public void tearDown(){
        driver.quit();
    }

}
