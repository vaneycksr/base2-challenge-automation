package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BugReportInformationPage extends BasePage{

    public BugReportInformationPage(WebDriver driver){
        super(driver);
    }

    // a pagina estava carregando muito rapido, por isso optei por pegar assim a mensagem de sucesso
    public boolean retornaMensagemDeSucessoAoCadastrarBug(){

        // retorna true, se a mensagem de sucesso for visivel na tela
        return driver.findElement(By.xpath("//div[contains(text(),'Operation successful')]")).isDisplayed();
    }

    public String retornaMensagemDeErro(){

        return driver.findElement(By.xpath("(//p)[1]")).getText();
    }

}
