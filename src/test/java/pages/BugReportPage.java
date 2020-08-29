package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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

    public BugReportPage preencherCampoSummary(String summary){

        driver.findElement(By.cssSelector("input[name='summary']")).sendKeys(summary);

        return this;
    }

    public BugReportPage preencherCampoDescription(String description){

        driver.findElement(By.cssSelector("textarea[name='description']")).sendKeys(description);

        return this;
    }

    public BugReportSuccessfulPage submeterCadastroDoBug(){

        driver.findElement(By.cssSelector("input[value='Submit Report']")).click();

        return new BugReportSuccessfulPage(driver);
    }

}
