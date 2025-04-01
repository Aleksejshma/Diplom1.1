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
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withChild;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.pageElement.NewsPageElement.deleteNewsTitleTextView;
import static ru.iteco.fmhandroid.ui.utils.Utils.waitForElement;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.pageElement.NewsPageElement;

public class NewsPageSteps {

    @Step("Проверка наличия кнопки сортировки")
    public static void checkSortingButtonIsPresent() {
        onView(isRoot()).perform(waitForElement(NewsPageElement.sortingButtonId, 10000));
        NewsPageElement.sortingButton.check(matches(isDisplayed()));
    }

    @Step("Проверка наличия кнопки фильтрации")
    public static void checkFilterButtonIsPresent() {
        onView(isRoot()).perform(waitForElement(NewsPageElement.filterButtonId, 10000));
        NewsPageElement.filterButton.check(matches(isDisplayed()));
    }

    @Step("Проверка наличия кнопки редактирования")
    public static void checkEditButtonIsPresent() {
        onView(isRoot()).perform(waitForElement(NewsPageElement.editButtonId, 10000));
        NewsPageElement.editButton.check(matches(isDisplayed()));
    }

    @Step("Нажатие кнопки редактирования")
    public static void pushEditButton() {
        onView(isRoot()).perform(waitForElement(NewsPageElement.newsListSwipeRefreshId, 5000));
        NewsPageElement.editButton.perform(click());
    }

    @Step("Нажатие кнопки добавления новости")
    public static void pushAddNewsButton() {
        onView(isRoot()).perform(waitForElement(NewsPageElement.actionBarRootId, 5000));
        NewsPageElement.addNewsButton.perform(click());
    }

    @Step("Выбор категории новости")
    public static void pushChooseNewsCategory() {
        onView(isRoot()).perform(waitForElement(NewsPageElement.navHostFragmentId, 5000));
        onView(isRoot()).perform(waitForElement(NewsPageElement.categoryNewsId, 5000));
        NewsPageElement.categoryNews.perform(click());
    }

    @Step("Выбор категории новости: {category}")
    public static void chooseNewsCategory(String category){
        onView(withText(category)).inRoot(isPlatformPopup()).perform(click());
    }

    @Step("Заполнение заголовка новости: {title}")
    public static void fillTitleNews(String title){
        onView(isRoot()).perform(waitForElement(NewsPageElement.newsItemTitleTextInputLayoutId, 5000));
        NewsPageElement.fieldInputTitleNews.
                perform(click(), replaceText(title), closeSoftKeyboard());
    }

    @Step("Выбор текущей даты")
    public static void selectCurrentDate() {
        onView(isRoot()).perform(waitForElement(NewsPageElement.createDateTextInputLayoutId, 3000));
        NewsPageElement.createDateInputLayout.perform(click());
        NewsPageElement.okButton.perform(click());
    }

    @Step("Выбор текущего времени")
    public static void selectCurrentTime() {
        onView(isRoot()).perform(waitForElement(NewsPageElement.publishTimeTextInputLayoutId, 3000));
        NewsPageElement.publishTimeInputLayout.perform(click());
        NewsPageElement.okButton.perform(click());
    }

    @Step("Заполнение описания: {text}")
    public static void fillDescription(String text) {
        onView(isRoot()).perform(waitForElement(NewsPageElement.descriptionTextInputLayoutId, 3000));
        NewsPageElement.descriptionEditText.perform(click(), typeText(text), closeSoftKeyboard());
    }

    @Step("Нажатие кнопки сохранения")
    public static void clickSaveButton() {
        onView(isRoot()).perform(waitForElement(R.id.save_button, 10000));
        NewsPageElement.saveButton.perform(scrollTo(), click());
    }

    @Step("Проверка видимости заголовка 'Control panel'")
    public static void checkControlPanelTitleIsVisible() {
        onView(isRoot()).perform(waitForElement(R.id.news_list_recycler_view, 5000));
        NewsPageElement.controlPanelTitle.check(matches(withText("Control panel")));
    }

    @Step("Проверка видимости заголовка новости: {expectedTitle}")
    public static void verifyNewsTitleIsVisible(String expectedTitle) {
        onView(isRoot()).perform(waitForElement(R.id.news_item_material_card_view, 5000));
        android.os.SystemClock.sleep(3000);
        NewsPageElement.newsTitleTextView(expectedTitle).check(matches(withText(expectedTitle)));
    }

    @Step("Клик по первой новости в списке")
    public static void clickFirstNewsItem() {
        onView(isRoot()).perform(waitForElement(R.id.delete_news_item_image_view, 3000));
        onView(isRoot()).perform(waitForElement(NewsPageElement.newsRecyclerViewId, 3000));
        NewsPageElement.newsRecyclerView.perform(actionOnItemAtPosition(0, click()));
    }

    @Step("Проверка описания новости: {expectedDescription}")
    public static void verifyNewsDescription(String expectedDescription) {
        onView(isRoot()).perform(waitForElement(R.id.news_item_publication_text_view, 5000));
        NewsPageElement.newsDescriptionTextView.check(matches(withText(expectedDescription)));
    }

    @Step("Удаление новости: {news}")
    public static void deleteNews(String news){
        onView(isRoot()).perform(waitForElement(R.id.delete_news_item_image_view, 3000));
        NewsPageElement.deleteNews(news).perform(click());
    }

    @Step("Подтверждение удаления (нажатие OK)")
    public static void pushOk() {
        onView(isRoot()).perform(waitForElement(android.R.id.button1, 10000));
        NewsPageElement.okButtonDeleteOperation.perform(scrollTo(), click());
    }

    @Step("Проверка отсутствия текста: {text}")
    public static void checkTextNotExist(String text){
        android.os.SystemClock.sleep(2000);
        onView(withText(text)).check(doesNotExist());
    }

    @Step("Нажатие кнопки редактирования для новости: {text}")
    public static void pushEditButton(String text) {
        NewsPageElement.editNews(text).perform(click());
    }
}