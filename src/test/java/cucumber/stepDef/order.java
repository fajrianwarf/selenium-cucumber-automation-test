package cucumber.stepDef;

import cucumber.stepDef.login;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class order {
    WebDriver driver;
    String baseUrl = "http://www.saucedemo.com/";

    @Given("I already login into dashboard")
    public void login_steps() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        String loginPageAsrt = driver.findElement(By.xpath("//*[@id='root']/div/div[1]")).getText();
        Assert.assertEquals(loginPageAsrt, "Swag Labs");

        driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id='login-button']")).click();

        String logo = driver.findElement(By.className("app_logo")).getText();
        Assert.assertEquals(logo,"Swag Labs");
    }


    @When("Adding backpack to cart")
    public void adding_to_cart() {
        driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']")).click();
    }
    @Then("Go to cart")
    public void go_to_cart() {
        driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a")).click();
    }

    @Then("Checking out product")
    public void checking_out() {
        driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
    }

    @Then("Filling all the form")
    public void filling_all_form() {
        driver.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys("first");
        driver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys("last");
        driver.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys("1234");
    }

    @And("Continuing order")
    public void continuing_order() {
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
    }

    @Then("Finish the order")
    public void finishing_order() {
        driver.findElement(By.xpath("//*[@id=\"finish\"]")).click();
    }

    @Then("User should see order notification")
    public void order_notif() {
        String logo = driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2")).getText();
        Assert.assertEquals(logo,"Thank you for your order!");
        driver.close();
    }

    @Then("Cancel the order")
    public void cancel_order() {
        driver.findElement(By.xpath("//*[@id=\"cancel\"]")).click();
    }

    @Then("User should going back to dashboard")
    public void go_to_dashboard() {
        String logo = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assert.assertEquals(logo,"Products");
        driver.close();
    }
}
