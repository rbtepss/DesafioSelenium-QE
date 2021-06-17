package steps;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.Before;
import io.cucumber.java.es.Dado;
import io.cucumber.java.pt.Entao;
import obj.ContaPage;
import obj.DriverPage;
import obj.PessoaPage;
import obj.ProdutoPage;
import obj.VeiculoPage;

public class TestSteps {

	WebDriver driver;
	WebDriverWait wait;
	VeiculoPage veiculo;
	PessoaPage pessoa;
	ProdutoPage produto;
	ContaPage conta;

	@Before
	public void testSetup() {
		veiculo = new VeiculoPage();
		pessoa = new PessoaPage();
		produto = new ProdutoPage();
		conta = new ContaPage();
		driver = new DriverPage().setup();
		wait = new WebDriverWait(driver, 20);
		driver.manage().window().maximize();

	}

	@Dado("que entrei no site")
	public void que_entrei_no_site() {
		driver.get("http://sampleapp.tricentis.com/101/app.php");
	}

	@Dado("selecione a aba Vehicle Data")
	public void selecione_a_aba_vehicle_data() {
		driver.findElement(By.id("entervehicledata")).click();
	}

	@Dado("preencha o formulario Vehicle Data e pressiona next")
	public void preencha_o_formulario_vehicle_data_e_pressiona_next() {
		String resultadoEsperado = "Enter Vehicle Data";
		Assert.assertEquals(resultadoEsperado, driver.getTitle());
		System.out.println(driver.getTitle());

		driver.findElement(By.id("make")).sendKeys(veiculo.makes);

		WebElement modelo = driver.findElement(By.id("model"));
		Select select = new Select(modelo);
		select.selectByVisibleText(veiculo.model);

		driver.findElement(By.id("cylindercapacity")).sendKeys(veiculo.cilinder);
		driver.findElement(By.id("engineperformance")).sendKeys(veiculo.enginer);
		driver.findElement(By.id("dateofmanufacture")).sendKeys(veiculo.manufactureDates);

		WebElement assento = driver.findElement(By.id("numberofseats"));
		Select selectone = new Select(assento);
		selectone.selectByVisibleText(veiculo.seaties);

		driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[1]/div[7]/p/label[2]/span")).click();

		WebElement assentotwo = driver.findElement(By.id("numberofseatsmotorcycle"));
		Select selectwo = new Select(assentotwo);
		selectwo.selectByVisibleText(veiculo.seaties);

		WebElement tipoComb = driver.findElement(By.id("fuel"));
		Select selectthree = new Select(tipoComb);
		selectthree.selectByVisibleText(veiculo.fuelTypes);

		driver.findElement(By.id("payload")).sendKeys(veiculo.payload);
		driver.findElement(By.id("totalweight")).sendKeys(veiculo.weight);
		driver.findElement(By.id("listprice")).sendKeys(veiculo.listPrices);
		driver.findElement(By.id("licenseplatenumber")).sendKeys(veiculo.plateNumbers);
		driver.findElement(By.id("annualmileage")).sendKeys(veiculo.annualMileages);

		driver.findElement(By.id("nextenterinsurantdata")).click();
	}

	@Dado("preencha o formulario Insurant Data e presiona next")
	public void preencha_o_formulario_insurant_data_e_presiona_next() {
		String resultadoEsperado = "Enter Insurant Data";
		Assert.assertEquals(resultadoEsperado, driver.getTitle());
		System.out.println(driver.getTitle());

		driver.findElement(By.id("firstname")).sendKeys(pessoa.name);
		driver.findElement(By.id("lastname")).sendKeys(pessoa.lastname);
		driver.findElement(By.id("birthdate")).sendKeys(pessoa.age);
		driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[2]/div[4]/p/label[1]/span")).click();
		driver.findElement(By.id("streetaddress")).sendKeys(pessoa.ender);

		WebElement pais = driver.findElement(By.id("country"));
		Select selectfour = new Select(pais);
		selectfour.selectByVisibleText(pessoa.country);

		driver.findElement(By.id("zipcode")).sendKeys(pessoa.cep);
		driver.findElement(By.id("city")).sendKeys(pessoa.city);

		WebElement ocupacao = driver.findElement(By.id("occupation"));
		Select selectfive = new Select(ocupacao);
		selectfive.selectByValue(pessoa.ocupacao);

		driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[2]/div[10]/p/label[4]/span")).click();
		driver.findElement(By.id("website")).sendKeys(pessoa.site);
		driver.findElement(By.id("picture")).sendKeys(pessoa.imagem);

		driver.findElement(By.id("nextenterproductdata")).click();
	}

	@Dado("preencha o formulario Product Data e presiona next")
	public void preencha_o_formulario_product_data_e_presiona_next() {
		String resultadoEsperado = "Enter Product Data";
		Assert.assertEquals(resultadoEsperado, driver.getTitle());
		System.out.println(driver.getTitle());

		driver.findElement(By.id("startdate")).sendKeys(produto.startdate);

		WebElement soma = driver.findElement(By.id("insurancesum"));
		Select selectsix = new Select(soma);
		selectsix.selectByValue(produto.insurance);

		WebElement merit = driver.findElement(By.id("meritrating"));
		Select selectseven = new Select(merit);
		selectseven.selectByValue(produto.meritrating);

		WebElement damage = driver.findElement(By.id("damageinsurance"));
		Select selecteigth = new Select(damage);
		selecteigth.selectByValue(produto.damageinsurance);

		driver.findElement(By.xpath("//*//*[@id='insurance-form']/div/section[3]/div[5]/p/label[1]/span")).click();

		WebElement courtesy = driver.findElement(By.id("courtesycar"));
		Select selectnine = new Select(courtesy);
		selectnine.selectByValue(produto.courtesycar);

		driver.findElement(By.id("nextselectpriceoption")).click();

	}

	@Dado("preencha o formulario Price Option e presiona next")
	public void preencha_o_formulario_price_option_e_presiona_next() {
		String resultadoEsperado = "Select Price Option";
		Assert.assertEquals(resultadoEsperado, driver.getTitle());
		System.out.println(driver.getTitle());

		driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tfoot/tr/th[2]/label[4]/span")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("nextsendquote"))).click();

	}

	@Dado("preencha o formulario Send Quote e pressione send")
	public void preencha_o_formulario_send_quote_e_pressione_send() {
		String resultadoEsperado = "Send Quote";
		Assert.assertEquals(resultadoEsperado, driver.getTitle());
		System.out.println(driver.getTitle());

		driver.findElement(By.id("email")).sendKeys(conta.email);
		driver.findElement(By.id("phone")).sendKeys(conta.phone);
		driver.findElement(By.id("username")).sendKeys(conta.username);
		driver.findElement(By.id("password")).sendKeys(conta.password);
		driver.findElement(By.id("confirmpassword")).sendKeys(conta.confirmpassword);
		driver.findElement(By.id("Comments")).sendKeys(conta.comments);

		wait.until(ExpectedConditions.elementToBeClickable(By.id("sendemail"))).click();

	}

	@Entao("verifique na tela a mensagem {string}")
	public void verifique_na_tela_a_mensagem(String mensagem) {
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		String textoElement = driver.findElement(By.xpath("/html/body/div[4]/h2")).getText();
		Assert.assertEquals(mensagem, textoElement);

	}

	public void after() {
		driver.quit();
	}

}
