package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static ru.iteco.fmhandroid.ui.utils.Utils.waitForElement;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.pageElement.AboutPageElement;

public class AboutPageSteps {

    @Step("Проверка отображения политики конфиденциальности")
    public static void checkPrivacyPolicy() {
        onView(isRoot()).perform(waitForElement(AboutPageElement.privacyPolicyViewId, 10000));
        AboutPageElement.privacyPolicyView.check(matches(isDisplayed()));
    }

    @Step("Проверка отображения условий использования")
    public static void checkTermsOfUse() {
        AboutPageElement.termsOfUseView.check(matches(isDisplayed()));
    }

    @Step("Проверка отображения версии приложения")
    public static void checkVersion() {
        AboutPageElement.versionView.check(matches(isDisplayed()));
    }

    @Step("Проверка отображения информации о ITECO")
    public static void checkIteco() {
        AboutPageElement.iTecoView.check(matches(isDisplayed()));
    }
}