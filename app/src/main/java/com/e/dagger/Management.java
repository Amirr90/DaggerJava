package com.e.dagger;

import android.util.Log;

import com.e.dagger.parent.Parent;
import com.e.dagger.parent.Student;
import com.e.dagger.school.School;
import com.e.dagger.teacher.Teacher;

import javax.inject.Inject;


public class Management {
    private static final String TAG = "Management";
    Teacher teacher;
    Parent parent;
    Student student;
    School school;

    @Inject
    public Management(Teacher teacher, Parent parent, Student student, School school) {
        this.teacher = teacher;
        this.parent = parent;
        this.student = student;
        this.school = school;
    }

    @Inject
    public void showParent() {
        parent.showParent(this);
    }

    @Inject
    public void showTeacher() {
        Log.d(TAG, "showTeacher: " + teacher.toString());
    }

    @Inject
    public void showStudent() {
        student.showStudent(this);
    }

    @Inject
    public void showSchool() {
        school.showSchool(this);
    }

    public void managementReport() {
        Log.d(TAG, "managementStatus is ready: ");

    }


}
