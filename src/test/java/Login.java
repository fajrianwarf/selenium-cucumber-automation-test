import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Login {
    @Test
    public void open_browser() {
        WebDriver driver;
        String base_url = "https://kasirdemo.belajarqa.com/";

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(base_url);
    }
}
