package com.aiyu.furniture.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;

import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;
import androidx.palette.graphics.Palette;

import com.aiyu.furniture.R;

import java.util.ArrayList;
import java.util.List;


public class Images {
    private static final List<Integer> imageList = new ArrayList<>();

    static {
        imageList.add(R.drawable.img_0);
        imageList.add(R.drawable.img_1);
        imageList.add(R.drawable.img_2);
        imageList.add(R.drawable.img_3);
        imageList.add(R.drawable.img_4);
        imageList.add(R.drawable.img_5);
        imageList.add(R.drawable.img_6);
        imageList.add(R.drawable.img_7);
        imageList.add(R.drawable.img_8);
        imageList.add(R.drawable.img_9);
        imageList.add(R.drawable.img_10);
        imageList.add(R.drawable.img_11);
        imageList.add(R.drawable.img_12);
        imageList.add(R.drawable.img_13);
        imageList.add(R.drawable.img_14);
        imageList.add(R.drawable.img_15);
        imageList.add(R.drawable.img_16);
        imageList.add(R.drawable.img_17);
        imageList.add(R.drawable.img_18);
    }

    public static int getRandomImage() {
        int randomIndex = (int) (Math.random() * imageList.size());
        return imageList.get(randomIndex);
    }

    // Import necessary classes

    // Inside your Activity or Fragment
    public static void extractDominantColor(Context context, @DrawableRes int imageResId, View yourView) {
        // Get the drawable
        Bitmap image = BitmapFactory.decodeResource(context.getResources(), imageResId);

        // Generate palette asynchronously
        Palette.from(image).generate(palette -> {
            // Get the dominant color
            int dominantColor = 0; // BLACK is the default
            if (palette != null) {
                dominantColor = palette.getDominantColor(ContextCompat.getColor(context, R.color.primary));
                yourView.setBackgroundColor(dominantColor);
            } else {
                yourView.setBackgroundColor(ContextCompat.getColor(context, R.color.primary));
            }

        });
    }
}
