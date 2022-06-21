import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ts {
   public static void main(String[] args) throws Exception{
    System.setProperty("webdriver.chrome.driver", "/Users/alexabasurto/Desktop/ejercicios_computacion/TC3004b/tests/selenium-tests-BAMX/chromedriver");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("http://localhost:3000/login");
    Thread.sleep(3000);

    driver.findElement(By.name("mail")).sendKeys("456");
    driver.findElement(By.name("password")).sendKeys("123");
    
    driver.findElement(By.className("aceptBtnL")).click();

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    WebElement cierra = driver.findElement(By.className("btnCloseSesion"));
    
    if(driver.getCurrentUrl().contains("TrabajadorSocial")){
        System.out.println("-- > Inicia sesión correctamente a Trabajador Social");
    }else{
        System.out.println("-- x No inicia sesión correctamente a Trabajador Social"); 
    }


    //------------------------------------------------------------------------------------------
    //---------------------------registrar beneficiario como activo-----------------------------

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.findElement(By.xpath("//*[@id='root']/div/a/svg")).click();
    driver.findElement(By.xpath("//*[@id='root']/nav/ul/li[7]/a")).click();//inactivos
    driver.findElement(By.id("search-bar-0")).sendKeys("0000001");
    driver.findElement(By.xpath("//*[@id='btnModalChangeStatus']")).click();
    Thread.sleep(5000);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.findElement(By.className("yesBtn")).click();

    Thread.sleep(5000);
   
    //---------------------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------------------------------
    
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.findElement(By.xpath("//*[@id='root']/div/a/svg")).click();
    driver.findElement(By.xpath("//*[@id='root']/nav/ul/li[2]/a")).click();//lista global

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    JavascriptExecutor js = (JavascriptExecutor) driver;  
    js.executeScript("window.scrollBy(0,1000)");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    
    //---------------------------------------------------------------------------------------------------------
    //Validar que el sistema permita registrar/cargar información de un beneficiario ya registrado en el sistema
    driver.findElement(By.xpath("//*[@id='search-bar-0']")).sendKeys("0000001");
    Thread.sleep(3000);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.findElement(By.xpath("//*[@id='btnModalUploadDocs']")).click();
    //driver.findElement(By.xpath("//*[@id='archivo']")).click();
    Thread.sleep(3000);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.findElement(By.className("closeBtn")).click();

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    //------------------------------------------------------------------------------------------
    //-----------------------------marcar beneficiario inactivo---------------------------------

    driver.findElement(By.id("btnModalChangeStatus")).click();
    driver.findElement(By.className("yesBtn")).click();

    Thread.sleep(5000);
   

    //-----------------------------------------------------------------------------------------------
    //Validar que el sistema permite descargar las tablas de asistencia de los beneficiarios en punto
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.findElement(By.xpath("//*[@id='root']/div/a/svg")).click();
    driver.findElement(By.xpath("//*[@id='root']/nav/ul/li[3]/a")).click();//asistencia en punto
    driver.findElement(By.xpath("//*[@id='cont_tabla']/button")).click();//descargar
    Thread.sleep(5000);


    //----------------------------
    //Validar que el sistema permite descargar  los reportes generados en pdf
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.findElement(By.xpath("//*[@id='root']/div/a/svg")).click();
    driver.findElement(By.xpath("//*[@id='root']/nav/ul/li[3]/a")).click();//reportes
    driver.findElement(By.xpath("//*[@id='cont_tabla']/button")).click();//descargar 

    Thread.sleep(3000);

    //-------------------------------------------------------------------------
    //--------El sistema permite crear, modificar y eliminar beneficiarios-----

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    //-----------------------------------------------------------------------
    //-----El sistema registra una nueva comunidad
    driver.findElement(By.xpath("//*[@id='root']/div/a/svg")).click();//menu
    driver.findElement(By.xpath("//*[@id='root']/nav/ul/li[5]/a")).click();//comunidades y comités
    driver.findElement(By.xpath("//*[@id='btnModalCreateCommunity']")).click();//btn crear comunidad
    //datos
    driver.findElement(By.name("name")).sendKeys("unidos jiutepec");
    Select frecuencia = new Select(driver.findElement(By.name("frequency")));
    frecuencia.selectByIndex(1);
    Select estado = new Select(driver.findElement(By.name("state")));
    estado.selectByIndex(2);
    Select municipio = new Select(driver.findElement(By.name("town")));
    municipio.selectByIndex(5);
    Thread.sleep(3000);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.findElement(By.xpath("//*[@id='cont_tabla']/div[3]/div[2]/div/button")).click();//aceptar(crear comunidad)
    Thread.sleep(3000);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.findElement(By.xpath("//*[@id='search-bar-0']")).sendKeys("unidos jiutepec");//buscar para verificar creación
    
    Thread.sleep(3000);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    //--------------------------------------------------
    //---------El sistema registra un nuevo comité------
    driver.findElement(By.xpath("//*[@id='btnModalCreateCommittee']")).click();//crear comité botón
    //datos
    driver.findElement(By.name("name")).sendKeys("Lorenzo Bartollini");
    driver.findElement(By.name("phone")).sendKeys("7773332222");
    Select comunidad = new Select(driver.findElement(By.xpath("//*[@id='cont_tabla']/div[4]/div[2]/div/select")));
    comunidad.selectByIndex(6);
    Thread.sleep(3000);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.findElement(By.xpath("//*[@id=cont_tabla']/div[4]/div[2]/div/button")).click();//aceptar datos
    JavascriptExecutor js2 = (JavascriptExecutor) driver;  
    js2.executeScript("window.scrollBy(0,1000)");
    Thread.sleep(3000);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
   

    //--------------------------------------------------------
    //El sistema permite la corrección de una asistencia
    driver.findElement(By.xpath("//*[@id='root']/div/a/svg")).click();//menu
    driver.findElement(By.xpath("//*[@id='root']/nav/ul/li[3]/a")).click();//asistencia en punto
    driver.findElement(By.xpath("//*[@id='search-bar-0']")).sendKeys("maria");;//buscar
    driver.findElement(By.xpath("//*[@id='btnModalAttendance']")).click();//poner o quitar asistencia

    Thread.sleep(3000);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    //El sistema registra la petición de un paquete alimentario
    driver.findElement(By.xpath("//*[@id='root']/div/a/svg")).click();//menu
    driver.findElement(By.xpath("//*[@id='root']/nav/ul/li[4]/a")).click();//asistencia en comunidad
    driver.findElement(By.id("btnModalCreatePetition")).click();
    Select comunidadP = new Select(driver.findElement(By.xpath("//*[@id='cont_tabla']/div[3]/div[2]/div/select[1]")));
    comunidadP.selectByIndex(5); 
    driver.findElement(By.name("quantity")).sendKeys("40");
    Select encargadoP = new Select(driver.findElement(By.xpath("//*[@id='cont_tabla']/div[3]/div[2]/div/select[2]")));
    encargadoP.selectByIndex(1);
    Thread.sleep(3000);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.findElement(By.className("aceptBtn")).click();
    
    //El sistema sube correctamente los beneficiarios activos


    Thread.sleep(10000);
    //cierra Sesión
    cierra.click();
   }
}
