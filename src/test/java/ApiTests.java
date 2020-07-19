import io.restassured.http.ContentType;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import pojo.ResponseEntry;
import pojo.User;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertTrue;

/**
 * Класс для API тестов
 */
public class ApiTests {

    final static String BASE_URL = "https://reqres.in/api/users";

    @Test
    @Description("Проверка GET запроса к адресу 'https://reqres.in/api/users?page=2'")
    public void checkRequestGet() {
        ResponseEntry responseEntry = given()
                .param("page", 2)
                .get(BASE_URL)
                .then()
                .statusCode(200)
                .assertThat()
                .contentType(ContentType.JSON)
                .assertThat()
                .extract()
                .body()
                .as(ResponseEntry.class);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<ResponseEntry>> violations = validator.validate(responseEntry);
        assertTrue(violations.isEmpty());
    }

    @Test
    @Description("Проверка корректного POST запроса к адресу 'https://reqres.in/api/users'")
    public void checkRequestPost() {
        User user = new User("morpheus", "leader");
        given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(BASE_URL)
                .then()
                .statusCode(201)
                .body("name", equalTo("morpheus"))
                .body("job", equalTo("leader"));
    }
}
