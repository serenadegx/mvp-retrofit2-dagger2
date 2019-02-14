package com.example.serenadegx.opensource;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.espresso.web.assertion.WebViewAssertions;
import android.support.test.espresso.web.webdriver.DriverAtoms;
import android.support.test.espresso.web.webdriver.Locator;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.serenadegx.opensource.advance.AdvanceActivity;
import com.example.serenadegx.opensource.utils.EspressoIdlingResource;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.web.sugar.Web.onWebView;
import static android.support.test.espresso.web.webdriver.DriverAtoms.findElement;
import static android.support.test.espresso.web.webdriver.DriverAtoms.webClick;

/**
 * 测试登录屏幕
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginActivityTest {
    /**
     * {@link ActivityTestRule}是一个JUnit {@link Rule @Rule}，用于在测试中启动您的Activity。
     * 规则是为每个测试方法执行的拦截器，是重要的构建Junit测试块。
     */
    @Rule
    public ActivityTestRule activityTestRule = new ActivityTestRule(AdvanceActivity.class);

    /**
     * 为这次测试准备好你的测试夹具。在这种情况下，我们用Espresso注册一个空闲资源，空闲资源资源是一个很好的方式
     * 来告诉Espresso，你的应用程序在一个空闲状态。这有助于Espresso同步您的测试操作，从而进行测试更可靠。
     * 主要用于网络请求，图片视频加载等耗时操作
     */
    @Before
    public void registerIdlingResource() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getIdlingResource());
    }

    /**
     * 注销空闲资源的注册，以便它可以被垃圾收集，并且不会内存泄漏。
     */
    @After
    public void unregisterIdlingResource() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getIdlingResource());
    }

    @Test
    public void test() {
        //输入手机号
        onView(withId(R.id.et_phone)).perform(typeText("13356892296"),
                closeSoftKeyboard()).check(matches(isEnabled()));
        //输入密码
        onView(withId(R.id.et_pwd)).perform(typeText("a123456"),
                closeSoftKeyboard()).check(matches(isEnabled()));
        //点击登录
        onView(withId(R.id.bt_sure)).perform(click());
        //验证是否弹出网络出错toast
//        onView(ViewMatchers.withText("网络出错!"))
//                .inRoot(withDecorView(not(activityTestRule.getActivity().getWindow().getDecorView())))
//                .check(matches(isDisplayed()));
        //滑动到一个位置
//        onView(withId(R.id.rv)).perform(RecyclerViewActions.scrollToPosition(26));
        onView(withId(R.id.rv)).perform(RecyclerViewActions.scrollToPosition(0));
        //找到"13356892290"这个item，执行条目点击事件
        onView(withText("13356892290")).check(matches(isDisplayed())).perform(click());
        //进入百度网页，搜索关键字：android
        onWebView().withElement(findElement(Locator.NAME, "word"))
                //往输入框中输入字符串"android"
                .perform(DriverAtoms.webKeys("android"))
                //通过id为"index-bn"找到"百度一下"按钮
                .withElement(DriverAtoms.findElement(Locator.ID, "index-bn"))
                //执行点击事件
                .perform(webClick())
                //通过id为"results"找到结果div
                .withElement(DriverAtoms.findElement(Locator.ID, "results"))
                //检查div中是否包含字符串"android"
                .check(WebViewAssertions.webMatches(DriverAtoms.getText(), Matchers.containsString("android")));
        pressBack();
    }

    @Test
    public void testJump() {

    }
}
