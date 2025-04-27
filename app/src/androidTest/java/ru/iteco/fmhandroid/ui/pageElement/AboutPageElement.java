package ru.iteco.fmhandroid.ui.pageElement;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AboutPageElement {
    private final ViewInteraction privacyPolicyView = onView(
            allOf(withId(R.id.about_privacy_policy_label_text_view), withText("Privacy Policy:"),
                    isDisplayed()));

    private final int privacyPolicyViewId = R.id.about_privacy_policy_label_text_view;

    private final ViewInteraction termsOfUseView = onView(
            allOf(withId(R.id.about_terms_of_use_label_text_view), withText("Terms of use:"),
                    isDisplayed()));

    private final ViewInteraction iTecoView = onView(
            allOf(withId(R.id.about_company_info_label_text_view), withText("© I-Teco, 2022"),
                    isDisplayed()));

    private final ViewInteraction versionView = onView(
            allOf(withId(R.id.about_version_title_text_view), withText("Version:"),
                    isDisplayed()));

    public final ViewInteraction getVersionOfAppView() {
        return versionView;
    }

    public ViewInteraction getiTecoLogoView() {
        return iTecoView;
    }

    public ViewInteraction getTermsOfUseView() {
        return termsOfUseView;
    }

    public int getPrivacyPolicyViewId() {
        return privacyPolicyViewId;
    }

    public ViewInteraction getPrivacyPolicyView() {
        return privacyPolicyView;
    }
}
