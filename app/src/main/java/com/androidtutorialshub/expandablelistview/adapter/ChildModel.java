package com.androidtutorialshub.expandablelistview.adapter;

public class ChildModel {
//    unique
    String id;
    String name;
    boolean status =false;

    public ChildModel(String id, String name, boolean status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
