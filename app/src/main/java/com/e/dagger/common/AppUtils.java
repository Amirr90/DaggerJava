package com.e.dagger.common;

import android.app.Activity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.e.dagger.R;

import javax.inject.Inject;


public class AppUtils {
    @Inject
    public AppUtils() {
    }

    public static Animation slideFromLeft(Activity activity) {
        return AnimationUtils.loadAnimation(activity, R.anim.fade_in);
    }

}
