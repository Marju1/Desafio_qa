import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;



public class Desafio {

    private WebDriver driver;

    @Before
    public void main(){

        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
    }

    @Test

    public void fluxoPrincipal() {

        driver.findElement(By.name("username")).sendKeys("QA User");

        driver.findElement(By.name("password")).sendKeys("QA Password");

        WebElement commentsBox = driver.findElement(By.name("comments"));
        commentsBox.clear();
        commentsBox.sendKeys("Comentario");


        driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[5]/td/input[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[5]/td/input[2]")).click();

        driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[6]/td/input[1]")).click();

        driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[7]/td/select/option[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[7]/td/select/option[4]")).click();

        driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[8]/td/select/option[1]")).click();

        driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[9]/td/input[2]")).click();


        //Validação

        Assert.assertEquals("QA User", driver.findElement(By.id("_valueusername")).getText());

        Assert.assertEquals("QA Password", driver.findElement(By.id("_valuepassword")).getText());

        Assert.assertEquals("Comentario", driver.findElement(By.id("_valuecomments")).getText());

        Assert.assertEquals("cb1", driver.findElement(By.id("_valuecheckboxes0")).getText());
        Assert.assertEquals("cb2", driver.findElement(By.id("_valuecheckboxes1")).getText());
        Assert.assertEquals("cb3", driver.findElement(By.id("_valuecheckboxes2")).getText());

        Assert.assertEquals("rd1", driver.findElement(By.xpath("//*[@id=\"_valueradioval\"]")).getText());

        Assert.assertEquals("ms1", driver.findElement(By.xpath("//*[@id=\"_valuemultipleselect0\"]")).getText());

        Assert.assertEquals("dd1", driver.findElement(By.xpath("//*[@id=\"_valuedropdown\"]")).getText());

        //Assert.assertEquals("submit", driver.findElement(By.xpath("//*[@id=\"_valuesubmitbutton\"]")).getText());
    }

    @After
    public void fim(){

        driver.quit();
    }
}
