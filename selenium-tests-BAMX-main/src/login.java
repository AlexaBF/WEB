import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "computer direction***/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //---------------------------------------------------------------------------------------
        //---------------------------------------------------------------------------------------
        //------------------------------super ususario-------------------------------------------
        
        driver.get("http://localhost:3000/login");
        Thread.sleep(3000);

        driver.findElement(By.name("mail")).sendKeys("123");
        driver.findElement(By.name("password")).sendKeys("123");
        
        driver.findElement(By.className("aceptBtnL")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement cierra = driver.findElement(By.className("btnCloseSesion"));
        
        if(driver.getCurrentUrl().contains("SuperUsuario")){
            System.out.println("-- > Inicia sesión correctamente a super usuario");
        }else{
            System.out.println("-- x No inicia sesión correctamente a super usuario"); 
        }

        Thread.sleep(10000);
        //cierra Sesión
        cierra.click();

        //---------------------------------------------------------------------------------------
        //---------------------------------------------------------------------------------------
        //---------------------------------------Trabajador Social-------------------------------
        
        Thread.sleep(5000);

        driver.findElement(By.name("mail")).sendKeys("456");
        driver.findElement(By.name("password")).sendKeys("123");
        
        driver.findElement(By.className("aceptBtnL")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement cierra2 = driver.findElement(By.className("btnCloseSesion"));

        if(driver.getCurrentUrl().contains("TrabajoSocial") ){
            System.out.println("-- > Inicia sesión correctamente a trabajador Social");
        }else{
            System.out.println("-- x No inicia sesión correctamente a Trabajador Social"); 
        }

        Thread.sleep(10000);
        //cierra Sesión
        cierra2.click();
        
        //---------------------------------------------------------------------------------------
        //---------------------------------------------------------------------------------------
        //-----------------------------------------Cajera----------------------------------------
        
        Thread.sleep(5000);

        driver.findElement(By.name("mail")).sendKeys("789");
        driver.findElement(By.name("password")).sendKeys("123");
        
        driver.findElement(By.className("aceptBtnL")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement cierra3 = driver.findElement(By.className("btnCloseSesion"));

        if(driver.getCurrentUrl().contains("Cajero")){
            System.out.println("-- > Inicia sesión correctamente a Cajero");
        }else{
            System.out.println("-- x No inicia sesión correctamente a Cajero"); 
        }

        Thread.sleep(10000);
        //cierra Sesión
        cierra3.click();
        
        
    }
}
