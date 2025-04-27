package ru.iteco.fmhandroid.ui;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import ru.iteco.fmhandroid.ui.steps.AboutPageSteps;
import ru.iteco.fmhandroid.ui.steps.MainPageSteps;
import ru.iteco.fmhandroid.ui.steps.NewsPageSteps;
import ru.iteco.fmhandroid.ui.utils.Utils;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
@Epic("Тестирование функционала новостей")
public class NewsTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    public static final String NEWS_CATEGORY = "Зарплата";
    public static final String NEWS_TITLE = "Title test";
    public static final String NEWS_DESCRIPTION = "Testy";
    public static final String NEWS_TITLE_DELETE = "Delete test";
    public static final String NEWS_TITLE_UPDATE = "Update title test";

    @Test
    @Description("Тест проверяет переход на страницу новостей и отображение основных элементов управления")
    public void goToNewsPageTest() {
        Utils.checkMainPage();
        MainPageSteps.pushBurger();
        MainPageSteps.pushNewsBurger();
        NewsPageSteps.checkSortingButtonIsPresent();
        NewsPageSteps.checkFilterButtonIsPresent();
        NewsPageSteps.checkEditButtonIsPresent();
    }

    @Test
    @Description("Тест проверяет создание новой новости с валидными данными")
    public void createNewsTest() throws InterruptedException {
        Utils.checkMainPage();
        MainPageSteps.pushBurger();
        MainPageSteps.pushNewsBurger();
        NewsPageSteps.pushEditButton();
        NewsPageSteps.pushAddNewsButton();
        NewsPageSteps.pushChooseNewsCategory();
        NewsPageSteps.chooseNewsCategory(NEWS_CATEGORY);
        NewsPageSteps.fillTitleNews(NEWS_TITLE);
        NewsPageSteps.selectCurrentDate();
        NewsPageSteps.selectCurrentTime();
        NewsPageSteps.fillDescription(NEWS_DESCRIPTION);
        NewsPageSteps.clickSaveButton();
        NewsPageSteps.checkControlPanelTitleIsVisible();
        NewsPageSteps.clickFirstNewsItem();
        NewsPageSteps.verifyNewsDescription(NEWS_DESCRIPTION);;
        NewsPageSteps.verifyNewsTitleIsVisible(NEWS_TITLE);
    }

    @Test
    @Description("Тест проверяет удаление созданной новости")
    public void deleteNewsTest() {
        Utils.checkMainPage();
        MainPageSteps.pushBurger();
        MainPageSteps.pushNewsBurger();
        NewsPageSteps.pushEditButton();
        NewsPageSteps.pushAddNewsButton();
        NewsPageSteps.pushChooseNewsCategory();
        NewsPageSteps.chooseNewsCategory(NEWS_CATEGORY);
        NewsPageSteps.fillTitleNews(NEWS_TITLE_DELETE);
        NewsPageSteps.selectCurrentDate();
        NewsPageSteps.selectCurrentTime();
        NewsPageSteps.fillDescription(NEWS_DESCRIPTION);
        NewsPageSteps.clickSaveButton();
        NewsPageSteps.checkControlPanelTitleIsVisible();
        NewsPageSteps.clickFirstNewsItem();
        NewsPageSteps.verifyNewsTitleIsVisible(NEWS_TITLE_DELETE);
        NewsPageSteps.verifyNewsDescription(NEWS_DESCRIPTION);
        NewsPageSteps.deleteNews(NEWS_TITLE_DELETE);
        NewsPageSteps.pushOk();
        NewsPageSteps.checkTextNotExist(NEWS_TITLE_DELETE);
    }

    @Test
    @Description("Тест проверяет переход на страницу 'О приложении' из раздела новостей")
    public void goToAboutPageTest() {
        Utils.checkMainPage();
        MainPageSteps.pushBurger();
        MainPageSteps.pushNewsBurger();
        MainPageSteps.pushBurger();
        MainPageSteps.pushAboutBurger();
        AboutPageSteps.checkPrivacyPolicy();
        AboutPageSteps.checkTermsOfUse();
        AboutPageSteps.checkIteco();
        AboutPageSteps.checkVersion();
    }

    @Test
    @Description("Тест проверяет редактирование существующей новости")
    public void editNewsTest() {
        Utils.checkMainPage();
        MainPageSteps.pushBurger();
        MainPageSteps.pushNewsBurger();
        NewsPageSteps.pushEditButton();
        NewsPageSteps.pushAddNewsButton();
        NewsPageSteps.pushChooseNewsCategory();
        NewsPageSteps.chooseNewsCategory(NEWS_CATEGORY);
        NewsPageSteps.fillTitleNews(NEWS_TITLE + 1);
        NewsPageSteps.selectCurrentDate();
        NewsPageSteps.selectCurrentTime();
        NewsPageSteps.fillDescription(NEWS_DESCRIPTION);
        NewsPageSteps.clickSaveButton();
        NewsPageSteps.checkControlPanelTitleIsVisible();
        NewsPageSteps.clickFirstNewsItem();
        NewsPageSteps.verifyNewsTitleIsVisible(NEWS_TITLE + 1);
        NewsPageSteps.verifyNewsDescription(NEWS_DESCRIPTION);
        NewsPageSteps.pushEditButton(NEWS_TITLE);
        NewsPageSteps.fillTitleNews(NEWS_TITLE_UPDATE);
        NewsPageSteps.clickSaveButton();
        NewsPageSteps.checkControlPanelTitleIsVisible();
        NewsPageSteps.clickFirstNewsItem();
        NewsPageSteps.verifyNewsTitleIsVisible(NEWS_TITLE_UPDATE);
    }
}