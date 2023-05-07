import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import steps.User;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static utils.UserGenerator.generateUserData;

@DisplayName("Создание пользователя")
public class CreateUserTest {
    private User user;
    String accessToken;

    @Before
    public void setUp() {
        user = new User();
    }

    @Test
    @DisplayName("Создание пользователя с валидными данными")
    public void successfullyCreateUserTest() {
        Map<String, String> data = generateUserData();
        Response response = user.createUser(data.get("email"), data.get("password"), data.get("username"));
        accessToken = response.path("accessToken");
        assertEquals("Неверный код ответа", 200, response.statusCode());
    }

    @Test
    @DisplayName("Повторное создание пользователя")
    public void createUserThatAlreadyRegisteredTest() {
        Map<String, String> data = generateUserData();
        Response firstUser = user.createUser(data.get("email"), data.get("password"), data.get("username"));
        accessToken = firstUser.path("accessToken");
        Response response = user.createUser(data.get("email"), data.get("password"), data.get("username"));
        assertEquals("Неверный код ответа", 403, response.statusCode());
        assertEquals("Невалидные данные в ответе: message", "User already exists", response.path("message"));
    }

    @Test
    @DisplayName("Создание пользователя без заполнения одного из обязательных полей")
    public void createUserWithoutFillingInOneRequiredFieldsTest() {
        Map<String, String> data = generateUserData();
        Response response = user.createUser(data.get("email"), data.get(""), data.get("username"));
        accessToken = response.path("accessToken");
        assertEquals("Неверный код ответа", 403, response.statusCode());
        assertEquals("Невалидные данные в ответе: message", "Email, password and name are required fields", response.path("message"));
    }

    @After
    public void cleanUp() {
        if (accessToken != null) {
            user.deleteUser(accessToken);
        }
    }
}
