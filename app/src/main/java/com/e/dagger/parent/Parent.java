package com.e.dagger.parent;

import android.util.Log;

import com.e.dagger.Management;
import com.e.dagger.common.Person;

import javax.inject.Inject;

public class Parent extends Person {

    private static final String TAG = "Management";

    public Parent(String name, String age, String gender) {
        super(name, age, gender);
    }

    @Inject
    public Parent() {
    }

    @Inject
    public void showParent(Management management) {
        Log.d(TAG, "showParent: " + toString());
    }
}
