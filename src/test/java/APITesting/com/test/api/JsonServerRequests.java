package APITesting.com.test.api;

import org.testng.annotations.Test;

import APITesting.com.test.classes.Info;
import APITesting.com.test.classes.Posts;
import APITesting.com.test.classes._Posts;
import APITesting.com.test.classes.advancedExample._Info;
import APITesting.com.test.classes.advancedExample.__Posts;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers.*;

public class JsonServerRequests {

	
	//@Test
	public void Test_01(){
		Response r = given().
					 when().
					 get("http://localhost:3000/posts");
		
		System.out.println(r.asString());
	}
	
	//@Test
	public void Test_02(){
		Response r = given().
				     body("{\"id\":\"2\","
				     		+ " \"title\":\"dummy\","
				     		+ "\"author\": \"avishek\" } " ).
					 when().
					 contentType(ContentType.JSON).
					 post("http://localhost:3000/posts");
		
		System.out.println(r.asString());
	}
	
	
	//@Test
		public void Test_03(){
		Posts posts = new Posts();
		posts.setId("3");
		posts.setTitle("title2");
		posts.setAuthor("AD");
		
		Response r = given().when().contentType(ContentType.JSON).
		body(posts).post("http://localhost:3000/posts");
		
		System.out.println(r.asString());
		System.out.println(r.getStatusCode());
	
	
	}
		

		//@Test
			public void Test_04(){
			Response r = given().when().contentType(ContentType.JSON).
					body("{\"title\":\"update\"}").patch("http://localhost:3000/posts/3");
					
					System.out.println(r.asString());
					System.out.println(r.getStatusCode());
				
			
		
		}
			
			//delete
			//@Test
			public void Test_05(){
			Response r = given().when().delete("http://localhost:3000/posts/2");
					
					System.out.println(r.asString());
					System.out.println(r.getStatusCode());
				
			
		
		}
			
			//Complex post
			//@Test
			public void Test_06(){
				
				
			Info info =new Info();
			info.setEmail("abc@abcd.com");
			info.setPhone("264120");
			info.setAddress("kol");
			_Posts posts = new _Posts();
			posts.setId("199");
			posts.setTitle("title");
			posts.setAuthor("anubhab");
			posts.setInfo(info);
			
			Response r = given().when().contentType(ContentType.JSON).
			body(posts).post("http://localhost:3000/posts");
			
			System.out.println(r.asString());
			System.out.println(r.getStatusCode());
		
}
			
			//Complex post advanced
			
			//@Test
			public void test_07(){
				_Info info1 =new _Info();
				
				info1.setEmail("test1");
				info1.setPhone("test1");
				info1.setAddress("test1");
				
				_Info info2 =new _Info();
				info2.setEmail("test2");
				info2.setPhone("test2");
				info2.setAddress("test2");
				
				__Posts posts = new __Posts();
				posts.setId("100");
				posts.setTitle("title");
				posts.setAuthor("author");
				posts.setInfo(new _Info[]{info1, info2});
				
				Response r = given().when().contentType(ContentType.JSON).
						body(posts).post("http://localhost:3000/posts");
						
						System.out.println(r.asString());
						System.out.println(r.getStatusCode());
					
				
				
			}
			
			
			//calculate response time performance
			@Test
			public void test_08(){
				Response r = given().
						 when().
						 get("http://localhost:3000/posts");
			
			Long time = r.then().extract().time();
			System.out.println("time in milliseconds:"+time);
			System.out.println(r.asString());
			

			}
			
}