package com.company;

public class Caterpillar extends Insects {
    private String color;

    public Caterpillar(int countFeet, int countEyes, String wings, String color, String variety){

        super(countFeet,countEyes,wings,color, variety);

        this.color = color;

        setType("Гусеница");

    }


    @Override

    public String getInfo(){

        return "\n\tНасекомое: " + getType() + "\n\tКоличество глаз: " + getEyes() + "\n\tКоличество ног: " + getFeet() +"\n\tНаличие крыльев: " + getWings()+"\n\tЦвет: " + getColor()+"\n\t Разновидность: " + getVariety();

    }

    @Override

    public void meeting() {

        System.out.println("Вы находитесь в лесу. Перед Вами насекомое " + getType()

                + "\n\t Количесто лапок: " + super.getFeet()

                + "\n\t Количество глаз" + super.getEyes()

                + "\n\t Наличие крыльев: " + super.getWings()

                + "\n\t Цвет " + super.getColor()

                + "\n\t Разновидность: " + super.getVariety());

    }
}
