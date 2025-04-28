package stepdef;

import hooks.Hooks;
import io.cucumber.java.be.I;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Agrichain {

    private WebDriver driver = Hooks.getDriver();

    @Given("User is on the Aghrichain Dashboard Page")
    public void userIsOnDashboard() throws  Exception{
        System.out.println("Initial set for chromedriver");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("");
        Thread.sleep(5000);
        System.out.println(driver.getTitle().toString());
    }

    @When("User enter the valid string as input")
    public void userEnterTheValidStringAsInput() throws Exception {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("inputText")).sendKeys("abcbag");
        Thread.sleep(3000);
        driver.findElement(By.id("submit")).click();
        Thread.sleep(3000);
    }

    @Then("User validate the expected output")
    public void userValidateTheExpectedOutput() throws Exception {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String url =driver.getCurrentUrl();
        Assert.assertTrue(url.contains("result"));

        String out = driver.findElement(By.id("'output")).getText();
        Assert.assertTrue(!out.isEmpty());

        driver.findElement(By.id("Home")).click();

        driver.close();

    }
}
