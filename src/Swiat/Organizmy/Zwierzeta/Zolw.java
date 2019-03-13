package Swiat.Organizmy.Zwierzeta;

import Swiat.Organizmy.*;
import Swiat.*;

import java.util.Random;

public class Zolw extends Zwierze {
    public Zolw(int x, int y, Swiat s){
        super(x,y,s,2,1,"Zolw.jpg");
    }
    public void akcja()
    {
        Random generator = new Random();
        int n = generator.nextInt(100);
        if(n >= 75)
            super.akcja();
    }
    public void kolizja(OrganizmJPG atakujacy)
    {
        if(atakujacy.getSila() > 5)
            super.kolizja(atakujacy);
    }
}
