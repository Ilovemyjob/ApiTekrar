package testPackage;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest01 {
    @Test
    public void getMethod(){
//response suzda oluyor ama biz java bilgimizi kulllandik bu consolda gozuktu postman kullanmadik
            Response response = given().
            accept("application/json").
            when().
            get("https://restful-booker.herokuapp.com/booking/3");

      response.prettyPrint();

        System.out.println(response.statusCode());
        System.out.println(response.contentType());
        System.out.println(response.getStatusLine());


            response.then().
            assertThat().contentType(ContentType.JSON).body("firstname", equalTo("Sally"),
                                                        "lastname", equalTo("Wilson"),
                                                     "bookingdates.checkin", equalTo("2018-10-07"));

//gondergit buna bak dogrula, olup olmadigini kontrolet
//response larla cikti alabiliyoruz

    }

}
