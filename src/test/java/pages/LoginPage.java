package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public LoginPage digitarUsername(String username){

        driver.findElement(By.cssSelector("input[name='username']")).sendKeys(username);

        return this;
    }

    public LoginPage digitarPassword(String password){

        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);

        return this;
    }

    public MyViewPage clicarNoBotaoLogin(){

        driver.findElement(By.cssSelector("input[value='Login']")).click();

        return new MyViewPage(driver);
    }

    public  MyViewPage realizarLogin(String username, String password){

        digitarUsername(username);
        digitarPassword(password);
        clicarNoBotaoLogin();

        return new MyViewPage(driver);
    }


}
