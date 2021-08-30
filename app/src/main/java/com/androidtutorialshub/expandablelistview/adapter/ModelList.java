package com.androidtutorialshub.expandablelistview.adapter;

import java.util.ArrayList;

public class ModelList {
    String name;
    String id;
    ArrayList<ChildModel> childModel;

    public ModelList(String id, String name, ArrayList<ChildModel> childModel) {
        this.name = name;
        this.id = id;
        this.childModel = childModel;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public ArrayList<ChildModel> getChildModel() {
        return childModel;
    }
}