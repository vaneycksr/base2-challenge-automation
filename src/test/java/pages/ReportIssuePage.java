package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ReportIssuePage extends BasePage {

    public ReportIssuePage(WebDriver driver){
        super(driver);
    }

    public ReportIssuePage selecionarProjeto(String project){

        WebElement element = driver.findElement(By.xpath("//form/table/tbody/tr[2]/td[2]/select"));
        new Select(element).selectByVisibleText(project);

        return this;
    }

    public BugReportPage clicarEmSelectProject(){

        driver.findElement(By.cssSelector("input[value='Select Project']")).click();

        return new BugReportPage(driver);
    }

    public BugReportPage selecionaOProjetoEClicaNoBotao(String project){

        selecionarProjeto(project);
        clicarEmSelectProject();

        return new BugReportPage(driver);
    }

}
