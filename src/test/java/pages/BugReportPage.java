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

}
