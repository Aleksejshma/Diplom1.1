package ru.iteco.fmhandroid.ui.pageElement;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class MainPageElement {

    public static ViewInteraction burgerMenu = onView(allOf(withId(R.id.main_menu_image_button), withContentDescription("Main menu"),isDisplayed()));
    public static ViewInteraction aboutBurgerMenu = onView(allOf(withId(android.R.id.title), withText("About"), isDisplayed()));
    public static ViewInteraction newsBurgerMenu = onView(allOf(withId(android.R.id.title), withText("News"), isDisplayed()));

    public static ViewInteraction mainLogoView = onView(withId(R.id.trademark_image_view));
    public static ViewInteraction newsLogoView = onView(allOf(withText("News"), isDisplayed()));
    public static ViewInteraction ourMissionLogoView = onView(allOf(withId(R.id.our_mission_image_button),
            withContentDescription("Our Mission")));
    public static ViewInteraction logOutButton = onView(
            allOf(withId(android.R.id.title), withText("Log out"), isDisplayed()));
    public static ViewInteraction authorizationBlock = onView(allOf(withId(R.id.authorization_image_button), isDisplayed()));
    public static int mainMenuImageButtonId = R.id.main_menu_image_button;
    public static int logOutButtonId = R.id.authorization_logout_menu_item;

}
