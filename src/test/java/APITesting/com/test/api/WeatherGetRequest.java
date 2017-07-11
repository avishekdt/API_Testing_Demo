package APITesting.com.test.api;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;




public class WeatherGetRequest {


	//@Test
	public void test_01(){


		Response r = when().get("http://api.openweathermap.org/data/2.5/weather?q=London&appid=3f0138375bc894ee6deb09160a9bd991");


		System.out.println("status:"+r.getStatusCode());

		Assert.assertEquals(r.getStatusCode(), 200);
	}


	//@Test
	public void test_02(){
 

		Response r = when().get("http://api.openweathermap.org/data/2.5/weather?q=London&appid=3f0138375bc894ee6deb09160a9bd99");


		System.out.println("status:"+r.getStatusCode());
		Assert.assertEquals(r.getStatusCode(), 401);
	}
	
	//parameters
	//@Test
	public void test_03(){
 

		Response r = given().
					param("q","London").
					param("appid","3f0138375bc894ee6deb09160a9bd991").
					when().get("http://api.openweathermap.org/data/2.5/weather");


		System.out.println("status:"+r.getStatusCode());
		Assert.assertEquals(r.getStatusCode(), 200);
		
		
		if(r.getStatusCode()==200)
		{
			System.out.println("API working fine");
		}
		else 
			System.out.println("API is not working");
	}
	
	
	//@Test
	public void test_04(){
 

					given().
					param("q","London").
					param("appid","3f0138375bc894ee6deb09160a9bd991").
					when().
					get("http://api.openweathermap.org/data/2.5/weather").
					then().
					assertThat().statusCode(200);

	}
	
	//@Test
	public void test_05(){
		

		Response r = given().
					param("q","London").
					param("appid","3f0138375bc894ee6deb09160a9bd991").
					when().get("http://api.openweathermap.org/data/2.5/weather");

		System.out.println(r.asString());
	
	}
	
	//@Test
	public void test_06(){
	Response r = given().
				param("id","2172797").
				param("appid","3f0138375bc894ee6deb09160a9bd991").
				when().get("http://api.openweathermap.org/data/2.5/weather");
	
	Assert.assertEquals(r.getStatusCode(), 200);
	System.out.println(r.asString());

	}
	
	//@Test
	public void test_07(){
	Response r = given().
				param("zip","721101,in").
				param("appid","3f0138375bc894ee6deb09160a9bd991").
				when().get("http://api.openweathermap.org/data/2.5/weather");
	
	Assert.assertEquals(r.getStatusCode(), 200);
	System.out.println(r.asString());
	}
	
	//@Test
	public void test_08(){
	Response r = given().
				param("zip","721101,in").
				param("appid","3f0138375bc894ee6deb09160a9bd991").
				when().get("http://api.openweathermap.org/data/2.5/weather");
				
	String actual = r.then().contentType(ContentType.JSON).
			extract().
			path("weather[0].description");
	//Assert.assertEquals(r.getStatusCode(), 200);
	System.out.println(actual);
	}

	
	@Test
	public void test_09(){
		Response r = given().
				param("zip","721101,in").
				param("appid","3f0138375bc894ee6deb09160a9bd991").
				when().get("http://api.openweathermap.org/data/2.5/weather");
				
		String result =r.then().contentType(ContentType.JSON).extract().path("weather[0].description");
		System.out.println(result);
		String lon =String.valueOf(r.then().contentType(ContentType.JSON).extract().path("coord.lon"));
		System.out.println("longitute:"+lon);
		String lat =String.valueOf(r.then().contentType(ContentType.JSON).extract().path("coord.lat"));
		System.out.println("latitute:"+lon);
		
		String result2 = given().
				param("lat",lat).param("lon",lon).
				param("appid","3f0138375bc894ee6deb09160a9bd991").
				when().get("http://api.openweathermap.org/data/2.5/weather").
				then().contentType(ContentType.JSON).extract().path("weather[0].description");
		
		System.out.println(result2);
		Assert.assertEquals(result, result2);
	}
}
//key 3f0138375bc894ee6deb09160a9bd991