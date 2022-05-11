package com.example.api_peliculas.Model.Objects;

public class Stats {
    private String base_stat;
    private String effort;
    private StatsObject stat;

    public String getBase_stat() {
        return base_stat;
    }

    public void setBase_stat(String base_stat) {
        this.base_stat = base_stat;
    }

    public String getEffort() {
        return effort;
    }

    public void setEffort(String effort) {
        this.effort = effort;
    }

    public StatsObject getStat() {
        return stat;
    }

    public void setStat(StatsObject stat) {
        this.stat = stat;
    }
}
