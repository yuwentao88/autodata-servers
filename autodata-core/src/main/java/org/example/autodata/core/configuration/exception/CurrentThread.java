package org.example.autodata.core.configuration.exception;

import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * author:north
 * Date:2020/7/31 ：17:30
 */
@Data
@Slf4j
public class CurrentThread {
    private static final ThreadLocal<CurrentThread> THREAD_LOCAL = new ThreadLocal<CurrentThread>();
    /**
     * 线程标识
     **/
    private String traceId;

    /**
     * 请求的body
     */
    @Getter
    private String requestBody;

    /**
     * 请求的url
     */
    @Getter
    private String requestUrl;


    public static final void set(String traceId, String requestBody, String requestUrl) {
        CurrentThread currentThread = CurrentThread.get();
        if (StringUtils.isNoneBlank(traceId)) {
            currentThread.setTraceId(traceId);
        }
        if (StringUtils.isNoneBlank(requestBody)) {
            currentThread.setRequestBody(requestBody);
        }
        if (StringUtils.isNoneBlank(requestUrl)) {
            currentThread.setRequestUrl(requestUrl);
        }

        THREAD_LOCAL.remove();
        THREAD_LOCAL.set(currentThread);
    }


    public static final void cleaer() {
        THREAD_LOCAL.remove();
    }

    public static final CurrentThread get() {
        CurrentThread currentThread = THREAD_LOCAL.get();
        if (currentThread == null) {
            currentThread = new CurrentThread();
        }
        return currentThread;
    }


}
