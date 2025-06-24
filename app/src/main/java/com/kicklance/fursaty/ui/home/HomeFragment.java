package com.kicklance.fursaty.ui.home;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kicklance.fursaty.R;
import com.kicklance.fursaty.models.Job;
import com.kicklance.fursaty.ui.company_detail.CompanyDetailsActivity;
import com.kicklance.fursaty.ui.job_details.JobDetailsActivity;
import com.kicklance.fursaty.utils.Constants;

import java.util.List;


public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MenuHost menuHost = requireActivity();

        menuHost.addMenuProvider(new MenuProvider() {
            @Override
            public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
                menuInflater.inflate(R.menu.home_menu, menu);
                MenuItem item = menu.findItem(R.id.action_notifications);
                View actionView = LayoutInflater.from(requireContext())
                        .inflate(R.layout.notification_badge, null);

                TextView badge = actionView.findViewById(R.id.badge);
                badge.setText("3");
                badge.setVisibility(View.VISIBLE);

                item.setActionView(actionView);

                actionView.setOnClickListener(v -> {
                    // Handle click
                    Toast.makeText(getContext(), "Notifications clicked", Toast.LENGTH_SHORT).show();
                });

            }

            @Override
            public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();

                if (id == R.id.action_search) {
                    // Handle search
                    Toast.makeText(requireContext(), "Search", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.action_filter) {
                    // Handle filter
                    Toast.makeText(requireContext(), "filter", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.action_notifications) {
                    // Handle notifications
                    Toast.makeText(requireContext(), "notifications", Toast.LENGTH_SHORT).show();

                } else {
                    return false;
                }
                return true;
            }
        }, getViewLifecycleOwner(), Lifecycle.State.RESUMED);

        RecyclerView recyclerView = view.findViewById(R.id.home_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        List<Job> jobs = Constants.Jobs.getJobs();
        JobAdapter adapter = new JobAdapter(jobs, getJobClickListener());
        recyclerView.setAdapter(adapter);

    }

    private JobAdapter.OnJobInteractionListener getJobClickListener() {
        return new JobAdapter.OnJobInteractionListener() {
            @Override
            public void onJobClick(Job job) {
                Intent intent = new Intent(requireContext(), JobDetailsActivity.class);
                intent.putExtra(JobDetailsActivity.EXTRA_JOB, job);
                startActivity(intent);
            }

            @Override
            public void onJobCompanyClick(Job job) {
                Intent intent = new Intent(requireContext(), CompanyDetailsActivity.class);
                intent.putExtra(CompanyDetailsActivity.EXTRA_JOB, job);
                startActivity(intent);
            }
        };
    }


}
