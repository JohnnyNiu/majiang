package com.majiang.scorecalculator.service;

import com.majiang.scorecalculator.model.dto.WinningDataDto;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by xiaomingniu on 9/11/15.
 */
public class WinningDataDtoValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(WinningDataDto.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
    }
}
