package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import support.Web;

import static org.junit.Assert.assertEquals;

public class LoginTest {

    private WebDriver driver;
    private static final String MSG_ERRO = "Your account may be disabled or blocked or the username/password you entered is incorrect.";

    @Before
    public void setUp(){
        driver = Web.creatChrome();
    }

    @Test
    public void testRealizarLoginComSucesso(){

        String nomeDoUsuarioLogado = new LoginPage(driver)
                .realizarLogin("van.eyck","123Mudar")
                .retornaNomeDoUsuarioLogado();

        assertEquals("van.eyck",nomeDoUsuarioLogado);
    }

    @Test
    public void testRealizarLoginSemPreencherOsCampos(){

        String mensagemDeErroIncomum = new LoginPage(driver)
                .clicarNoBotaoLogin()
                .mensagemDeErroIncomum();

        assertEquals(MSG_ERRO,mensagemDeErroIncomum);
    }

    @Test
    public void testRealizarLoginUsernameCorretoPasswordErrado(){

        String mensagemDeErroIncomum = new LoginPage(driver)
                .realizarLogin("van.eyck","123456")
                .mensagemDeErroIncomum();

        assertEquals(MSG_ERRO,mensagemDeErroIncomum);
    }

    @Test
    public void testRealizarLoginUsernameErradoPasswordCorreto(){

        String mensagemDeErroIncomum = new LoginPage(driver)
                .realizarLogin("van","123Mudar")
                .mensagemDeErroIncomum();

        assertEquals(MSG_ERRO,mensagemDeErroIncomum);
    }

    @Test
    public void testRealizarLoginUsernameErradoPasswordErrado(){

        String mensagemDeErroIncomum = new LoginPage(driver)
                .realizarLogin("van","123")
                .mensagemDeErroIncomum();

        assertEquals(MSG_ERRO,mensagemDeErroIncomum);

    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
