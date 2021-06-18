package com.e.dagger.module;

import com.e.dagger.parent.Student;

import dagger.Module;
import dagger.Provides;

@Module
public class StudentModule {
    String name;
    String age;
    String gender;

    public StudentModule(String name, String age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Provides
    public Student provideStudentModule() {
        return new Student(name, age, gender);
    }
}
