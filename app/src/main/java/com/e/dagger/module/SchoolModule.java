package com.e.dagger.module;

import com.e.dagger.school.School;

import dagger.Module;
import dagger.Provides;

@Module
public class SchoolModule {
    String name;
    String address;

    public SchoolModule(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Provides
    public School provideSchool() {
        return new School(name, address);
    }
}
