package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class BugReportPage extends BasePage{
    public BugReportPage(WebDriver driver) {
        super(driver);
    }

    public String retornaProjetoAtual(){

        Select select = new Select(driver.findElement(By.cssSelector("select[name='project_id']")));
        return select.getFirstSelectedOption().getText();

    }

    public BugReportPage selecionaCategoria(String category){

        WebElement element = driver.findElement(By.cssSelector("select[name='category_id']"));
        new Select(element).selectByVisibleText(category);

        return this;
    }

    public BugReportPage selecionaReproduzibilidade(String reproducibility){

        WebElement element = driver.findElement(By.cssSelector("select[name='reproducibility']"));
        new Select(element).selectByVisibleText(reproducibility);

        return this;
    }

    public BugReportPage selecionaGravidade(String severity){

        WebElement element = driver.findElement(By.cssSelector("select[name='severity']"));
        new Select(element).selectByVisibleText(severity);

        return this;
    }

    public BugReportPage selecionaPrioridade(String priority){

        WebElement element = driver.findElement(By.cssSelector("select[name='priority']"));
        new Select(element).selectByVisibleText(priority);

        return this;
    }

    public BugReportPage selecionaPerfil(String profile){

        WebElement element = driver.findElement(By.cssSelector("select[name='profile_id']"));
        new Select(element).selectByVisibleText(profile);

        return this;
    }

    public BugReportPage preencherCampoPlatform(String platform){

        driver.findElement(By.id("platform")).sendKeys(platform);

        return this;
    }

    public BugReportPage preencherCampoOS(String os){

        driver.findElement(By.id("os")).sendKeys(os);

        return this;
    }

    public BugReportPage preencherCampoOsVersion(String osVersion){

        driver.findElement(By.id("os_build")).sendKeys(osVersion);

        return this;
    }

    public BugReportPage preencherCampoSummary(String summary){

        driver.findElement(By.cssSelector("input[name='summary']")).sendKeys(summary);

        return this;
    }

    public BugReportPage preencherCampoDescription(String description){

        driver.findElement(By.cssSelector("textarea[name='description']")).sendKeys(description);

        return this;
    }

    public BugReportPage preencherCampoPassosDeReproducao(String steps){

        driver.findElement(By.cssSelector("textarea[name='steps_to_reproduce']")).sendKeys(steps);

        return this;
    }

    public BugReportPage preencherCampoInformacoesAdicionais(String info){

        driver.findElement(By.cssSelector("textarea[name='additional_info']")).sendKeys(info);

        return this;
    }

    public BugReportPage selecionarArquivo(){

        driver.findElement(By.cssSelector("input[type='file']")).sendKeys("/home/vaneyck/Documentos/teste.txt");

        return this;
    }

    public BugReportPage selecionarStatus(String status){

        driver.findElement(By.xpath("//label[contains(text(),'"+status+"')]/input")).click();

        return this;
    }

    public BugReportPage marcarFlagDeManterRelatorio(){

        driver.findElement(By.id("report_stay")).click();

        return this;
    }

    public BugReportInformationPage submeterCadastroDoBug(){

        driver.findElement(By.cssSelector("input[value='Submit Report']")).click();

        return new BugReportInformationPage(driver);
    }

    public BugReportInformationPage demorarParaSubmeterCadastroDoBug() {

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.MINUTES);

        driver.findElement(By.cssSelector("input[value='Submit Report']")).click();

        return new BugReportInformationPage(driver);
    }

    /**
     * também envia arquivo e marca a flag do relatório
     * */
    public BugReportInformationPage preencherTodosOsCampos(String category, String reproducibility, String severity,
                                                    String priority, String profile, String plataform,
                                                    String os, String osVersion, String summary,
                                                    String description, String steps, String info,
                                                    String status){
            selecionaCategoria(category);
            selecionaReproduzibilidade(reproducibility);
            selecionaGravidade(severity);
            selecionaPrioridade(priority);
            selecionaPerfil(profile);
            preencherCampoPlatform(plataform);
            preencherCampoOS(os);
            preencherCampoOsVersion(osVersion);
            preencherCampoSummary(summary);
            preencherCampoDescription(description);
            preencherCampoPassosDeReproducao(steps);
            preencherCampoInformacoesAdicionais(info);
            selecionarArquivo();
            selecionarStatus(status);
            marcarFlagDeManterRelatorio();
            submeterCadastroDoBug();

        return new BugReportInformationPage(driver);
    }

    public BugReportPage opcoesDeMarcar(String category, String reproducibility, String severity,
                                                   String priority, String profile, String status){

        selecionaCategoria(category);
        selecionaReproduzibilidade(reproducibility);
        selecionaGravidade(severity);
        selecionaPrioridade(priority);
        selecionaPerfil(profile);
        selecionarStatus(status);

        return this;
    }

    public BugReportPage opcoesDePreencher(String plataform, String os, String osVersion, String summary,
                                                      String description, String steps, String info){

        preencherCampoPlatform(plataform);
        preencherCampoOS(os);
        preencherCampoOsVersion(osVersion);
        preencherCampoSummary(summary);
        preencherCampoDescription(description);
        preencherCampoPassosDeReproducao(steps);
        preencherCampoInformacoesAdicionais(info);

        return this;
    }

}
