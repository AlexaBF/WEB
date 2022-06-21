import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class su {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "/Users/alexabasurto/Desktop/ejercicios_computacion/TC3004b/tests/selenium-tests-BAMX/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //---------------------------------------------------------------------------------------
        //---------------------------------------------------------------------------------------
        //------------------------------super ususario-------------------------------------------
        //driver.get("http://44.195.187.31:3000");
        driver.get("http://localhost:3000/login");
        //Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

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


        
        //------------------------------------------------------------------------------------------------------
        //------------------------------------------------------------------------------------------------------
        //------validar creación de nuevos usuarios---------

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       
        JavascriptExecutor js = (JavascriptExecutor) driver;  
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    
        WebElement enter = driver.findElement(By.xpath("//*[@id='btnModalInsertUser']"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", enter);

        System.out.println("---------------------");
        driver.findElement(By.name("name")).sendKeys("carmen elizabeth juanita de costabrava cortez");
        driver.findElement(By.name("phone")).sendKeys("7772304207");
        driver.findElement(By.name("mail")).sendKeys("mini.espias@hotmail.com");
        
        Select rol = new Select(driver.findElement(By.name("rol")));
        rol.selectByIndex(3);

        Select branch = new Select(driver.findElement(By.name("branch")));
        branch.selectByIndex(3);

        driver.findElement(By.name("password")).sendKeys("123456789$");

        driver.findElement(By.xpath("//*[@id='container']/div[2]/div[2]/div/button[1]")).click();//ojo contraseña

        Thread.sleep(5000);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.className("aceptBtn")).click();

        Thread.sleep(5000);


        //------------------------------------------------------------------------------------------------------
        //------------------------------------------------------------------------------------------------------
        //------validar modiifcación de usuarios existentes---------

        driver.findElement(By.xpath("//*[@id='search-bar-0']")).sendKeys("carmen elizabeth juanita de costabrava cortez");
        Thread.sleep(3);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//*[@id='btnModalModUser']")).click();
        Thread.sleep(3);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.name("mail")).sendKeys("mini.espias@gmail.com");
        Thread.sleep(3);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Select modBranch = new Select(driver.findElement(By.name("branch")));
        modBranch.selectByIndex(2);

        

        Thread.sleep(5000);
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.className("aceptBtn")).click();

        Thread.sleep(5000);

        //------------------------------------------------------------------------------------------------------
        //------------------------------------------------------------------------------------------------------
        //------validar eliminación de usuarios existentes---------
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//*[@id='search-bar-0']")).sendKeys("carmen elizabeth juanita de costabrava cortez");
        Thread.sleep(3);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.id("btnModalDeleteUser")).click();
        Thread.sleep(3);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.className("yesBtn")).click();
        Thread.sleep(5000);
        


        //------------------------------------------------------------------------------------------------------
        //------Visualizar mediante un reporte todos los paquetes que fueron entregados en comunidades.---------
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath("//*[@id='root']/div/a/svg/path")).click();//abre menu
        Thread.sleep(3);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath("//*[@id='root']/nav/ul/li[3]/a/span")).click();
        Thread.sleep(3);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath("//*[@id='cont_tabla']/button")).click();//descarga todo la tabla

        Thread.sleep(10000);
        //cierra Sesión
        cierra.click();
    }
}
