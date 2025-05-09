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
import ru.iteco.fmhandroid.ui.steps.AboutPageSteps;
import ru.iteco.fmhandroid.ui.steps.MainPageSteps;
import ru.iteco.fmhandroid.ui.steps.OurMissionPageSteps;
import ru.iteco.fmhandroid.ui.utils.Utils;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
@Epic("Основной функционал приложения")
public class MainTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Test
    @Description("Тест проверяет переход в раздел 'Наша миссия' и отображение основных элементов")
    public void mainTest() {
        Utils.checkMainPage();
        MainPageSteps.pushOurMissionLabel();
        OurMissionPageSteps.checkLabelOurMission();
    }

    @Test
    @Description("Тест проверяет раздел 'О приложении', включая отображение политики конфиденциальности, условий использования и информации о версии")
    public void appActivityTest() {
        Utils.checkMainPage();
        MainPageSteps.pushBurger();
        MainPageSteps.pushAboutBurger();
        AboutPageSteps.checkPrivacyPolicy();
        AboutPageSteps.checkTermsOfUse();
        AboutPageSteps.checkIteco();
        AboutPageSteps.checkVersion();
    }
}