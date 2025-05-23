package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static ru.iteco.fmhandroid.ui.utils.Utils.waitForElement;

import android.view.View;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pageElement.AuthPageElement;

public class AuthSteps {
    private static final AuthPageElement authPageElement = new AuthPageElement();
    @Step("Заполнение поля логина")
    public static void fillLogin(String login) {
        Allure.step("Заполнение поля логина: " + login);
        onView(isRoot()).perform(waitForElement(authPageElement.getLoginTextInputLayoutId(),10000));
        authPageElement.getInputLoginField().perform(replaceText(login));
    }
    @Step("Заполнение поля пароля")
    public static void fillPassword(String password) {
        Allure.step("Заполнение поля пароля: " + password);
        authPageElement.getInputPasswordField().perform(replaceText(password));
    }
    @Step("Нажатие кнопки Sign In")
    public static void pushEnterButton(){
        Allure.step("Нажатие кнопки Sign In");
        onView(isRoot()).perform(waitForElement(authPageElement.getEnterButtonId(), 5000));
        authPageElement.getEnterButton().perform(click());
    }

    @Step("Проверка сообщения о не пустом пароле и логине")
    public static void checkMessageEmptyLoginAndPassword(ActivityScenarioRule<AppActivity> mActivityScenarioRule){
        final View[] decorView = new View[1];
        mActivityScenarioRule.getScenario().onActivity(activity -> {
            decorView[0] = activity.getWindow().getDecorView();
        });
        authPageElement.getEmptyLoginAndPasswordMessage().inRoot(withDecorView(not(is(decorView[0]))))
                .check(matches(isDisplayed()));
    }
    @Step("Проверка сообщения о том, что что-то пошло не так ")
    public static void checkSomethingWrongMessage(ActivityScenarioRule<AppActivity> mActivityScenarioRule){
        final View[] decorView = new View[1];
        mActivityScenarioRule.getScenario().onActivity(activity -> {
            decorView[0] = activity.getWindow().getDecorView();
        });
        authPageElement.getSomethingWrongMessage().inRoot(withDecorView(not(is(decorView[0]))))
                .check(matches(isDisplayed()));
    }

    @Step("Проверка наличия текста авторизации")
    public static void checkAuthorizationText(){
        onView(isRoot()).perform(waitForElement(authPageElement.getAuthorizationTextId(),10000));
    }
}
