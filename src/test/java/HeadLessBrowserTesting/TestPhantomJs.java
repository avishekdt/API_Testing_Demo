package HeadLessBrowserTesting;

import io.github.bonigarcia.wdm.PhantomJsDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;

public class TestPhantomJs {

	
	@Test
	public void verifyTitle(){
			
		PhantomJsDriverManager.getInstance().setup();
		WebDriver driver =  new PhantomJSDriver();
		
		driver.get("https://www.facebook.com");
		System.out.println(driver.getTitle());
	}
}
