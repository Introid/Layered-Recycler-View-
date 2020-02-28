package com.introid.mykindarecyclerview.model;

import java.io.Serializable;

public class Group implements Serializable {
    private String groupTitle;

    public Group() {
    }

    public Group(String groupTitle) {
        this.groupTitle = groupTitle;
    }

    public String getGroupTitle() {
        return groupTitle;
    }

    public void setGroupTitle(String groupTitle) {
        this.groupTitle = groupTitle;
    }
}
