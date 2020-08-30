package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import support.Web;

import static org.junit.Assert.*;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "testPreencherTodosOsCamposDoCadastroDeBug.csv")
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
    public void testPreencherTodosOsCamposDoCadastroDeBug(@Param(name = "project")String project, @Param(name = "category")String category,
                                                          @Param(name = "reproducibility")String reproducibility, @Param(name = "severity")String severity,
                                                          @Param(name = "priority")String priority, @Param(name = "profile")String profile,
                                                          @Param(name = "status")String status, @Param(name = "plataform")String plataform,
                                                          @Param(name = "os")String os, @Param(name = "osVersion")String osVersion,
                                                          @Param(name = "summary")String summary, @Param(name = "description")String description,
                                                          @Param(name = "steps")String steps, @Param(name = "info")String info
                                                        ){

        boolean mensagemDeSucessoAoCadastrarBug = new LoginPage(driver)
                .realizarLogin("van.eyck","123Mudar")
                .clicarEmReportIssue()
                .selecionaOProjetoEClicaNoBotao(project)
                .opcoesDeMarcar(category,reproducibility,severity,priority,profile,status)
                .opcoesDePreencher(plataform,os, osVersion, summary,description, steps, info)
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
