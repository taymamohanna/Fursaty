package com.kicklance.fursaty.ui.dialogs;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.kicklance.fursaty.R;

public class ReadMoreBottomSheet extends BottomSheetDialogFragment {

    private final String title;
    private final String fullDescription;

    public ReadMoreBottomSheet(String title, String fullDescription) {
        this.title = title;
        this.fullDescription = fullDescription;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_read_more, container, false);
        TextView tvTitle = view.findViewById(R.id.title);
        TextView tvText = view.findViewById(R.id.text);

        tvTitle.setText(title);
        tvText.setText(fullDescription);

        return view;
    }
}
