package org.example.autodata.core.configuration.exception;

import lombok.extern.slf4j.Slf4j;
import org.example.autodata.core.util.BaseContants;
import org.example.autodata.core.util.BusinessCode;
import org.example.autodata.core.util.Response;
import org.example.autodata.core.util.ThrowableUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

/**
 * author:north
 * Date:2020/7/31 ：17:27
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理所有不可知的异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Response handleException(Exception e) {
        // 打印堆栈信息
        log.error("error=[{}]\n,request=[{}],\n" + "url=[{}]\n",
                e.getMessage(),
                CurrentThread.get().getRequestBody(),
                CurrentThread.get().getRequestUrl(),
                ThrowableUtil.getStackTrace(e));
        log.error(e.getMessage(),e);
        return Response.fail(BusinessCode.FAILD, BaseContants.MsgKey.CORE_SYSTEM_EXCEPTION);
    }


    /**
     * 处理校验异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public Response handleConstraintViolationException(ConstraintViolationException e) {
        // 打印堆栈信息
        log.error("异常[{}],request=[{}],\n" +
                        "url=[{}]",
                e.getMessage(),
                CurrentThread.get().getRequestBody(),
                CurrentThread.get().getRequestUrl(),
                ThrowableUtil.getStackTrace(e));
        String errMessage = e.getMessage();
        log.error(e.getMessage(),e);
        return Response.fail(BusinessCode.FAILD, errMessage.substring(errMessage.indexOf(":") + 1));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        // 打印堆栈信息
        log.error("异常[{}],request=[{}],\n" +
                        "url=[{}]",
                e.getMessage(),
                CurrentThread.get().getRequestBody(),
                CurrentThread.get().getRequestUrl(),
                ThrowableUtil.getStackTrace(e));
        String errMessage = e.getMessage();
        log.error(e.getMessage(),e);
        return Response.fail(BusinessCode.FAILD, e.getBindingResult().getFieldError().getDefaultMessage());
    }

}
