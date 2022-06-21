import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "path to webdriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://mitec.itesm.mx/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        driver.findElement(By.id("Ecom_User_ID")).sendKeys("Usuario");
        driver.findElement(By.id("Ecom_Password")).sendKeys("contraseña");
        driver.findElement(By.id("submitButton")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.id("nffc")).sendKeys("codigodeverificacion");
        driver.findElement(By.id("loginButton2")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println(driver.findElement(By.className("user__name")).getText());
        
    }
}

//Ecom_User_ID
//Ecom_Password
//submitButton
//div = user__name
