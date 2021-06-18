package com.e.dagger.module;


public class Module {

    public static SchoolModule getSchoolModule() {
        return new SchoolModule("City Montessory School", "Rajaji Puram");
    }

    public static StudentModule getStudentModule() {
        return new StudentModule("Yash Yadav", "17", "male");
    }

    public static ParentModule getParentModule() {
        return new ParentModule("Aamirr Khan", "20", "male");
    }

    public static TeacherModule getTeacherModule() {
        return new TeacherModule("Seema Sharma", "20", "female");
    }
}
