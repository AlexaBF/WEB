import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "webdriver computer direction***");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.get("http://44.195.187.31:3000");
        driver.get("http://localhost:3000/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        driver.findElement(By.name("mail")).sendKeys("123");
        driver.findElement(By.name("password")).sendKeys("123");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        

        //inicia sesión como super usuario
        
        driver.findElement(By.className("aceptBtnL")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        System.out.println(driver.findElement(By.className("navbar")).getText());

        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
        //cierra Sesión
        //driver.findElement(By.className("btnCloseSesion")).click();
        driver.get("http://localhost:3000/login"); 

        
        
    }
}
