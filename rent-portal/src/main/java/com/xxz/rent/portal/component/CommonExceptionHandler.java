package com.xxz.rent.portal.component;

import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.portal.bo.exception.BusinessLogicException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import java.sql.SQLSyntaxErrorException;


/**
 * @author xxz
 */
@ControllerAdvice
@Slf4j
public class CommonExceptionHandler {


    @ExceptionHandler
    public @ResponseBody CommonResult exceptionHandler(Exception e) throws Exception {
        log.error(e.getMessage(), e);
        return CommonResult.failed("服务器未知异常！");
    }


    /**
     * 处理spring Mvc 参数请求缺失
     */
    @ExceptionHandler
    public @ResponseBody CommonResult missParameterException(MissingServletRequestParameterException e) {
        log.error(e.getMessage(), e);
        return CommonResult.validateFailed(e.getMessage());
    }
    @ExceptionHandler
    public @ResponseBody CommonResult missingServletRequestPartExceptionHandler(MissingServletRequestPartException e) {
        log.error(e.getMessage(), e);
        return CommonResult.validateFailed(e.getMessage());
    }


    /**
     * 处理登陆错误
     * @param e
     * @return
     */
    @ExceptionHandler
    public @ResponseBody CommonResult userAndPassHandler(UsernameNotFoundException e) {
        log.error(e.getMessage(), e);
        return CommonResult.failed(e.getMessage());
    }

    /**
     * 处理断言错误
     * @param e
     * @return
     */
    @ExceptionHandler
    public @ResponseBody CommonResult argumentExceptionHandler(IllegalArgumentException e) {
        log.error(e.getMessage(), e);
        return CommonResult.failed(e.getMessage());
    }


    /**
     * 处理SQL异常
     * @param e
     * @return
     */
    @ExceptionHandler
    public @ResponseBody CommonResult sqlSyntaxErrorExceptionHandler(SQLSyntaxErrorException e) {
        log.error(e.getMessage(), e);
        return CommonResult.failed("服务器异常！");
    }

    /**
     * 业务逻辑异常
     * @param e
     * @return
     */
    @ExceptionHandler
    public @ResponseBody CommonResult businessLogicExceptionHandler(BusinessLogicException e) {
        log.error(e.getMessage(), e);
        return CommonResult.failed(e.getMessage());
    }


}
