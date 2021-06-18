package com.e.dagger.parent;

import android.util.Log;

import com.e.dagger.Management;
import com.e.dagger.common.Person;

import javax.inject.Inject;

public class Student extends Person {
    private static final String TAG = "Management";

    public Student(String name, String age, String gender) {
        super(name, age, gender);
    }

    @Inject
    public Student() {
    }


    public void showStudent(Management management) {
        Log.d(TAG, "showStudent: " + toString());
    }
}
