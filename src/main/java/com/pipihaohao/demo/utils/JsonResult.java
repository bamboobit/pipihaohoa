package com.pipihaohao.demo.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import java.io.Serializable;

/**
 * @Auther: xfh
 * @Date: 2019/5/10
 * @Description:
 */
public class JsonResult implements Serializable {

    public interface JsonResultView {

    }

    private static final long serialVersionUID = 5889756625380565552L;

    private static final Long SUCCESS_CODE = 0L;

    @JsonView(JsonResultView.class)
    private String msg = "";

    @JsonView(JsonResultView.class)
    private Integer code;

    @JsonView(JsonResultView.class)
    private Object data = null;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public JsonResult() {
    }

    public JsonResult(String msg) {
        this.msg = msg;
    }

    public JsonResult(String msg, Integer code) {
        this.msg = msg;
        this.code = code;
    }

    /**
     * @param msg
     * @param code
     * @param data
     */
    public JsonResult(String msg, Integer code, Object data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public static JsonResult buildSucceedResult(String msg, Integer code,Object data) {
        return new JsonResult(msg, code, data);
    }

    public static JsonResult buildErrorResult(String msg, Integer code) {
        return new JsonResult(msg, code, null);
    }

    public static JsonResult buildErrorResult(String msg, Integer code, Object data) {
        return new JsonResult(msg, code, data);
    }

    @JsonIgnore
    public boolean isSuccess() {
        return "0000".equals(code);
    }
}
