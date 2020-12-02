package com.company;

public class Mosquito extends Insects {

    public Mosquito(int countFeet, int countEyes,String wings,String color, String variety){

        super(countFeet,countEyes,wings, color, variety);

        setType("Комар");

    }


    @Override

    public String getInfo(){

        return "\n\tНасекомое: " + getType() + "\n\tКоличество глаз: " + getEyes() + "\n\tКоличество ног: " + getFeet() +"\n\tНаличие крыльев: " + getWings()+"\n\tЦвет крыльев: " + getColor() + "\n\t Разновидность: " + getVariety();

    }

    @Override

    public void meeting() {

        System.out.println("Вы находитесь в лесу. Перед Вами насекомое " + getType()

                + "\n\t Количесто лапок: " + super.getFeet()

                + "\n\t Количество глаз" + super.getEyes()

                + "\n\t Наличие крыльев: " + super.getWings()

                +  "\n\tЦвет крыльев: " + super.getColor()

                + "\n\t Разновидность: " + super.getVariety());

    }
}
