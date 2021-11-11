package day1;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class OpenWeatherAPI {
  @Test(enabled=false,description="Getting weather API information Generally")
  public void getWeatherInfo() {
	 RestAssured.given()
	 			.when()
	 			.get("http://api.openweathermap.org/data/2.5/weather?q=Mumbai&appid=bf79bd948b1eec6194a3c080b7800321")
	 			.then()
	 			.log()
	 			.body()
	 			.statusCode(200);
  }
  @Test(enabled=false,description="Getting weather API information Generally")
  public void getWeatherInfo2() {
	 Response res=RestAssured.given()
	 			.when()
	 			 .get("http://api.openweathermap.org/data/2.5/weather?q=Mumbai&appid=bf79bd948b1eec6194a3c080b7800321");
	 System.out.println(res.prettyPrint());
	 System.out.println(res.getTime());
	 System.out.println(res.getStatusCode());
	 System.out.println(res.getContentType());
}
  @Test(enabled=false,description="Getting weather API information Generally")
  public void getWeatherInfo3() {
	 RestAssured.given()
	 			.queryParam("q", "Mumbai")
	 			.queryParam("appid", "bf79bd948b1eec6194a3c080b7800321")
	 			.when()
	 			.get("http://api.openweathermap.org/data/2.5/weather")
	 		.then()
	 			.log()
	 			.body()
	 			.statusCode(200);
}
  @Test(enabled=true,description="Getting weather API information Generally")
  public void getWeatherInfo4() {
  Map<String,String> param=new HashMap<String,String>();
  param.put("q", "Mumbai");
  param.put("appid", "bf79bd948b1eec6194a3c080b7800321");
  RestAssured.given()
  .params(param)
  .when()
   .get("http://api.openweathermap.org/data/2.5/weather")
  .then()
   .log()
   .body()
   .statusCode(200);
   }
}
