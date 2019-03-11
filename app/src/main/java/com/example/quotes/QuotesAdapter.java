package com.example.quotes;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

public class QuotesAdapter extends RecyclerView.Adapter<QuotesAdapter.QuotesViewHolder> {

    Context context;
    List<String> lstQuotes;

    public QuotesAdapter(Context context, List<String> lstQuotes) {
        this.context = context;
        this.lstQuotes = lstQuotes;
    }

    @NonNull
    @Override
    public QuotesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        LayoutInflater inflater = LayoutInflater.from(context);
//        View view = inflater.inflate(R.layout.list_item_quotes,viewGroup,false);
//        return new QuotesViewHolder(view);

        final View view = LayoutInflater.from(context).inflate(R.layout.list_item_quotes, viewGroup, false);
        return new QuotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuotesViewHolder quotesViewHolder, int i) {
        String[] colors ={"#FF4500","#FFD700","#FFA500","#FF8C00"};
        String quotes = lstQuotes.get(i);
        quotesViewHolder.txtQuotes.setText(quotes);
        int color = i % colors.length;
        int intColor = Color.parseColor(colors[color]);
        quotesViewHolder.quoteContainer.setBackgroundColor(intColor);
    }

    @Override
    public int getItemCount() {
        return lstQuotes.size();
    }

    public class QuotesViewHolder extends RecyclerView.ViewHolder {
        TextView txtQuotes;
        LinearLayout quoteContainer;

        public QuotesViewHolder(@NonNull View itemView) {
            super(itemView);
            txtQuotes = itemView.findViewById(R.id.txtQuote);
            quoteContainer = itemView.findViewById(R.id.quoteContainer);
        }
    }
}
