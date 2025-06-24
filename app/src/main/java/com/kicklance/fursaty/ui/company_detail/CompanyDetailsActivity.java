package com.kicklance.fursaty.ui.company_detail;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.kicklance.fursaty.R;
import com.kicklance.fursaty.models.Job;
import com.kicklance.fursaty.ui.home.JobAdapter;
import com.kicklance.fursaty.ui.job_details.JobDetailsActivity;
import com.kicklance.fursaty.utils.Constants;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class CompanyDetailsActivity extends AppCompatActivity {

    public static final String EXTRA_JOB = "extra_job";

    private ImageView companyCover, companyImage, countryFlag;
    private TextView companyName, registration, businessType, employeeNo, country, companyBio;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_details);
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

        companyCover = findViewById(R.id.company_cover);
        companyImage = findViewById(R.id.company_image);
        companyName = findViewById(R.id.company_name);
        registration = findViewById(R.id.registration);
        businessType = findViewById(R.id.type_of_business);
        employeeNo = findViewById(R.id.no_of_employees);
        country = findViewById(R.id.country);
        countryFlag = findViewById(R.id.country_flag);
        companyBio = findViewById(R.id.bio);

        recyclerView = findViewById(R.id.home_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Job job = getIntent().getParcelableExtra(EXTRA_JOB);
        if (job != null) {
            populateUI(job);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        getOnBackPressedDispatcher().onBackPressed();
        return true;
    }

    private void populateUI(Job job) {
        Job.BusinessMan bm = job.getBusinessMan();
        Glide.with(companyCover.getContext()).load(bm.getCoverUrl()).placeholder(R.drawable.company_cover_placeholder).error(R.drawable.company_cover_placeholder).transform(new CenterCrop(), new RoundedCorners(20)).into(companyCover);
        Glide.with(companyImage.getContext()).load(bm.getImageUrl()).placeholder(R.drawable.ic_business_man).error(R.drawable.ic_business_man).circleCrop().into(companyImage);
        companyName.setText(bm.getName());
        registration.setText(String.format(Locale.ENGLISH, "(%d)", 1012416));
        businessType.setText(bm.getTypeBusiness());
        employeeNo.setText(String.format(Locale.ENGLISH, bm.getEmployeeNo() + "+"));
        country.setText(job.getCountryOfEmployment().getName());
        Glide.with(countryFlag.getContext()).load(job.getCountryOfEmployment().getCountryImage()).error(R.drawable.ic_earth).centerCrop().into(countryFlag);
        companyBio.setText(bm.getBio());

        List<Job> jobs = Constants.Jobs.getJobs().stream().filter(job1 -> job1.getBusinessMan().getId() == bm.getId()).collect(Collectors.toList());
        JobAdapter adapter = new JobAdapter(jobs, getJobClickListener());
        recyclerView.setAdapter(adapter);
    }

    private JobAdapter.OnJobInteractionListener getJobClickListener() {
        return new JobAdapter.OnJobInteractionListener() {
            @Override
            public void onJobClick(Job job) {
                Intent intent = new Intent(CompanyDetailsActivity.this, JobDetailsActivity.class);
                intent.putExtra(JobDetailsActivity.EXTRA_JOB, job);
                startActivity(intent);
            }

            @Override
            public void onJobCompanyClick(Job job) {
            }
        };
    }

}