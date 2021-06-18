package com.e.dagger.school;

import android.util.Log;

import com.e.dagger.Management;
import com.e.dagger.common.Person;

import javax.inject.Inject;

public class School extends Person {
    private static final String TAG = "Management";

    @Inject
    public School() {
    }

    public School(String name, String address) {
        super(name, address);
    }

    public void showSchool(Management management) {
        Log.d(TAG, "showSchool: " + toString());
    }
}
