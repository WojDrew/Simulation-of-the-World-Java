package Swiat.Organizmy.Zwierzeta;

import Swiat.Organizmy.*;
import Swiat.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Czlowiek extends Zwierze{
    private int tarcza;
    public Czlowiek(int x, int y, Swiat s){
        super(x,y,s,2,1,"Czlowiek.jpg");
        tarcza = 0;
    }
    public void akcja() {
        if (sw.getCX() == -1 && this.x > 1) {
            this.x--;
        }
        else if (sw.getCX() == 1 && this.x < sw.getSizeX()) {
            this.x++;
        }
        else if (sw.getCY() == -1 && this.y > 1) {
            this.y--;
        }
        else if (sw.getCY() == 1 && this.y < sw.getSizeY()) {
            this.y++;

        }
    }
    public void kolizja(OrganizmJPG atakujacy)
    {
        if (sw.getTarcza() == 1)
            tarcza++;
        if(sw.getTarcza() == 1 && tarcza < 5)
        {

        }
        else
        {
            super.kolizja(atakujacy);
        }
        if(tarcza == 10)
        {
            tarcza = 0;
            sw.setTarcza(0);
        }

    }
}