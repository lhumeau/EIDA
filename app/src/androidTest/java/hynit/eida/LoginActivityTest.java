package hynit.eida;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityTestRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void loginActivityTest() {
        ViewInteraction appCompatTextView = onView(
                allOf(withId(R.id.btn_registrar), withText("Registrar cuenta "),
                        withParent(allOf(withId(R.id.email_login_form),
                                withParent(withId(R.id.login_form))))));
        appCompatTextView.perform(scrollTo(), click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.NombreEt),
                        withParent(withId(R.id.LinearLID)),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("a"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.NombreEt), withText("a"),
                        withParent(withId(R.id.LinearLID)),
                        isDisplayed()));
        appCompatEditText2.perform(click());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.NombreEt), withText("a"),
                        withParent(withId(R.id.LinearLID)),
                        isDisplayed()));
        appCompatEditText3.perform(replaceText("aasd"), closeSoftKeyboard());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.NombreEt), withText("aasd"),
                        withParent(withId(R.id.LinearLID)),
                        isDisplayed()));
        appCompatEditText4.perform(click());

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.ApellidoEt),
                        withParent(withId(R.id.LinearLID)),
                        isDisplayed()));
        appCompatEditText5.perform(replaceText("as"), closeSoftKeyboard());

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.ApellidoEt), withText("as"),
                        withParent(withId(R.id.LinearLID)),
                        isDisplayed()));
        appCompatEditText6.perform(click());

        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.ApellidoEt), withText("as"),
                        withParent(withId(R.id.LinearLID)),
                        isDisplayed()));
        appCompatEditText7.perform(replaceText("asd"), closeSoftKeyboard());

        ViewInteraction appCompatEditText8 = onView(
                allOf(withId(R.id.CorreoEt),
                        withParent(withId(R.id.LinearLID)),
                        isDisplayed()));
        appCompatEditText8.perform(click());

        ViewInteraction appCompatEditText9 = onView(
                allOf(withId(R.id.CorreoEt),
                        withParent(withId(R.id.LinearLID)),
                        isDisplayed()));
        ViewInteraction asd = appCompatEditText9.perform(replaceText("asd"), closeSoftKeyboard());



        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.btn_registrarLoginActivirty), withText("Registrar"),
                        withParent(withId(R.id.LinearLID)),
                        isDisplayed()));
        appCompatButton.perform(click());

    }

}
