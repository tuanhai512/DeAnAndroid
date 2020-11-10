package com.example.doanltdd.model;

import java.util.List;

public class ListData {
    private int type;
    private List<Group> listgroups;
    private List<Exercise> listexercises;

    public ListData(int type, List<Group> groups, List<Exercise> exercises) {
        this.type = type;
        this.listgroups = groups;
        this.listexercises = exercises;
    }


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<Group> getListGroups() {
        return listgroups;
    }

    public void setGroups(List<Group> groups) {
        this.listgroups = groups;
    }

    public List<Exercise> getListExercises() {
        return listexercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.listexercises = exercises;
    }
}
