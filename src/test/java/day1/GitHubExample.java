package day1;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;


public class GitHubExample {
  @Test(enabled=false,description="Getting all repositories")
  public void getAllRepo() {
	  given()
	  .auth() //Specifying Authentation Needed
	  .oauth2("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")
	  .when()
	  .get("https://api.github.com/user/repos")
	  .then()
	  .log()
	  .body()
	  .statusCode(200)
	  .time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS);
  }
  @Test(enabled=true,description="Adding repository")
  public void addRepository() {
	  JSONObject js=new JSONObject();
	  js.put("name", "tsl968-restAssured3");
	  js.put("description", "I am created by RestAssured");
	  js.put("homepage", "https://github.com/shubhamgaikwad07");
	  given()
	  .auth() //Specifying Authentation Needed
	  .oauth2("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")
	  .header("Content-Type","application/json")
	  .body(js.toJSONString())
	  .when()
	  .post("https://api.github.com/user/repos")
	  .then()
	  .log()
	  .body()
	  .statusCode(201)
	  .time(Matchers.lessThan(5000L),TimeUnit.MILLISECONDS);
  }
}
