package HeadLessBrowserTesting;

import io.github.bonigarcia.wdm.PhantomJsDriverManager;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;

public class TestHTMLUnit {

	@Test
	public void verifyTitle(){
		
		WebDriver driver =  new HtmlUnitDriver();
		
		driver.get("https://www.facebook.com");
		System.out.println(driver.getTitle());
	}
}
