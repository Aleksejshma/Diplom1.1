package ru.iteco.fmhandroid.ui.tests;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AuthSteps;
import ru.iteco.fmhandroid.ui.steps.MainPageSteps;
import ru.iteco.fmhandroid.ui.utils.Utils;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
@Epic("Тестирование раздела О приложении")
public class AuthTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    public static final String LOGIN_VALID = "login2";
    public static final String LOGIN_INVALID = "2";
    public static final String PASSWORD_VALID = "password2";
    public static final String PASSWORD_INVALID = "pass2";

    @Test
    @Description("Тест проверяет, что пользователь не может авторизоваться с пустыми полями")
    public void testLoginWithEmptyFieldsShowsToast() {
        Utils.checkAuthPage();
        AuthSteps.pushEnterButton();
        AuthSteps.checkMessageEmptyLoginAndPassword(this.mActivityScenarioRule);
    }

    @Test
    @Description("Тест проверяет, что пользователь не может авторизоваться с невалидными логином и паролем")
    public void testInvalidLoginAndPassword() {
        Utils.checkAuthPage();
        AuthSteps.fillLogin(LOGIN_INVALID);
        AuthSteps.fillPassword(PASSWORD_INVALID);
        AuthSteps.pushEnterButton();
        AuthSteps.checkSomethingWrongMessage(this.mActivityScenarioRule);
    }

    @Test
    @Description("Тест проверяет, что пользователь может авторизоваться с валидными логином и паролем и разлогиниться")
    public void validAuthTestAndLogOut()  {
        Utils.checkAuthPage();
        AuthSteps.fillLogin(LOGIN_VALID);
        AuthSteps.fillPassword(PASSWORD_VALID);
        AuthSteps.pushEnterButton();
        MainPageSteps.checkNewsLabel();
        MainPageSteps.checkOurMissionLabel();
        MainPageSteps.pushLogOutButton();
        AuthSteps.checkAuthorizationText();

    }

    @Test
    @Description("Тест проверяет, что пользователь может авторизоваться с валидными логином и паролем")
    public void authorizationTest_ValidLoginAndPassword_Success() {
        Utils.checkAuthPage();
        AuthSteps.fillLogin(LOGIN_VALID);
        AuthSteps.fillPassword(PASSWORD_VALID);
        AuthSteps.pushEnterButton();
        MainPageSteps.checkNewsLabel();
        MainPageSteps.checkOurMissionLabel();
    }

}
