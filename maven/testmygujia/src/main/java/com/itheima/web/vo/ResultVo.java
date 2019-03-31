package com.itheima.web.vo;

public class ResultVo {
    public static final int CODE_NOLOGIN=2;//未登录
    public static final int CODE_AUTH_FAIL=403;
    public static final int CODE_SUCCESS=1;
    public static final int CODE_FAILED=0;
    private int code;//标识返回的结果标识
    private Object data;//返回的数据
    private String message;//返回的描述信息

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultVo() {
    }

    public ResultVo(int code, Object data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public ResultVo(int code, String message) {
        this.code = code;
        this.message = message;
    }
    public static ResultVo success(){
        ResultVo vo = new ResultVo(CODE_SUCCESS, "");
        return vo;
    }

    public ResultVo(Object data) {
        this.code = CODE_SUCCESS;
        this.data = data;
        this.message = "";
    }
}
