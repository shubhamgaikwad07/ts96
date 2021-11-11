package day1;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class PositiveTest {
	String id;
	
  @Test(enabled = false, description = "For getting all contact list")
  public void getAllContactList() {
	  
	  given()
	  .when()
	  	.get("http://3.13.86.142:3000/contacts")
	  .then()
	  	.log()
	  	.body()
	  	.statusCode(200);
  }
  
  @Test(enabled = true, description = "Adding Contact")
  public void addContact() {
	  JSONObject loc = new JSONObject();
	  loc.put("city", "Mumbai");
	  loc.put("country", "India");
	  
	  JSONObject emp = new JSONObject();
	  emp.put("jobTitle", "Automation Testing");
	  emp.put("company", "LTI");
	  
	  JSONObject ob = new JSONObject();
	  ob.put("firstName", "Amy");
	  ob.put("lastName", "Smith");
	  ob.put("email", "asmith@thinkingtester.com");
	  ob.put("location", loc);
	  ob.put("employer", emp);
	  
	  id = given()
	  	.header("Content-Type","application/json")
	  	.body(ob.toJSONString())
	  .when()
	  	.post("http://3.13.86.142:3000/contacts")
	  .then()
	  	.log()
	  	.body()
	  	.statusCode(200)
	  	.extract()
	  	.jsonPath()
	  	.get("_id");
	  System.out.println("ID is "+id);
  }
  
  @Test(enabled = true, description = "Getting Contact")
  public void getContact() {
	  given()
	  .when()
	  	.get("http://3.13.86.142:3000/contacts/"+id)
	  .then()
	  	.log()
	  	.body()
	  	.statusCode(200);
  }
}