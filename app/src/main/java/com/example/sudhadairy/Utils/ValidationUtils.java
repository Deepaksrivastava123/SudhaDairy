package com.example.sudhadairy.Utils;

import android.widget.EditText;

public class ValidationUtils {

    public static boolean blankValidation(EditText editText) {
        String emailString = editText.getText().toString().trim();
        if (emailString.length() > 0) {
            editText.setError(null);
            return true;
        } else {
            editText.setError("Required feild");
            return false;
        }
    }
}
