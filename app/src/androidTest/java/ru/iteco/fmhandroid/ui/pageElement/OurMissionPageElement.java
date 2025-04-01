package ru.iteco.fmhandroid.ui.pageElement;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class OurMissionPageElement {
    public static ViewInteraction ourMissionLabelView = onView(
            allOf(withId(R.id.our_mission_title_text_view), withText("Love is all"),
                    isDisplayed()));

    public static int ourMissionLabelId = R.id.our_mission_title_text_view;
}
