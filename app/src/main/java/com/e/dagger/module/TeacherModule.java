package com.e.dagger.module;

import com.e.dagger.teacher.Teacher;

import dagger.Module;
import dagger.Provides;

@Module
public class TeacherModule {

    String name;
    String age;
    String gender;

    public TeacherModule(String name, String age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Provides
    public Teacher provideTeacherModule() {
        return new Teacher(name, age, gender);
    }
}
