package com.xxz.rent.portal.bo.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-04 16:55
 * @description：手机号码校验器
 * @modified By：
 * @version: ：1.0
 */
public class PhoneValidator implements ConstraintValidator<PhonePattern, String> {
    private String regex;

    @Override
    public void initialize(PhonePattern constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        regex = constraintAnnotation.regex();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        // 当前前端传过来的请求参数是空串，或者没传的时候，不进行后续正则校验
        if ("".equals(s) || s == null) {
            return true;
        }
        // 进行正则校验
        if(s.matches(regex)) {
            return true;
        }
        return false;
    }
}
