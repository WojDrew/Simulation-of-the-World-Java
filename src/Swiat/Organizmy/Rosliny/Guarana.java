package Swiat.Organizmy.Rosliny;

import Swiat.Organizmy.*;
import Swiat.*;

public class Guarana extends Roslina {
    public Guarana(int x, int y, Swiat s){
        super(x,y,s,2,1,"Guarana.jpg");
    }

    public void kolizja(OrganizmJPG atakujacy)
    {
        if(this.getSila() < atakujacy.getSila())
        {
            atakujacy.boostStr(3);
        }
        super.kolizja(atakujacy);
    }
}