package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static ru.iteco.fmhandroid.ui.utils.Utils.waitForElement;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.pageElement.MainPageElement;

public class MainPageSteps {
    private static final MainPageElement mainPageElement = new MainPageElement();
    @Step("Проверка надпись News на главной странице")
    public static void checkNewsLabel(){
        onView(isRoot()).perform(waitForElement(mainPageElement.getMainMenuImageButtonId(),10000));
        mainPageElement.getNewsLogoView().check(matches(isDisplayed()));
    }
    @Step("Проверка кнопки \"Наша миссия\" на главной странице")
    public static void checkOurMissionLabel(){
        mainPageElement.getOurMissionLogoView().check(matches(isDisplayed()));
    }

    @Step("Нажатие на кнопку \"Наша миссия\" на главной странице")
    public static void pushOurMissionLabel(){
        onView(isRoot()).perform(waitForElement(mainPageElement.getMainMenuImageButtonId(),10000));
        mainPageElement.getOurMissionLogoView().perform(click());
    }
    @Step("Нажатие на кнопку Log Out")
    public static void pushLogOutButton(){
        mainPageElement.getAuthorizationBlockLogo().perform(click());
        mainPageElement.getLogOutButton().perform(click());
    }

    @Step("Нажатие на бургер")
    public static void pushBurger(){
        onView(isRoot()).perform(waitForElement(mainPageElement.getMainMenuImageButtonId(),10000));
        mainPageElement.getBurgerMenu().perform(click());
    }

    @Step("Нажатие на About в бургер")
    public static void pushAboutBurger(){
        mainPageElement.getAboutInBurgerMenu().perform(click());
    }

    @Step("Нажатие на News в бургер")
    public static void pushNewsBurger(){
        mainPageElement.getNewsInBurgerMenu().perform(click());
    }


}
