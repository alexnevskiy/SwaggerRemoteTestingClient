import io.swagger.client.ApiException;
import io.swagger.client.api.TestApi;
import io.swagger.client.api.UserApi;
import io.swagger.client.model.User;

public class Application {

    public static void main(String[] args) {

        TestApi apiInstance = new TestApi();
        UserApi userApi = new UserApi();
        Integer userUuid = 56; // Integer | выбранный пользователь
        User user = new User();
        user.setLogin("striiii");
        user.setPassword("string");
        Long testId = 789L; // Long | testId для поиска нужного теста
        try {
            user = userApi.login(user);
            System.out.println(user);
        } catch (ApiException e) {
            e.printStackTrace();
        }

        try {
            int lastResult = apiInstance.getLastResult(Long.valueOf(user.getUuid()));
            System.out.println(lastResult);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }
}
