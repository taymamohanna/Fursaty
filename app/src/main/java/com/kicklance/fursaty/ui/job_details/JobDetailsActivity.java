package com.kicklance.fursaty.ui.job_details;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.kicklance.fursaty.R;
import com.kicklance.fursaty.models.Job;
import com.kicklance.fursaty.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class JobDetailsActivity extends AppCompatActivity {

    public static final String EXTRA_JOB = "extra_job";

    private ImageView isFavorite, businessImage, countryFlag;
    private TextView createTime, title, summary, jobType, workField, salary, experience, country, businessName, watchesCount, nationality, countryResidence, gender;
    private List<TextView> skills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_back);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }

        isFavorite = findViewById(R.id.iv_bookmarked);
        createTime = findViewById(R.id.job_create_time);
        businessImage = findViewById(R.id.iv_business_man);
        title = findViewById(R.id.job_title);
        businessName = findViewById(R.id.tv_business_man);
        watchesCount = findViewById(R.id.tv_watches_count);
        View share = findViewById(R.id.iv_share);

        salary = findViewById(R.id.job_salary);
        jobType = findViewById(R.id.job_Type);
        workField = findViewById(R.id.work_field);
        experience = findViewById(R.id.experience);
        country = findViewById(R.id.country_of_employment);
        countryFlag = findViewById(R.id.country_of_employment_flag);
        summary = findViewById(R.id.job_description);

        skills = new ArrayList<>();
        skills.add(findViewById(R.id.job_skill_1));
        skills.add(findViewById(R.id.job_skill_2));
        skills.add(findViewById(R.id.job_skill_3));


        nationality = findViewById(R.id.nationality);
        countryResidence = findViewById(R.id.country_residence);
        gender = findViewById(R.id.gender);

        Job job = getIntent().getParcelableExtra(EXTRA_JOB);
        if (job != null) {
            populateUI(job);
            share.setOnClickListener(view -> Utils.shareJob(view.getContext(), job));
        }
    }

    private void populateUI(Job job) {
        isFavorite.setVisibility(job.isFavorite() ? View.VISIBLE : View.GONE);
        createTime.setText(job.getCreateTime());
        title.setText(job.getTitle());
        Glide.with(businessImage.getContext()).load(job.getBusinessMan().getImageUrl()).placeholder(R.drawable.ic_business_man).transform(new CenterCrop(), new RoundedCorners(20)).into(businessImage);
        businessName.setText(job.getBusinessMan().getName());
        watchesCount.setText(Utils.formatCount(job.getWatchesCount()));

        jobType.setText(job.getWorkField().getName());
        workField.setText(job.getWorkField().getName());
        salary.setText(job.getSalary());
        experience.setText(job.getExperienceYears());
        country.setText(job.getCountryOfEmployment().getName());
        Glide.with(countryFlag.getContext()).load(job.getCountryOfEmployment().getCountryImage()).placeholder(R.drawable.ic_earth).transform(new CenterCrop(), new RoundedCorners(20)).into(countryFlag);

        for (int i = 0; i < skills.size(); i++) {
            if (job.getSkills().isEmpty() || job.getSkills().size() == i) return;
            skills.get(i).setText(job.getSkills().get(i));
        }

        summary.setText(job.getSummary());
        nationality.setText(job.getCountryOfEmployment().getName());
        countryResidence.setText(job.getCountryOfEmployment().getName());
        final String mGender = "All";
        gender.setText(mGender);

    }

    @Override
    public boolean onSupportNavigateUp() {
        getOnBackPressedDispatcher().onBackPressed();
        return true;
    }

}