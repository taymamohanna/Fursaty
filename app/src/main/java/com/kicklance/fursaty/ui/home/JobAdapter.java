package com.kicklance.fursaty.ui.home;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.kicklance.fursaty.R;
import com.kicklance.fursaty.models.Job;
import com.kicklance.fursaty.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class JobAdapter extends RecyclerView.Adapter<JobAdapter.JobViewHolder> {

    private final List<Job> jobList;
    private final OnJobInteractionListener listener;

    public JobAdapter(List<Job> jobList, OnJobInteractionListener listener) {
        this.jobList = jobList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public JobViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_job, parent, false);
        return new JobViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JobViewHolder holder, int position) {
        final Job job = jobList.get(position);

        holder.isFavorite.setVisibility(job.isFavorite() ? View.VISIBLE : View.GONE);
        holder.title.setText(job.getTitle());
        holder.registration.setText(String.format(Locale.ENGLISH, "(%d)", 1012416));
        holder.watchesCount.setText(Utils.formatCount(job.getWatchesCount()));
        holder.description.setText(job.getSummary());
        holder.createTime.setText(job.getCreateTime());
        holder.category.setText(job.getWorkField().getName());
        holder.salary.setText(job.getSalary());
        holder.experience.setText(job.getExperienceYears());
        holder.validUntil.setText(job.getJobValidUntil());

        Job.BusinessMan bm = job.getBusinessMan();
        holder.businessName.setText(bm.getName());
        Glide.with(holder.businessImage.getContext())
                .load(bm.getImageUrl())
                .placeholder(R.drawable.ic_business_man)
                .transform(new CenterCrop(), new RoundedCorners(20))
                .into(holder.businessImage);

        for (int i = 0; i < holder.skills.size(); i++) {
            if (job.getSkills().isEmpty() || job.getSkills().size() == i) return;
            holder.skills.get(i).setText(job.getSkills().get(i));
        }
        holder.expireDate.setText(String.format(Locale.ENGLISH, "Expire In : %d days ", job.getExpireDate()));

        holder.share.setOnClickListener(view -> Utils.shareJob(view.getContext(), job));
        holder.itemView.setOnClickListener(v -> listener.onJobClick(job));
        holder.businessImage.setOnClickListener(v -> listener.onJobCompanyClick(job));

    }

    @Override
    public int getItemCount() {
        return jobList.size();
    }

    public interface OnJobInteractionListener {
        void onJobClick(Job job);

        void onJobCompanyClick(Job job);
    }

    static class JobViewHolder extends RecyclerView.ViewHolder {
        View isFavorite, share;
        TextView title, watchesCount, description, createTime, category, salary, experience, validUntil, businessName, registration, expireDate;
        ImageView businessImage;
        List<TextView> skills;

        JobViewHolder(View itemView) {
            super(itemView);
            isFavorite = itemView.findViewById(R.id.iv_bookmarked);
            share = itemView.findViewById(R.id.iv_share);
            title = itemView.findViewById(R.id.job_title);
            businessImage = itemView.findViewById(R.id.iv_business_man);
            businessName = itemView.findViewById(R.id.tv_business_man);
            registration = itemView.findViewById(R.id.tv_registration);
            watchesCount = itemView.findViewById(R.id.tv_watches_count);
            description = itemView.findViewById(R.id.job_description);
            createTime = itemView.findViewById(R.id.job_create_time);
            category = itemView.findViewById(R.id.job_category);
            salary = itemView.findViewById(R.id.job_salary);
            expireDate = itemView.findViewById(R.id.expire_date);
            experience = itemView.findViewById(R.id.experience);
            validUntil = itemView.findViewById(R.id.valid_until);

            skills = new ArrayList<>();
            skills.add(itemView.findViewById(R.id.job_skill_1));
            skills.add(itemView.findViewById(R.id.job_skill_2));
            skills.add(itemView.findViewById(R.id.job_skill_3));
        }
    }
}
