package org.example.autodata.core.util;

/**
 * author:north
 * Date:2020/7/31 ：17:22
 */
public class BaseContants {
    public static class MsgKey {
        public static final String CORE_HANDLE_SUCCESS = "成功";//操作成功
        public static final String CORE_SYSTEM_EXCEPTION = "系统异常";//系统异常
        public static final String CORE_PARAM_ILLEGAL = "参数有误";//入参有误
        public static final String CORE_PARAM_EMPTY = "参数不能为空";//入参为空
        public static final String CORE_API_AUTH_FAIL = "API认证失败";//api认证失败
        public static final String CORE_API_AUTH_PARAM_ILLEGAL = "API认证参数有误";//api认证参数有误
        public static final String CORE_API_AUTH_PARAM_OVERDUE = "API认证参数有误";//api认证参数失效
        public static final String CORE_ENTITY_CONVERT_EXCEPTION = "实体类转换异常";//实体转换异常
        public static final String CORE_TOKEN_EXCEPTION = "TONKE异常";//token异常
        public static final String CORE_TOKEN_OVERDUE = "TONKE失效";//token已失效
        public static final String CORE_TOKEN_PARAM_EMPTY = "TOKEN不能为空";//token不能为空
        public static final String CORE_TOKEN_ENTITY_EMPTY = "TONKEN主体信息为空";//token主体信息为空
    }

    /**
     * “&” 数据拼接分割符号
     */
    public static final String PARTING_TAG = "&";

    /**
     * header中token字段名
     */
    public static final String HEADER_TOKEN_FIELD = "accessToken";

    /**
     * header中handleType字段名
     */
    public static final String HEADER_HANDLE_TYPE_FIELD = "handleType";

    /**
     * header中langues字段名
     */
    public static final String HEADER_LANGUES_FIELD = "langues";

    /**
     * 日志默认打印中文
     */
    public static final String DEFAULT_LOGIN_I18N = "zh-CN";
}
