package com.primerMaven.seguroFalabella;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class falabella {
	WebDriver driver;
	String url = "https://compratusoat.com.co";
	WebDriverWait obj;
	String datos;
	
	@Before
	public void Before() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		obj = new WebDriverWait(driver, 20);
		
	}
	
	@After
	public void After() {
		
			}
	
	@Test
	public void Test() throws InterruptedException {
		/*click("//*[@id=\"col-select-SOAT\"]/div/div/div");//cotizar y comprar
		escribir("//*[@id=\"licence-plate\"]", "dnr327");//escribir placa
		click("//*[@id=\"material-group-habeas_data\"]/div/div");//he leído
		click("//*[@id=\"Step0Button\"]");//quiero cotizar
		escribir("//*[@id=\"step1Data-identificationNumber\"]", "1022998201");//cedula
		click("//*[@id=\"select2-typeVehicles-container\"]");//tipo de vehiculo
		click("//li[@id='select2-typeVehicles-result-6j3v-{\"codClase\":\"7\",\"txtDesc\":\"AUTOS DE NEGOCIO ALQUILER ENSEÑANZA\",\"codTipoVehMinTrans\":\"7\",\"codMarcaSise\":\"CH\",\"codLineaSise\":\"999\",\"codDestinoSise\":\"1\"}");
		click("//*[@id=\"Step0Button\"]");//quiero cotizar*/
		
		
		escribir("//*[@id=\"pro2\"]/div[2]/input", "wdm98e"); //escribir placa
		escribir("//input[@id='mail']", "daniel.envios@gmail.com"); // correo
		escribir("//*[@id=\"name\"]", "Daniel");//nombre
		escribir("//*[@id=\"apellidos\"]", "Grajales");//apellido
		escribir("//*[@id=\"phone\"]", "3228856119");//celular
		click("//*[@id=\"accept\"]");//terminos
		click("//*[@id='modalTerminos' ]//button[@class='btn btn-primary']");
		Thread.sleep(500);
		click("//*[@id='btsubmit']");//cotizar
		submit("//input[@class='btn btn-primary btn-green btn-interno fw-700']");
		//select("//*[@id='combobox']", "11-11001");
		escribir("//*[@id=\"inputSelect\"]", "bogota");
		Thread.sleep(2000);
		WebElement a = driver.findElement(By.xpath("//*[@id=\"inputSelect\"]"));
		a.sendKeys(Keys.ARROW_DOWN);
		a.sendKeys(Keys.ENTER);
		submit("//*[@id=\"paso2\"]/div[4]/div/div[2]/input[1]");
		click("//*[@id=\"paso3\"]/div[3]/div[2]/div/label/span");
		submit("//*[@id=\"paso3\"]/div[4]/div/div[2]/input[1]");
		datos = extraerDatos("//*[@id=\"content\"]/div/div/div/div/div/div[2]");
		System.out.print(datos);
		Assert.assertEquals("Por favor comunícate a nuestra línea de atención al cliente 018000112684 indicando el siguiente número de error E0233 No está autorizado para realizar esta acción.", datos);
	}
	
	public void click(String xpath) {
		WebElement click = obj.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))); 
		click.click();
	}
	
	public void submit(String xpath) {
		WebElement click = obj.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))); 
		click.submit();;
	}
	
	public void escribir(String xpath, String texto) {
		WebElement click = obj.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))); 
		click.sendKeys(texto);
	}
	
	public void select(String xpath, String sel) {
		Select seleccionar = new Select (driver.findElement(By.xpath(xpath)));
		seleccionar.selectByValue(sel);
	}
	
	public String extraerDatos(String xpath) {
		String texto;
		WebElement click = obj.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))); 
		texto = click.getText();
		return texto;
	}
}
 