package tests;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import support.Web;

import static org.junit.Assert.assertEquals;

public class ReportIssueTest {

    private WebDriver driver;

    @Before
    public void setUp(){
        driver = Web.creatChrome();
    }

    @Test
    public void testSelecionarProjetoParaCriarIssue(){

        String projectSelected = "Desafio jMeter Project 2";

        String retornaProjetoAtual = new LoginPage(driver)
                .realizarLogin("van.eyck","123Mudar")
                .clicarEmReportIssue()
                .selecionarProjeto(projectSelected)
                .clicarEmSelectProject()
                .retornaProjetoAtual();

        assertEquals(projectSelected,retornaProjetoAtual);
    }


    @Ignore
    public void tearDown(){
        driver.quit();
    }

}
