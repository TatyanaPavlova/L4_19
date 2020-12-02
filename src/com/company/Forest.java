package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Forest {
    private static Scanner in = new Scanner(System.in);

    private ArrayList<Insects> insects = new ArrayList<>();

    public void add (Insects insect)

    {

        insects.add(insect);

    }

    public void getList()

    {

        String AList ="Муравьи: ";

        String BList ="Бабочки: ";

        String CList ="Гусеницы: ";

        String MList ="Комары: ";

        for(Insects insect : insects){

            if ("Муравей".equals(insect.getType()))

            {

                AList += "\n\t" + insect.getInfo();

            }

            if ("Бабочка".equals(insect.getType()))

            {

                BList += "\n\t" + insect.getInfo();

            }

            if ("Гусеница".equals(insect.getType()))

            {

                CList += "\n\t" + insect.getInfo();

            }

            if ("Комар".equals(insect.getType()))

            {

                MList += "\n\t" + insect.getInfo();

            }

        }

        System.out.print(AList + "\n\n" + BList + "\n\n"+ CList + "\n\n" + MList);

    }

    public Insects searchInsect (String variety)

    {

        for(Insects insect : insects)

        {

            if(insect.getVariety().equals(variety))

                return insect;

        }

        return null;

    }

    public void deleteInsect (Insects insect)

    {

        insects.remove(insect);

        System.out.println("Насекомое поймано \n");

    }

    public boolean ffor(String str){

        Boolean s = false;

        for(Insects insect : insects){

            if(str.equals(insect.getVariety()))

                s = true;

        }

        return s;

    }
}
