package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;

    public BasePage (WebDriver driver){
        this.driver = driver;
    }

    public String mensagemDeErroIncomum(){

        return driver.findElement(By.xpath("//div[@align='center'][2]")).getText();
    }





}
