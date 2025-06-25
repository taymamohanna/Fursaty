package com.kicklance.fursaty.ui.faq;


import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kicklance.fursaty.R;
import com.kicklance.fursaty.models.FAQ;
import com.kicklance.fursaty.ui.dialogs.ReadMoreBottomSheet;
import com.kicklance.fursaty.utils.Constants;

import java.util.List;

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

        populateUI();
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

}
