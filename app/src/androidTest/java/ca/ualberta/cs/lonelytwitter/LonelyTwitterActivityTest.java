package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;

import junit.framework.TestCase;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import static android.os.SystemClock.sleep;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

/**
 * Created by wz on 14/09/15.
 */

@RunWith(AndroidJUnit4.class)
public class LonelyTwitterActivityTest{

    @Rule
    public ActivityTestRule<LonelyTwitterActivity> activityRule =
            new ActivityTestRule<LonelyTwitterActivity>(LonelyTwitterActivity.class);

    @Test
    public void clickText(){
        String testString = "This is a test example";
        onView(withId(R.id.clear)).perform(click());
        onView(withId(R.id.body)).perform(typeText(testString));
        onView(withId(R.id.save)).perform(click());
        onData(anything()).inAdapterView(withId(R.id.oldTweetsList)).atPosition(0).perform(click());

        onView(withId(R.id.textView)).check(matches(withText(testString)));
        onView(withId(R.id.textView)).check(matches(isDisplayed()));
        // Manually check appearance, if necessary
        // sleep(5000);
    }

}
