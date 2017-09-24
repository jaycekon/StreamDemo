package com.Jaycekon.stream.restructure.Validation;

/**
 * Created by Jaycekon on 2017/9/24.
 */
public class Validator {
    private ValidationStrategy strategy;

    public Validator(ValidationStrategy v) {
        this.strategy = v;
    }


    public boolean execute(String s) {
        return this.strategy.excute(s);
    }
}

