package tests;

import org.junit.After;
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

    @Test
    public void testPreencherTodosOsCamposDoCadastroDeBug(){

        boolean mensagemDeSucessoAoCadastrarBug = new LoginPage(driver)
                .realizarLogin("van.eyck","123Mudar")
                .clicarEmReportIssue()
                .selecionaOProjetoEClicaNoBotao("Desafio jMeter Project 1")
                .opcoesDeMarcar("[All Projects] Teste","always","major",
                                "urgent","PlataformaTeste SiSTEMA Windows10","public")
                .opcoesDePreencher("plataforma","test os", "test os version", "test sumário",
                                    "test descrição", "passo a passo do bug", "informações adidionais")
                .selecionarArquivo()
                .marcarFlagDeManterRelatorio()
                .submeterCadastroDoBug()
                .retornaMensagemDeSucessoAoCadastrarBug();

        assertTrue(mensagemDeSucessoAoCadastrarBug);
    }

    @Test
    public void testNaoPreencherNenhumCampoESubmeterCadastro(){

        String retornaMensagemDeErro = new LoginPage(driver)
                .realizarLogin("van.eyck","123Mudar")
                .clicarEmReportIssue()
                .selecionaOProjetoEClicaNoBotao("Desafio jMeter Project 1")
                .submeterCadastroDoBug()
                .retornaMensagemDeErro();

        assertEquals("A necessary field \"Summary\" was empty. Please recheck your inputs.", retornaMensagemDeErro);
    }

    @Test
    public void testNaoPreencherCampoCategoriaEPreencherDemaisCamposObrigatorios(){

        String retornaMensagemDeErro = new LoginPage(driver)
                .realizarLogin("van.eyck","123Mudar")
                .clicarEmReportIssue()
                .selecionaOProjetoEClicaNoBotao("Desafio jMeter Project 1")
                .preencherCampoSummary("preenche summary")
                .preencherCampoDescription("preenche description")
                .submeterCadastroDoBug()
                .retornaMensagemDeErro();

        assertEquals("A necessary field \"Category\" was empty. Please recheck your inputs.",retornaMensagemDeErro);
    }

    @Test
    public void testNaoPreencherCampoSumarioEPreencherDemaisCamposObrigatorios(){

        String retornaMensagemDeErro = new LoginPage(driver)
                .realizarLogin("van.eyck","123Mudar")
                .clicarEmReportIssue()
                .selecionaOProjetoEClicaNoBotao("Desafio jMeter Project 1")
                .selecionaCategoria("[All Projects] Teste")
                .preencherCampoDescription("preenche description")
                .submeterCadastroDoBug()
                .retornaMensagemDeErro();

        assertEquals("A necessary field \"Summary\" was empty. Please recheck your inputs.", retornaMensagemDeErro);
    }

    @Test
    public void testNaoPreencherCampoDescricaoEPreencherDemaisCamposObrigatorios(){

        String retornaMensagemDeErro = new LoginPage(driver)
                .realizarLogin("van.eyck","123Mudar")
                .clicarEmReportIssue()
                .selecionaOProjetoEClicaNoBotao("Desafio jMeter Project 1")
                .selecionaCategoria("[All Projects] Teste")
                .preencherCampoSummary("teste!!")
                .submeterCadastroDoBug()
                .retornaMensagemDeErro();

        assertEquals("A necessary field \"Description\" was empty. Please recheck your inputs.", retornaMensagemDeErro);

    }

    @Test
    public void testPreencherApenasCampoCategoriaENaoPreencherDemaisCamposObrigatorios(){

        String retornaMensagemDeErro = new LoginPage(driver)
                .realizarLogin("van.eyck","123Mudar")
                .clicarEmReportIssue()
                .selecionaOProjetoEClicaNoBotao("Desafio jMeter Project 1")
                .selecionaCategoria("[All Projects] Teste")
                .submeterCadastroDoBug()
                .retornaMensagemDeErro();

        assertEquals("A necessary field \"Summary\" was empty. Please recheck your inputs.", retornaMensagemDeErro);

    }

    @Test
    public void testPreencherApenasCampoSumarioENaoPreencherDemaisCamposObrigatorios(){

        String retornaMensagemDeErro = new LoginPage(driver)
                .realizarLogin("van.eyck","123Mudar")
                .clicarEmReportIssue()
                .selecionaOProjetoEClicaNoBotao("Desafio jMeter Project 1")
                .preencherCampoSummary("sumario teste")
                .submeterCadastroDoBug()
                .retornaMensagemDeErro();

        assertEquals("A necessary field \"Description\" was empty. Please recheck your inputs.", retornaMensagemDeErro);

    }

    @Test
    public void testPreencherApenasCampoDescricaoENaoPreencherDemaisCamposObrigatorios(){

        String retornaMensagemDeErro = new LoginPage(driver)
                .realizarLogin("van.eyck","123Mudar")
                .clicarEmReportIssue()
                .selecionaOProjetoEClicaNoBotao("Desafio jMeter Project 1")
                .preencherCampoDescription("test descricao")
                .submeterCadastroDoBug()
                .retornaMensagemDeErro();

        assertEquals("A necessary field \"Summary\" was empty. Please recheck your inputs.", retornaMensagemDeErro);

    }

    @Ignore
    public void testDemorarParaSubmeterOFormularioDoBug(){

        String retornaMensagemDeErro = new LoginPage(driver)
                .realizarLogin("van.eyck","123Mudar")
                .clicarEmReportIssue()
                .selecionaOProjetoEClicaNoBotao("Desafio jMeter Project 1")
                .selecionaCategoria("[All Projects] Teste")
                .preencherCampoSummary("testee")
                .preencherCampoDescription("test descricao")
                .demorarParaSubmeterCadastroDoBug()
                .retornaMensagemDeErro();

        assertEquals("Invalid form security token. This could be caused by a session timeout, or accidentally submitting the form twice.",
                retornaMensagemDeErro);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
