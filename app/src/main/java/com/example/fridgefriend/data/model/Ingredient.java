package com.example.fridgefriend.data.model;

public class Ingredient {
    private String text;
    private boolean isSelected = false;

    public Ingredient (String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setSelected(boolean selected){
        isSelected = selected;
    }

    public boolean isSelected(){
        return isSelected;
    }
}
