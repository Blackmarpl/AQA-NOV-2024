import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestHomework {

    @Test
    public void testLocationQuery() {
     
        RestAssured.baseURI = "https://api.open-meteo.com";

        
        double latitude = 52.52; 
        double longitude = 13.405; 

        
        Response response = RestAssured
                .given()
                .queryParam("latitude", latitude)
                .queryParam("longitude", longitude)
                .queryParam("current_weather", true)
                .when()
                .get("/v1/forecast") // Эндпоинт API
                .then()
                .statusCode(200)
                .extract()
                .response();

        
        String city = response.path("current_weather.city");
        String timezoneDescription = response.path("timezone");

        
        Assert.assertNotNull(city, "City should not be null");

       
        System.out.println("Timezone description: " + timezoneDescription);
    }
}



