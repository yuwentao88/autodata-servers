package org.example.autodata.core.util;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

/**
 * author:north
 * Date:2020/7/31 ：17:18
 */
@Data
public class Response<T> implements Serializable {
    private final static String PREFIX_I18N = "i18n_";
    /**
     * 响应码
     */
    @ApiModelProperty(name = "返回编码",value="返回编码200-成功 其他-失败")
    private Integer code;

    /**
     * 响应消息
     */
    @ApiModelProperty(name = "错误信息",value="错误信息")
    private String msg;



    /**
     * 响应数据
     */
    private transient T data;


    public Response() {
    }

    public Response(Integer code, String msg, T data) {
        this.code = code;
        this.msg =  msg;
        this.data = data;
    }

    public static <T> Response success(BusinessCode respCode, String msg, T data) {
        Response response = new Response(respCode.getCode(), msg, data);
        return response;
    }
    public static <T> Response fail(BusinessCode respCode, String msg, T data) {
        Response response = new Response(respCode.getCode(), msg, data);
        return response;
    }

    public static <T> Response init(Integer code, String msg, T data) {
        Response response = new Response(code, msg, data);
        return response;
    }

    public static Response success() {
        return success(BusinessCode.SUCCESS, "成功", null);
    }

    public static <T> Response success(T data) {
        return success(BusinessCode.SUCCESS, "成功", data);
    }

    public static <T> Response success(String msg) {
        return success(BusinessCode.SUCCESS, msg, null);
    }

    public static <T> Response success(T data, String msgKey) {
        return success(BusinessCode.SUCCESS, msgKey, data);
    }

    @ApiModelProperty(name = "成功TRUE",value="成功TRUE")
    public  boolean isSuccess(){
        return Objects.equals(BusinessCode.SUCCESS.getCode(),getCode());
    }
    @ApiModelProperty(name = "失败TRUE",value="失败TRUE")
    public  boolean isErr(){
        return !Objects.equals(BusinessCode.SUCCESS.getCode(),getCode());
    }

    public static Response fail(BusinessCode respCode, String msgKey) {
        return init(respCode.getCode(), msgKey, null);
    }
    public static <T>Response fail(T data) {
        return fail(BusinessCode.FAILD,"失败",data);
    }
    public static <T>Response fail(String msg,T data) {
        return fail(BusinessCode.FAILD,msg,data);
    }
    public static Response fail(Integer code, String msgKey) {
        return init(code, msgKey, null);
    }
    public static Response fail(String msg) {
        return init(BusinessCode.FAILD.getCode(), msg, null);
    }

    public static boolean isSuccess(Response response) {
        return BusinessCode.SUCCESS.getCode().equals(response.getCode());
    }
}
