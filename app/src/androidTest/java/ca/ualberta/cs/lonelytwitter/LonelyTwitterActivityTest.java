package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;

import junit.framework.TestCase;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by wz on 14/09/15.
 */

@RunWith(AndroidJUnit4.class)
public class LonelyTwitterActivityTest{

    @Rule
    public ActivityTestRule<LonelyTwitterActivity> activityRule =
            new ActivityTestRule<LonelyTwitterActivity>(LonelyTwitterActivity.class);

    @Test
    public void addText(){
        onView(withId(R.id.body)).perform(typeText("This is a test example"));
        onView(withId(R.id.save)).perform(click());
    }
}
