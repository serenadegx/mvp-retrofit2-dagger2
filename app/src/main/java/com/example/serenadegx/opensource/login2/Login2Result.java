package com.example.serenadegx.opensource.login2;

public class Login2Result {
    private String code;
    private String message;
    private DataBean data;

    public Login2Result(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public DataBean getData() {
        return data;
    }

    public static class DataBean {
        private String access_token;
        private String firstLogin;

        public void setAccess_token(String access_token) {
            this.access_token = access_token;
        }

        public void setFirstLogin(String firstLogin) {
            this.firstLogin = firstLogin;
        }

        public String getAccess_token() {

            return access_token;
        }

        public String getFirstLogin() {
            return firstLogin;
        }
    }
}
