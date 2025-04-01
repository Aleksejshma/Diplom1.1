package ru.iteco.fmhandroid.ui.pageElement;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withChild;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.widget.LinearLayout;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.core.IsInstanceOf;

import ru.iteco.fmhandroid.R;

public class NewsPageElement {
    public static ViewInteraction sortingButton = onView(
            allOf(withId(R.id.sort_news_material_button),
                    isDisplayed()));

    public static int sortingButtonId = R.id.sort_news_material_button;

    public static ViewInteraction filterButton = onView(
            allOf(withId(R.id.filter_news_material_button),
                    isDisplayed()));

    public static int filterButtonId = R.id.filter_news_material_button;

    public static ViewInteraction editButton = onView(
            allOf(withId(R.id.edit_news_material_button),
                    isDisplayed()));
    public static ViewInteraction addNewsButton = onView(withId(R.id.add_news_image_view));
    public static int editButtonId = R.id.edit_news_material_button;
    public static int newsListSwipeRefreshId = R.id.news_list_swipe_refresh;
    public static int actionBarRootId = R.id.action_bar_root;
    public static int navHostFragmentId = R.id.nav_host_fragment;
    public static ViewInteraction categoryNews = onView(withId(R.id.news_item_category_text_input_layout));

    public static ViewInteraction fieldInputTitleNews = onView(withId(R.id.news_item_title_text_input_edit_text));
    public static int categoryNewsId = R.id.news_item_category_text_input_layout;
    public static int newsItemTitleTextInputLayoutId = R.id.news_item_title_text_input_layout;

    public static ViewInteraction createDateInputLayout = onView(withId(R.id.news_item_create_date_text_input_layout));
    public static int createDateTextInputLayoutId = R.id.news_item_create_date_text_input_layout;

    public static ViewInteraction okButton = onView(allOf(withText("OK"), isDescendantOfA(withId(android.R.id.content))));

    public static ViewInteraction publishTimeInputLayout = onView(withId(R.id.news_item_publish_time_text_input_layout));
    public static int publishTimeTextInputLayoutId = R.id.news_item_publish_time_text_input_layout;

    public static ViewInteraction descriptionInputLayout = onView(withId(R.id.news_item_description_text_input_layout));
    public static int descriptionTextInputLayoutId = R.id.news_item_description_text_input_layout;

    public static ViewInteraction descriptionEditText = onView(withId(R.id.news_item_description_text_input_edit_text));
    public static int descriptionTextInputEditTextId = R.id.news_item_description_text_input_edit_text;

    public static ViewInteraction saveButton = onView(
            allOf(
                    withId(R.id.save_button),
                    withText("Save"),
                    withContentDescription("Save")
            )
    );

    // Заголовок "Control panel"
    public static ViewInteraction controlPanelTitle = onView(
            allOf(
                    withText("Control panel"),
                    withParent(withParent(IsInstanceOf.instanceOf(LinearLayout.class))),
                    isDisplayed()
            )
    );

    public static ViewInteraction newsTitleTextView(String news) {
        return onView(
                allOf(
                        withId(R.id.news_item_title_text_view), withText(news),
                        withParent(withParent(withId(R.id.news_item_material_card_view))),
                        isDisplayed()
                )
        );
    }

    public static ViewInteraction deleteNewsTitleTextView =
        onView(allOf(withId(R.id.delete_news_item_image_view), withContentDescription("News delete button"),
                isDisplayed()));


    public static ViewInteraction okButtonDeleteOperation = onView(
            allOf(withId(android.R.id.button1), withText("OK")));

    public static int newsTitleTextViewId = R.id.news_item_title_text_view;

    public static ViewInteraction newsRecyclerView = onView(
            allOf(withId(R.id.news_list_recycler_view))
    );
    public static int newsRecyclerViewId = R.id.news_list_recycler_view;

    // Поле с описанием новости
    public static ViewInteraction newsDescriptionTextView = onView(
            allOf(
                    withId(R.id.news_item_description_text_view),
                    isDisplayed()
            )
    );
    public static int newsDescriptionTextViewId = R.id.news_item_description_text_view;

    public static ViewInteraction deleteNews(String title){
        return onView(allOf(withId(R.id.delete_news_item_image_view),
                withParent(withParent(allOf(withId(R.id.news_item_material_card_view),
                        withChild(withChild(withText(title))))))));

    }

    public static ViewInteraction editNews(String title){
        return onView(allOf(withId(R.id.edit_news_item_image_view),
                withParent(withParent(allOf(withId(R.id.news_item_material_card_view),
                        withChild(withChild(withText(title))))))));

    }




}
