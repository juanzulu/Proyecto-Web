package com.example.demo.e2e;


import java.time.Duration;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;


import io.github.bonigarcia.wdm.WebDriverManager;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class CasoUnoTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void init() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();


        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-extensions");
        //chromeOptions.addArguments("--headless");

        this.driver = new ChromeDriver(chromeOptions);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
   public void SystemTest_ingresar_CasoUno() {
       
    driver.get("http://localhost:4200/login-veterinario");
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));

    WebElement emailField = driver.findElement(By.id("username"));
    WebElement passwordField = driver.findElement(By.id("password"));

        emailField .sendKeys("wrongUser@example.com");
        passwordField.sendKeys("wrongPassword");
        WebElement btnSubmit = driver.findElement(By.id("login-veterinario"));
        btnSubmit.click();

        emailField.clear();
        passwordField.clear();

        emailField .sendKeys("Lucas0@gmail.com");
        passwordField.sendKeys("12345678");
        btnSubmit.click();




   }

   @Test
   public void SystemTest_agregarusuario_listSize() {
       driver.get("http://localhost:4200/lista-usuarios");
      
       wait.until(ExpectedConditions.presenceOfElementLocated(By.id("boton_crearUsuario")));
       WebElement btnAgregar = driver.findElement(By.id("boton_crearUsuario"));
       btnAgregar.click();
        
      

       WebElement InputNombre = driver.findElement(By.id("nombre"));
       WebElement generoSelect = driver.findElement(By.id("genero"));
       generoSelect.click();
       new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//option[@value='Masculino']")))
           .click(); 

       WebElement InputEdad = driver.findElement(By.id("edad"));
       WebElement InputCedula = driver.findElement(By.id("cedula"));
       WebElement InputCorreo = driver.findElement(By.id("correo"));
       

       InputNombre.sendKeys("pepito");
       InputEdad.sendKeys(Keys.BACK_SPACE);
       InputEdad.sendKeys("26");
       InputCedula.sendKeys(Keys.BACK_SPACE);
       InputCedula.sendKeys("1234567890");
       InputCorreo.sendKeys("pepito@pepito");

       WebElement btnSubmit = driver.findElement(By.id("enviar"));
       btnSubmit.click();

       List<WebElement> list = driver.findElements(By.className("liStudentName"));
       Assertions.assertThat(list.size()).isEqualTo(51);
   }

   @AfterEach
   void tearDown() {
       //driver.quit();
   }

}
