package com.e.dagger.component;

import com.e.dagger.MainActivity;
import com.e.dagger.Management;
import com.e.dagger.module.ParentModule;
import com.e.dagger.module.SchoolModule;
import com.e.dagger.module.StudentModule;
import com.e.dagger.module.TeacherModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {TeacherModule.class, ParentModule.class, StudentModule.class, SchoolModule.class})
public interface AppComponent {
    Management getManagement();

    void inject(MainActivity mainActivity);

}
