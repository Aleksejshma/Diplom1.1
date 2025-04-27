package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.RootMatchers.isPlatformPopup;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.utils.Utils.waitForElement;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.pageElement.NewsPageElement;

public class NewsPageSteps {

    private static final NewsPageElement newsPageElement = new NewsPageElement();

    @Step("Проверка наличия кнопки сортировки")
    public static void checkSortingButtonIsPresent() {
        onView(isRoot()).perform(waitForElement(newsPageElement.getSortingButtonId(), 10000));
        newsPageElement.getSortingButton().check(matches(isDisplayed()));
    }

    @Step("Проверка наличия кнопки фильтрации")
    public static void checkFilterButtonIsPresent() {
        onView(isRoot()).perform(waitForElement(newsPageElement.getFilterButtonId(), 10000));
        newsPageElement.getFilterButton().check(matches(isDisplayed()));
    }

    @Step("Проверка наличия кнопки редактирования")
    public static void checkEditButtonIsPresent() {
        onView(isRoot()).perform(waitForElement(newsPageElement.getEditButtonId(), 10000));
        newsPageElement.getEditButton().check(matches(isDisplayed()));
    }

    @Step("Нажатие кнопки редактирования")
    public static void pushEditButton() {
        onView(isRoot()).perform(waitForElement(newsPageElement.getNewsListSwipeRefreshId(), 5000));
        newsPageElement.getEditButton().perform(click());
    }

    @Step("Нажатие кнопки добавления новости")
    public static void pushAddNewsButton() {
        onView(isRoot()).perform(waitForElement(newsPageElement.getActionBarId(), 5000));
        newsPageElement.getAddNewsButton().perform(click());
    }

    @Step("Выбор категории новости")
    public static void pushChooseNewsCategory() {
        onView(isRoot()).perform(waitForElement(newsPageElement.getNavigationFrameId(), 5000));
        onView(isRoot()).perform(waitForElement(newsPageElement.getCategoryNewsId(), 5000));
        newsPageElement.getCategoryNews().perform(click());
    }

    @Step("Выбор категории новости: {category}")
    public static void chooseNewsCategory(String category){
        onView(withText(category)).inRoot(isPlatformPopup()).perform(click());
    }

    @Step("Заполнение заголовка новости: {title}")
    public static void fillTitleNews(String title){
        onView(isRoot()).perform(waitForElement(newsPageElement.getNewsTextInputId(), 5000));
        newsPageElement.getTitleNewsFieldInput().
                perform(click(), replaceText(title), closeSoftKeyboard());
    }

    @Step("Выбор текущей даты")
    public static void selectCurrentDate() {
        onView(isRoot()).perform(waitForElement(newsPageElement.getCreateDateTextInputId(), 3000));
        newsPageElement.getCreateDateInput().perform(click());
        newsPageElement.getOkButton().perform(click());
    }

    @Step("Выбор текущего времени")
    public static void selectCurrentTime() {
        onView(isRoot()).perform(waitForElement(newsPageElement.getPublishTimeTextId(), 3000));
        newsPageElement.getPublishTimeInput().perform(click());
        newsPageElement.getOkButton().perform(click());
    }

    @Step("Заполнение описания: {text}")
    public static void fillDescription(String text) {
        onView(isRoot()).perform(waitForElement(newsPageElement.getDescriptionTextInputId(), 3000));
        newsPageElement.getDescriptionEditText().perform(click(), typeText(text), closeSoftKeyboard());
    }

    @Step("Нажатие кнопки сохранения")
    public static void clickSaveButton() {
        onView(isRoot()).perform(waitForElement(R.id.save_button, 10000));
        newsPageElement.getSaveButton().perform(scrollTo(), click());
    }

    @Step("Проверка видимости заголовка 'Control panel'")
    public static void checkControlPanelTitleIsVisible() {
        onView(isRoot()).perform(waitForElement(R.id.news_list_recycler_view, 5000));
        newsPageElement.getControlPanelTitle().check(matches(withText("Control panel")));
    }

    @Step("Проверка видимости заголовка новости: {expectedTitle}")
    public static void verifyNewsTitleIsVisible(String expectedTitle) {
        onView(isRoot()).perform(waitForElement(R.id.news_item_material_card_view, 5000));
        android.os.SystemClock.sleep(3000);
        newsPageElement.newsTitleTextView(expectedTitle).check(matches(withText(expectedTitle)));
    }

    @Step("Клик по первой новости в списке")
    public static void clickFirstNewsItem() {
        onView(isRoot()).perform(waitForElement(R.id.delete_news_item_image_view, 3000));
        onView(isRoot()).perform(waitForElement(newsPageElement.getNewsRecyclerViewId(), 3000));
        newsPageElement.getNewsRecyclerView().perform(actionOnItemAtPosition(0, click()));
    }

    @Step("Проверка описания новости: {expectedDescription}")
    public static void verifyNewsDescription(String expectedDescription) {
        onView(isRoot()).perform(waitForElement(R.id.news_item_publication_text_view, 5000));
        newsPageElement.newsDescriptionTextView.check(matches(withText(expectedDescription)));
    }

    @Step("Удаление новости: {news}")
    public static void deleteNews(String news){
        onView(isRoot()).perform(waitForElement(R.id.delete_news_item_image_view, 3000));
        newsPageElement.deleteNews(news).perform(click());
    }

    @Step("Подтверждение удаления (нажатие OK)")
    public static void pushOk() {
        onView(isRoot()).perform(waitForElement(android.R.id.button1, 10000));
        newsPageElement.getOkButtonInDeleteOperation().perform(scrollTo(), click());
    }

    @Step("Проверка отсутствия текста: {text}")
    public static void checkTextNotExist(String text){
        android.os.SystemClock.sleep(2000);
        onView(withText(text)).check(doesNotExist());
    }

    @Step("Нажатие кнопки редактирования для новости: {text}")
    public static void pushEditButton(String text) {
        newsPageElement.editNews(text).perform(click());
    }
}