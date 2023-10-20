package cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class login {
    WebDriver driver;
    String baseUrl = "http://www.saucedemo.com/";

    @Given("Login screen Swag Labs")
    public void login_screen() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        String loginPageAsrt = driver.findElement(By.xpath("//*[@id='root']/div/div[1]")).getText();
        Assert.assertEquals(loginPageAsrt, "Swag Labs");
    }

    @When("Inputting username")
    public void inputting_username() {
        driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys("standard_user");
    }

    @And("Inputting password")
    public void inputting_password() {
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("secret_sauce");
    }

    @And("Submitting login button")
    public void submitting_login_button() {
        driver.findElement(By.xpath("//*[@id='login-button']")).click();
    }

    @Then("User should see dashboard Swag Labs")
    public void user_see_dashboard() {
        String logo = driver.findElement(By.className("app_logo")).getText();
        Assert.assertEquals(logo,"Swag Labs");
        driver.close();
    }

    @And("Inputting wrong password")
    public void inputting_wrong_password() {
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("secretsauce");
    }

    @Then("User should see error message")
    public void user_err_msg() {
        String logo = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
        Assert.assertEquals(logo,"Epic sadface: Username and password do not match any user in this service");
        driver.close();
    }

}
