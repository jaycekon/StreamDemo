package com.Jaycekon.stream.restructure.Validation;

/**
 * Created by Jaycekon on 2017/9/24.
 */
public class IsNumberic implements ValidationStrategy {
    @Override
    public boolean excute(String s) {
        return s.matches("\\d+");
    }
}
