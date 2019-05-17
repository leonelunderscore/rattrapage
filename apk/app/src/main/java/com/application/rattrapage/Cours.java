package com.application.rattrapage;

import android.os.Parcel;
import android.os.Parcelable;

public class Cours implements Parcelable {

    private int id;
    private String name;
    private int price;
    private String type;
    private String level;
    private String description;


    public Cours(){}

    public Cours(int id, String name, String description, int price, String type, String level) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
        this.level = level;
        this.description = description;
    }


    public Cours(Cours cours){
        if (cours != null){
            this.id = cours.id;
            this.name = cours.name;
            this.price = cours.price;
            this.type = cours.type;
            this.level = cours.level;
            this.description = cours.description;
        }
    }

    protected Cours(Parcel in) {
        id = in.readInt();
        name = in.readString();
        price = in.readInt();
        type = in.readString();
        level = in.readString();
        description = in.readString();
    }

    public static final Creator<Cours> CREATOR = new Creator<Cours>() {
        @Override
        public Cours createFromParcel(Parcel in) {
            return new Cours(in);
        }

        @Override
        public Cours[] newArray(int size) {
            return new Cours[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeInt(price);
        dest.writeString(type);
        dest.writeString(level);
        dest.writeString(description);
    }
}
