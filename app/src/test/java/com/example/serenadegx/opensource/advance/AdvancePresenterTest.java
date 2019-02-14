package com.example.serenadegx.opensource.advance;

import com.example.serenadegx.opensource.utils.TestUtils;
import com.example.serenadegx.opensource.login2.Login2Result;
import com.example.serenadegx.opensource.login2.Login2Service;
import com.example.serenadegx.opensource.login2.LoginParams;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import retrofit2.Retrofit;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AdvancePresenterTest {
    private AdvancePresenter mPresenter;
    @Mock
    private AdvanceContract.View mView;
    @Mock
    private Login2Service login2Service;
    /**
     * {@link ArgumentCaptor}是一个强大的Mockito API，用于捕获参数值并使用它们
     * 对它们执行进一步的操作或断言。
     */
    @Captor
    private ArgumentCaptor<Login2Result> mCallback;
    private TestUtils testUtils;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
//        提前打桩(默认视图一直是活动的)
        when(mView.isActive()).thenReturn(true);
        testUtils = new TestUtils("{\"code\":\"0\"}");
        Retrofit retrofit = testUtils.create();
//        获取被测试类的引用
        mPresenter = new AdvancePresenter(retrofit);
        mPresenter.takeView(mView);
    }

    @Test
    public void login() {
        Login2Result login2Result = new Login2Result("0", "登陆成功");
//        when(login2Service.login(any(LoginParams.class),anyInt())).thenReturn()



//        当要求Presenter登录时
        mPresenter.login("13356892296", "a123456");

        verify(login2Service).login(new LoginParams("13356892296", "a123456"), 1).registerObserver(mCallback.capture());

        verify(mView).loginSuccess(mCallback.getValue());

        login2Service.login(new LoginParams("13356892296", "a123456"), 1);

//        然后执行网络请求，并更新视图
//        verify(mRetrofit).create(Login2Service.class)
//                .login(any(LoginParams.class))
//                .enqueue(mCallback.capture());
//        验证 login2Service.login(...)是否被调用
//        verify(login2Service).login(new LoginParams("13356892296", "a123456"));
//        verify(mView).loginSuccess(mCallback.capture());

//        模拟回调
//        mCallback.getValue().onResponse(mCall, mResponse);

//        verify(mView).loginSuccess(login2ResultTest);
    }
}