package com.jgelpud.project.APIusersAccess.Commons;

public class Validate {

    public static void checkNotNull(Object value) {
        if(value == null) {
            throw new IllegalArgumentException("Value is null");
        }
    }
}
