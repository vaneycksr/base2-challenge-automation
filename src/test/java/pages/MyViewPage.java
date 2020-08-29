package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyViewPage extends BasePage{

    public MyViewPage(WebDriver driver){
        super(driver);
    }

    public String retornaNomeDoUsuarioLogado(){

        return driver.findElement(By.xpath("(//span[@class='italic'])[1]")).getText();
    }


    public ReportIssuePage clicarEmReportIssue(){

        driver.findElement(By.linkText("Report Issue")).click();

        return new ReportIssuePage(driver);
    }

    public LoginPage clicarEmLogout(){

        driver.findElement(By.linkText("Logout")).click();

        return new LoginPage(driver);
    }


}
