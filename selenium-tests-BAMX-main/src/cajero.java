import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class cajero {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "/Users/alexabasurto/Desktop/ejercicios_computacion/TC3004b/tests/selenium-tests-BAMX/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://localhost:3000/login");
        Thread.sleep(3000);

        driver.findElement(By.name("mail")).sendKeys("789");
        driver.findElement(By.name("password")).sendKeys("123");
        
        driver.findElement(By.className("aceptBtnL")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement cierra = driver.findElement(By.className("btnCloseSesion"));
        
        if(driver.getCurrentUrl().contains("Cajero")){
            System.out.println("-- > Inicia sesión correctamente a Cajero");
        }else{
            System.out.println("-- x No inicia sesión correctamente a Cajero"); 
        }

        //pase de lista
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.className("inputCashier")).sendKeys("61");
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.id("btnModalAttendanceCashier")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//*[@id='root']/div/div/div[3]/div/div/table/tr/td[5]/div/div[2]/div/button[1]")).click();//yesBtn
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        driver.findElement(By.className("inputCashier")).sendKeys("61");


        Thread.sleep(5000);

        //cierra Sesión
        cierra.click();
    }
}
