package com.example.fridgefriend;

import android.content.Context;
import android.graphics.Color;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fridgefriend.data.model.Ingredient;

import java.util.LinkedList;
import java.util.List;


public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder>  {


    private List<Ingredient> mIngredientList;
    private LayoutInflater mInflater;

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    public WordListAdapter(List<Ingredient> ingredientList) {
        this.mIngredientList = ingredientList;
    }

    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wordlist_item, parent, false);
        return new WordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final WordViewHolder holder, int position) {
        final Ingredient ingredient = mIngredientList.get(position);
        holder.textView.setText(ingredient.getText());
        holder.view.setBackgroundColor(ingredient.isSelected() ? Color.rgb(35, 170, 137) : Color.WHITE);
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingredient.setSelected(!ingredient.isSelected());
                holder.view.setBackgroundColor(ingredient.isSelected() ? Color.rgb(35, 170, 137) : Color.WHITE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mIngredientList == null ? 0 : mIngredientList.size();
    }


    public class WordViewHolder extends RecyclerView.ViewHolder  {
        private View view;
        private TextView textView;

        private WordViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            textView = (TextView) itemView.findViewById(R.id.text_view);
        }
    }



}
