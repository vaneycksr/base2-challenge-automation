package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BugReportSuccessfulPage extends BasePage{

    public BugReportSuccessfulPage(WebDriver driver){
        super(driver);
    }

    public boolean retornaMensagemDeSucessoAoCadastrarBug(){

        // retorna true, se a mensagem de sucesso for visivel na tela
        return driver.findElement(By.xpath("//div[contains(text(),'Operation successful')]")).isDisplayed();
    }

}
