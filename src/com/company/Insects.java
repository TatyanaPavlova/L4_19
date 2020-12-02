package com.company;

public abstract class Insects {
    private int countFeet;

    private int countEyes;

    private String wings;

    private String type;

    private String variety;
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Insects(int countFeet, int countEyes, String wings, String color, String variety){

        this.countEyes = countEyes;

        this.countFeet = countFeet;

        this.variety = variety;
        this.color = color;

        this.wings = wings;

    }

    public int getFeet(){

        return this.countFeet;

    }

    public void setFeet(int countFeet){

        this.countFeet = countFeet;

    }

    public int getEyes(){

        return this.countEyes;

    }

    public void setEyes(int countEyes){

        this.countEyes = countEyes;

    }

    public String getWings(){

        return this.wings;

    }

    public void setWings(String wings){

        this.wings = wings;

    }

    public String getInfo(){

        return "\n\tКоличество глаз: " + getEyes() + "\n\tКоличество ног: " + getFeet();

    }

    public String getType(){return this.type;}

    public void setType(String view){

        this.type = view;

    }

    public String getVariety(){ return this.variety;}

    public void setVariety(String variety){

        this.variety = variety;

    }

    abstract public void meeting();
}
