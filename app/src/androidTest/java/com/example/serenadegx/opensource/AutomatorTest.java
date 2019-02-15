package com.example.serenadegx.opensource;

import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.web.assertion.WebViewAssertions;
import android.support.test.espresso.web.webdriver.DriverAtoms;
import android.support.test.espresso.web.webdriver.Locator;
import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ScrollView;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.web.sugar.Web.onWebView;
import static android.support.test.espresso.web.webdriver.DriverAtoms.findElement;
import static android.support.test.espresso.web.webdriver.DriverAtoms.webClick;

@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class AutomatorTest {
    public static final String PACKAGE_NAME = "com.example.serenadegx.opensource";
    public static final String PACKAGE_SETTING = "com.android.settings";
    private UiDevice uiDevice;
    private Context context;

    @Before
    public void init() {
        //获取设备
        uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        //获取上下文
        context = InstrumentationRegistry.getInstrumentation().getContext();
    }

    @Test
    public void test() throws UiObjectNotFoundException {

        //启动测试app
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(PACKAGE_NAME);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
        //等待程序启动
        uiDevice.wait(Until.hasObject(By.pkg(uiDevice.getLauncherPackageName()).depth(0)), 3);
        //测试登录
        UiObject etPhone = uiDevice.findObject(new UiSelector().resourceId(PACKAGE_NAME + ":id/et_phone").className(EditText.class));
        UiObject etPwd = uiDevice.findObject(new UiSelector().resourceId(PACKAGE_NAME + ":id/et_pwd").className(EditText.class));
        etPhone.setText("13356892296");
        etPwd.setText("a123456");
        UiObject bt = uiDevice.findObject(new UiSelector().resourceId(PACKAGE_NAME + ":id/bt_sure").className(Button.class));
        bt.click();
        //测试RecyclerView
        UiScrollable rv = new UiScrollable(new UiSelector().resourceId(PACKAGE_NAME + ":id/rv").className(RecyclerView.class));
//        rv.flingForward();
//        rv.flingBackward();
        UiObject item3 = rv.getChild(new UiSelector().text("13356892292"));
        item3.click();
        //
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

    }

    @Test
    public void testSettings() throws UiObjectNotFoundException {
        uiDevice.pressHome();
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(PACKAGE_SETTING);
        // 清除以前的实例
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
        //通过id找到scrollview
        UiScrollable scrollview = new UiScrollable(new UiSelector().resourceId(PACKAGE_SETTING + ":id/dashboard_container"));

        //滑动到底部
        scrollview.flingForward();
        //通过文本找到系统
        UiObject system = scrollview.getChild(new UiSelector().text("系统"));
        system.click();
        //通过id找到scrollview
        UiScrollable scrollview1 = new UiScrollable(new UiSelector().resourceId(PACKAGE_SETTING + ":id/list"));
        //通过文本找到关于手机
        UiObject about = scrollview1.getChild(new UiSelector().text("关于手机"));
        about.click();

    }

}
