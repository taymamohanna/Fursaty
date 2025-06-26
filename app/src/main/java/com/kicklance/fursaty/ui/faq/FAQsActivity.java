package com.kicklance.fursaty.ui.faq;


import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kicklance.fursaty.R;
import com.kicklance.fursaty.models.FAQ;
import com.kicklance.fursaty.models.ResponseData;
import com.kicklance.fursaty.network.Network;
import com.kicklance.fursaty.ui.dialogs.ReadMoreBottomSheet;
import com.kicklance.fursaty.utils.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FAQsActivity extends AppCompatActivity {

    private RecyclerView faqRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faqs);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setTitle(R.string.settings_faq);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }

        faqRecycler = findViewById(R.id.faq_recycler);
        faqRecycler.setLayoutManager(new LinearLayoutManager(this));

        getFaqs();
    }

    @Override
    public boolean onSupportNavigateUp() {
        getOnBackPressedDispatcher().onBackPressed();
        return true;
    }

    private void populateUI() {
        List<FAQ> faqList = Constants.FAQs.getSampleFAQs();
        faqRecycler.setAdapter(new FAQAdapter(faqList, faq -> new ReadMoreBottomSheet(faq.getTitle(), faq.getDescription())
                .show(getSupportFragmentManager(), "FaqReadMore")));

    }

    private void getFaqs() {
        Network.getApiService().getFaqs().enqueue(new Callback<>() {
            @Override
            public void onResponse(@NonNull Call<ResponseData<List<FAQ>>> call, @NonNull Response<ResponseData<List<FAQ>>> response) {
                if (response.isSuccessful() && response.body() != null && response.body().isStatus()) {
                    List<FAQ> faqList = response.body().getData();
                    faqRecycler.setAdapter(new FAQAdapter(faqList, faq -> new ReadMoreBottomSheet(faq.getTitle(), faq.getDescription())
                            .show(getSupportFragmentManager(), "FaqReadMore")));
                } else {
                    Log.w("TAG", "onResponse: Failed to load jobs ");
                    populateUI();
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponseData<List<FAQ>>> call, @NonNull Throwable t) {
                Log.e("TAG", "onFailure: Error: " + t.getMessage(), t);
                populateUI();
            }
        });
    }

}
