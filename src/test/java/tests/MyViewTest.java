package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import support.Web;

import static org.junit.Assert.*;

public class MyViewTest {

    private WebDriver driver;

    @Before
    public void setUp(){
        driver = Web.creatChrome();
    }

    @Test
    public void testRealizarLogout(){

        boolean exibirBotaoLogin = new LoginPage(driver)
                .realizarLogin("van.eyck","123Mudar")
                .clicarEmLogout()
                .exibirBotaoLogin();

        assertTrue(exibirBotaoLogin);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
