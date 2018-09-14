package app.compassites.com.healthosapp.features.utils;

import android.animation.ObjectAnimator;
import android.view.View;

/**
 * Created by shruthi on 7/5/18.
 */

public class AnimationUtils {

    public static void animateView(View view, String translation, float from, float to, long duration) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, translation, from, to);
        animator.setDuration(duration);
        animator.start();
    }
}
