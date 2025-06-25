package com.kicklance.fursaty.ui.faq;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kicklance.fursaty.R;
import com.kicklance.fursaty.models.FAQ;

import java.util.List;

public class FAQAdapter extends RecyclerView.Adapter<FAQAdapter.FAQViewHolder> {

    private final List<FAQ> faqList;
    private final OnFaqClickListener listener;

    public FAQAdapter(List<FAQ> faqList, OnFaqClickListener listener) {
        this.faqList = faqList;
        this.listener = listener;
    }


    @NonNull
    @Override
    public FAQViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_faq, parent, false);
        return new FAQViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FAQViewHolder holder, int position) {
        FAQ faq = faqList.get(position);
        holder.title.setText(faq.getTitle());
        holder.itemView.setOnClickListener(v -> listener.onFaqClick(faq));
    }

    @Override
    public int getItemCount() {
        return faqList.size();
    }

    public interface OnFaqClickListener {
        void onFaqClick(FAQ faq);
    }

    public static class FAQViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public FAQViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.faq_title);
        }
    }

}
