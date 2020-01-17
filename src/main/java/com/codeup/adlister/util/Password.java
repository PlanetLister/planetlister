package com.codeup.adlister.util;

import org.mindrot.jbcrypt.BCrypt;

public class Password {
    private static final int ROUNDS = 12;

    public static String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(ROUNDS));
    }

    public static boolean check(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }

    public static boolean checkPwd(String password){
        String strRegEx = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
//        (?=.*[0-9])       # a digit must occur at least once
//        (?=.*[a-z])       # a lower case letter must occur at least once
//        (?=.*[A-Z])       # an upper case letter must occur at least once
//        (?=.*[@#$%^&+=])  # a special character must occur at least once
//        (?=\S+$)          # no whitespace allowed in the entire string
//        .{8,}             # anything, at least eight places though
        if(password.matches(strRegEx) && password.length() < 11){
            return true;
        }

        return false;
    }

    public static boolean checkEmail(String email){
        String strRegEx = "(?:[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";

        return email.matches(strRegEx);
    }

}
