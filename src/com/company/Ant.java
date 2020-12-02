package com.company;

public class Ant extends Insects implements java.io.Serializable {


    public Ant(int countFeet, int countEyes, String wings, String color, String variety){

        super(countFeet,countEyes,wings, color, variety);


        setType("Муравей");

    }



    @Override

    public String getInfo(){

        return "\n\tНасекомое: " + getType() + "\n\tКоличество глаз: " + getEyes() + "\n\tКоличество ног: " + getFeet()+ "\n\tНаличие крыльев: " + getWings() + "\n\tЦвет: " + getColor()+ "\n\t Разновидность: " + getVariety();

    }

    @Override

    public void meeting(){

        System.out.println("Вы находитесь в лесу. Перед Вами насекомое " + getType()

                + "\n\t Количесто лапок: " + super.getFeet()

                + "\n\t Количество глаз" + super.getEyes()

                + "\n\t Наличие крыльев: " + super.getWings()

                + "\n\t Цвет " + super.getColor()

                + "\n\t Разновидность: " + super.getVariety());

    }
}
