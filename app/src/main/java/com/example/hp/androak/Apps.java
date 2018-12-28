package com.example.hp.androak;

public class Apps {

    private String description;
    private String link;
    private String name;

    public Apps(){

    }

    public Apps(String description, String link,String name) {
        this.description = description;
        this.link = link;
        this.name=name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String desciption){
        this.description=desciption;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

