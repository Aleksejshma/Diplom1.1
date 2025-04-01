package ru.iteco.fmhandroid.ui.pageElement;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AboutPageElement {
    public static ViewInteraction privacyPolicyView = onView(
            allOf(withId(R.id.about_privacy_policy_label_text_view), withText("Privacy Policy:"),
                    isDisplayed()));

    public static int privacyPolicyViewId = R.id.about_privacy_policy_label_text_view;

    public static ViewInteraction termsOfUseView = onView(
            allOf(withId(R.id.about_terms_of_use_label_text_view), withText("Terms of use:"),
                    isDisplayed()));

    public static ViewInteraction iTecoView = onView(
            allOf(withId(R.id.about_company_info_label_text_view), withText("© I-Teco, 2022"),
                    isDisplayed()));

    public static ViewInteraction versionView = onView(
            allOf(withId(R.id.about_version_title_text_view), withText("Version:"),
                    isDisplayed()));

}
