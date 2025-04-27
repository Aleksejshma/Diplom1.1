package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static ru.iteco.fmhandroid.ui.utils.Utils.waitForElement;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.pageElement.OurMissionPageElement;

public class OurMissionPageSteps {

    private static final OurMissionPageElement ourMissionPageElement = new OurMissionPageElement();
    @Step("Проверка открытия страницы Наша Миссия")
    public static void checkLabelOurMission(){
        onView(isRoot()).perform(waitForElement(ourMissionPageElement.getOurMissionLabelId(), 10000));
        ourMissionPageElement.getOurMissionLabel().check(matches(isDisplayed()));
    }
}
