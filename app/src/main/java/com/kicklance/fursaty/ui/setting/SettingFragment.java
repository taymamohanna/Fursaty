package com.kicklance.fursaty.ui.setting;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.kicklance.fursaty.R;
import com.kicklance.fursaty.ui.dialogs.LanguageBottomSheet;
import com.kicklance.fursaty.ui.dialogs.NotificationSettingsBottomSheet;
import com.kicklance.fursaty.ui.dialogs.ReadMoreBottomSheet;
import com.kicklance.fursaty.ui.faq.FAQsActivity;
import com.kicklance.fursaty.ui.help_feedback.HelpFeedbackActivity;

public class SettingFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.item_job_country).setOnClickListener(v -> new LanguageBottomSheet().show(getParentFragmentManager(), "CountrySheet"));

        view.findViewById(R.id.item_faqs).setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), FAQsActivity.class);
            startActivity(intent);
        });

        view.findViewById(R.id.item_help_feedback).setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), HelpFeedbackActivity.class);
            startActivity(intent);
        });

        view.findViewById(R.id.item_privacy).setOnClickListener(v -> {
            // Open Privacy Policy
            String title = getString(R.string.settings_privacy);
            String description = getString(R.string.privacy_policy);
            new ReadMoreBottomSheet(title, description)
                    .show(getParentFragmentManager(), "PrivacySheet");

        });

        view.findViewById(R.id.item_language).setOnClickListener(v -> new LanguageBottomSheet().show(getParentFragmentManager(), "LangSheet"));

        view.findViewById(R.id.item_notifications).setOnClickListener(v -> new NotificationSettingsBottomSheet().show(getParentFragmentManager(), "NotifySheet"));


    }
}
