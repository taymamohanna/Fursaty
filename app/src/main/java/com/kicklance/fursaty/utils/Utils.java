package com.kicklance.fursaty.utils;


import android.content.Context;
import android.content.Intent;

import com.kicklance.fursaty.models.Job;

import java.util.Locale;

public class Utils {

    public static void shareJob(Context context, Job job) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");

        String shareText = "Job: " + job.getTitle() + "\n"
                + "Summary: " + job.getSummary() + "\n"
                + "Category: " + job.getWorkField().getName() + "\n"
                + "Salary: " + job.getSalary();

        shareIntent.putExtra(Intent.EXTRA_TEXT, shareText);
        context.startActivity(Intent.createChooser(shareIntent, "Share via"));

    }

    public static String formatCount(int count) {
        if (count >= 1000) return String.format(Locale.ENGLISH, "%.1fk", count / 1000.0);
        return String.valueOf(count);
    }
}
