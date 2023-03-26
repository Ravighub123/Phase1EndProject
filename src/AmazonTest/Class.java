package AmazonTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		WebElement Searchtext = driver.findElement(By.id("twotabsearchtextbox"));
		Searchtext.sendKeys("samsung mobile");

		WebElement Lens = driver.findElement(By.id("nav-search-submit-button"));
		Lens.click();

		List<WebElement> product_names = driver.findElements(By.xpath("//div[@class='a-section']//h2//span"));

		List<WebElement> product_price = driver
				.findElements(By.xpath("//div[@class='a-section']//a//span[@class='a-price-whole']"));

		List<WebElement> rupees = driver
				.findElements(By.xpath("//div[@class='sg-row']//span[@class='a-price-symbol']"));

		for (int i = 0; i < product_names.size(); i++) {
			System.out.println("Product : " + product_names.get(i).getText());
			System.out.println("Price : " + rupees.get(i).getText() + " " + product_price.get(i).getText());
		}
		
		driver.close();

	}
}
