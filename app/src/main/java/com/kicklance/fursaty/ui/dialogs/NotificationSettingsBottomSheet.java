package com.kicklance.fursaty.ui.dialogs;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.materialswitch.MaterialSwitch;
import com.kicklance.fursaty.R;

public class NotificationSettingsBottomSheet extends BottomSheetDialogFragment {

    private boolean isNotificationsEnabled = true; // default or load from preferences

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_notification_settings, container, false);

        MaterialSwitch notificationSwitch = view.findViewById(R.id.notification_switch);
        notificationSwitch.setChecked(isNotificationsEnabled);

        notificationSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            isNotificationsEnabled = isChecked;
            Toast.makeText(getContext(),
                    isChecked ? "Notifications enabled" : "Notifications disabled",
                    Toast.LENGTH_SHORT).show();
            // Save to preferences or update logic here
            buttonView.postDelayed(this::dismiss, 1000);
        });

        return view;
    }
}
