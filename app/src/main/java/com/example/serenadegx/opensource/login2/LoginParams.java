package com.example.serenadegx.opensource.login2;

public class LoginParams {
    private String userLoginParam;
    private String loginType = "PASSWORD_TYPE";
    private String flowNo = "2";
    private String checkCode = "2";
    private String passWord;
    private int userType = 1;

    public LoginParams(String userLoginParam, String passWord) {
        this.userLoginParam = userLoginParam;
        this.passWord = passWord;
    }
}
