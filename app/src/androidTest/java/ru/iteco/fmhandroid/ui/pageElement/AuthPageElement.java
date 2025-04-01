package ru.iteco.fmhandroid.ui.pageElement;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AuthPageElement {
    public static ViewInteraction inputLoginField = onView(allOf(withId(R.id.login_edit_text)));
    public static ViewInteraction inputPasswordField = onView(allOf(withId(R.id.password_edit_text)));
    public static ViewInteraction enterButton = onView(withId(R.id.enter_button));
    public static ViewInteraction toastMessageSomethingWrong = onView(withText("Something went wrong. Try again later."));
    public static ViewInteraction toastMessageEmptyLoginAndPassword = onView(withText("Login and password cannot be empty"));
    public static ViewInteraction authorizationTextView = onView(allOf(withText("Authorization"), isDisplayed()));
    public static int enterButtonId = R.id.enter_button;
    public static int loginTextInputLayoutId = R.id.login_text_input_layout;
    public static int authorizationTextId = R.id.authorization_text_input_layout;

}
