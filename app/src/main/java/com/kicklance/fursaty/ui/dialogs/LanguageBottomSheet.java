package com.kicklance.fursaty.ui.dialogs;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.kicklance.fursaty.R;

public class LanguageBottomSheet extends BottomSheetDialogFragment {

    private String selectedLanguage = "en"; // default

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_language, container, false);

        LinearLayout englishOption = view.findViewById(R.id.option_english);
        LinearLayout arabicOption = view.findViewById(R.id.option_arabic);
        ImageView checkEnglish = view.findViewById(R.id.check_english);
        ImageView checkArabic = view.findViewById(R.id.check_arabic);

        updateSelection(checkEnglish, checkArabic);

        englishOption.setOnClickListener(v -> {
            selectedLanguage = "en";
            updateSelection(checkEnglish, checkArabic);
            dismiss();
        });

        arabicOption.setOnClickListener(v -> {
            selectedLanguage = "ar";
            updateSelection(checkEnglish, checkArabic);
            dismiss();
        });

        return view;
    }

    private void updateSelection(ImageView checkEnglish, ImageView checkArabic) {
        checkEnglish.setVisibility("en".equals(selectedLanguage) ? View.VISIBLE : View.GONE);
        checkArabic.setVisibility("ar".equals(selectedLanguage) ? View.VISIBLE : View.GONE);
    }
}
