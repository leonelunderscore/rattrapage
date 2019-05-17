package com.application.rattrapage;

public class Apprenant {

    private int id;
    private String name;

    public Apprenant(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Apprenant(Apprenant apprenant){
        if(apprenant != null){
            this.id = apprenant.id;
            this.name = apprenant.name;
        }
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
