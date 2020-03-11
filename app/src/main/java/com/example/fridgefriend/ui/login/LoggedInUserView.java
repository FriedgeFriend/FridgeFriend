package com.example.fridgefriend.ui.login;

import com.example.fridgefriend.MainActivity;

/**
 * Class exposing authenticated user details to the UI.
 */
class LoggedInUserView extends MainActivity {
    private String displayName;
    //... other data fields that may be accessible to the UI

    LoggedInUserView(String displayName) {
        this.displayName = displayName;
    }

    String getDisplayName() {
        return displayName;
    }
}
