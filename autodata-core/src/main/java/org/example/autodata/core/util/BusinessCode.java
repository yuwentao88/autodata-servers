package org.example.autodata.core.util;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * author:north
 * Date:2020/7/31 ：17:22
 */
@Data
public class BusinessCode {

    @ApiModelProperty(name = "返回编码",value="返回编码200-成功 其他-失败")
    private Integer code;
    @ApiModelProperty(name = "错误信息",value="错误信息")
    private String msg;
    /**
     * 成功
     */
    public static final BusinessCode SUCCESS = new BusinessCode(200, BaseContants.MsgKey.CORE_HANDLE_SUCCESS);
    /**
     * 失败
     */
    public static final BusinessCode FAILD = new BusinessCode(500, BaseContants.MsgKey.CORE_SYSTEM_EXCEPTION);
    public static final BusinessCode PARAM_ILLEGAL = new BusinessCode(400, BaseContants.MsgKey.CORE_PARAM_ILLEGAL);
    public static final BusinessCode PARAM_EMPTY = new BusinessCode(401, BaseContants.MsgKey.CORE_PARAM_EMPTY);
    public static final BusinessCode API_AUTH_FAIL = new BusinessCode(402, BaseContants.MsgKey.CORE_API_AUTH_FAIL);
    public static final BusinessCode ENTITY_CONVERT_EXCEPTION = new BusinessCode(403, BaseContants.MsgKey.CORE_ENTITY_CONVERT_EXCEPTION);
    public static final BusinessCode TOKEN_EXCEPTION = new BusinessCode(501, BaseContants.MsgKey.CORE_TOKEN_EXCEPTION);





    public BusinessCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BusinessCode(BusinessCode businessCode) {
        this.code = businessCode.getCode();
        this.msg = businessCode.getMsg();
    }
}
