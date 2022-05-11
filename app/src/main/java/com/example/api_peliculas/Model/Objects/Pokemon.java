package com.example.api_peliculas.Model.Objects;

public class Pokemon{
    private String name;
    private String url;
    private String number;

    public String getNumber() {
        String[] urlPartes = url.split("/");
        return urlPartes[urlPartes.length - 1];
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
