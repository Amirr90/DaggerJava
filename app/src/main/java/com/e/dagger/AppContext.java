package com.e.dagger;

import android.app.Application;

import com.e.dagger.component.AppComponent;
import com.e.dagger.component.DaggerAppComponent;

import static com.e.dagger.module.Module.getParentModule;
import static com.e.dagger.module.Module.getSchoolModule;
import static com.e.dagger.module.Module.getStudentModule;
import static com.e.dagger.module.Module.getTeacherModule;

public class AppContext extends Application {

    AppComponent appComponent;


    public static AppContext context;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .teacherModule(getTeacherModule())
                .parentModule(getParentModule())
                .studentModule(getStudentModule())
                .schoolModule(getSchoolModule())
                .build();

        context = this;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
