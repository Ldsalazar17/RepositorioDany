import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class SauceLabs {

    WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
                .concat("\\src\\test\\resources\\drivers\\chromedriver.exe"));
        /**
         *Precondicion: Se debe contar con acceso a la pagina web
         */
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
    }

    @AfterEach
    public void tearDown() throws InterruptedException {
        /**
         * Postcondiciones, acciones necesarias para dejar la aplicacion en el estado original
         * o de acciones de limpieza post prueba
         */
        Thread.sleep(10000);
        driver.quit();
    }

    @Test
    public void deberiaIniciarSesionCuandoEnviamosCredencialesValidas() throws InterruptedException {

    WebElement botonInicioSesion = driver.findElement(By.xpath("//a[@class='login']"));
    botonInicioSesion.click();

    WebElement cajaEmail = driver.findElement(By.id("email"));
    cajaEmail.sendKeys("ingedanielaluna@gmail.com");

    WebElement cajaPassword = driver.findElement(By.id("passwd"));
    cajaPassword.sendKeys("108817Dany");

    WebElement botonIngresar = driver.findElement(By.id("SubmitLogin"));
    botonIngresar.click();

    //Assertions.assertEquals("My account - My Stores", driver.getTitle());

     WebElement NombreUsuario = driver.findElement(By.xpath("//span[contains(.,'Daniela luna')]"));

        Assertions.assertEquals("Daniela luna", NombreUsuario.getText());

    }

    @Test
    public void deberiaCoincidirElTitulo() throws InterruptedException {
        Assertions.assertEquals("Swag Labs", driver.getTitle());
    }
}
