package com.xxz.rent.component;

import com.xxz.rent.common.api.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLSyntaxErrorException;


/**
 * @author xxz
 */
@ControllerAdvice
@Slf4j
public class CommonExceptionHandler {




    @ExceptionHandler
    public @ResponseBody CommonResult exceptionHandler(Exception e)  {
        log.error(e.getMessage(), e);
        return CommonResult.failed("服务器未知异常！");
    }

    @ExceptionHandler
    public @ResponseBody CommonResult missParameterException(MissingServletRequestParameterException e) {
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
    @ExceptionHandler
    public @ResponseBody CommonResult exceptionHandler(BadCredentialsException e)  {
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
    public @ResponseBody CommonResult argumentExceptionHandler(SQLSyntaxErrorException e) {
        log.error(e.getMessage(), e);
        return CommonResult.failed("SQL异常");
    }

}
