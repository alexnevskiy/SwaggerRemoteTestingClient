import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.api.TestApi;
import io.swagger.client.api.UserApi;
import io.swagger.client.auth.HttpBasicAuth;
import io.swagger.client.model.Answer;
import io.swagger.client.model.Question;
import io.swagger.client.model.Test;
import io.swagger.client.model.User;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Application {
    private static Scanner scanner;
    private static TestApi testApi;
    private static UserApi userApi;
    private static User user;

    public static void main(String[] args) {
        scanner = new Scanner(System.in, StandardCharsets.UTF_8);

        testApi = new TestApi();
        userApi = new UserApi();

        boolean isUserCorrect = false;
        while (!isUserCorrect) {
            user = readUserFromConsole();
            try {
                user = userApi.login(user);
                System.out.println("Аутентификация пройдена. Ваш id на эту сессию: " + user.getUuid());
                isUserCorrect = true;
            } catch (ApiException e) {
                System.out.println("Неправильный пароль.");
            }
        }

//        getTests(); // TODO: Ждёмс Даню =)

        printHelp();
        parseCommand();
    }

    private static User readUserFromConsole() {
        String login = null;
        String password = null;

        System.out.println("Введите логин:");
        if (scanner.hasNext()) {
            login = scanner.nextLine();
        }
        System.out.println("Введите пароль:");
        if (scanner.hasNext()) {
            password = scanner.nextLine();
        }

        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        return user;
    }

    private static void getTests() {
        try {
            List<Test> tests = testApi.getAllTests();
            for (Test test: tests) {
                System.out.println("Тест " + test.getId() + ": " + test.getTestName());
            }
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    private static void getLatestTest() {
        try {
            int score = testApi.getLastResult(user.getUuid());
            System.out.println("Результат последнего теста: " + score + "%");
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    private static void startTest(Long testId) {
        try {
            int questionsCount = testApi.startTest(user.getUuid(), testId);
            for (int i = 1; i <= questionsCount; i++) {
                Question question = testApi.getTestAnswer(user.getUuid(), testId, i);
                System.out.println("Вопрос " + question.getId() + ":");
                System.out.println(question.getQuestion());
                System.out.println("Варианты ответов:");
                List<Answer> answers = question.getAnswers();
                for (Answer answer: answers) {
                    System.out.println(answer.getId() + ".\t" + answer.getAnswer());
                }

                boolean isCorrect = false;
                while (!isCorrect) {
                    if (scanner.hasNext()) {
                        String[] arguments = scanner.nextLine().trim().toLowerCase().split("\\s");
                        try {
                            int answerNumber = Integer.parseInt(arguments[0]);
                            if (answerNumber > 0 && answerNumber <= answers.size()) {
                                isCorrect = true;
                                testApi.postTestAnswer(user.getUuid(), testId, question.getId(), answerNumber);
                            } else {
                                System.out.println("Ответ должен быть в диапазоне от 1 до " + answers.size());
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Некорректный ответ. Введите номер ответа.");
                        }
                    }
                }
            }

            int score = testApi.finishTest(user.getUuid(), testId);
            System.out.println("Вы набрали " + score + "% правильных ответов.");
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    private static void printHelp() {
        System.out.println("exit - Выйти из приложения");
        System.out.println("latest - Получить результаты последнего теста");
        System.out.println("tests - Получить список тестов");
        System.out.println("start i - Начать i-тый тест");
        System.out.println("help - Справка по командам");
    }

    private static void parseCommand() {
        boolean isRunning = true;
        while (isRunning) {
            if (scanner.hasNext()) {
                String[] arguments = scanner.nextLine().trim().toLowerCase().split("\\s");
                switch (arguments[0]) {
                    case "exit":
                        scanner.close();
                        isRunning = false;
                        break;
                    case "latest":
                        getLatestTest();
                        break;
                    case "tests":
                        getTests();
                        break;
                    case "start":
                        try {
                            startTest(Long.valueOf(arguments[1]));
                        } catch (NumberFormatException e) {
                            System.out.println("Неправильный аргумент. Введите номер теста.");
                        }
                        break;
                    case "help":
                        printHelp();
                        break;
                    default:
                        System.out.println("Некорректная команда. Введите help, чтобы получить список команд.");
                }
            }
        }
    }
}
