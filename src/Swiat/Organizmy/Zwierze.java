package Swiat.Organizmy;
import java.awt.*;
import java.util.Random;

import Swiat.*;
import Swiat.Organizmy.Zwierzeta.*;

public class Zwierze extends OrganizmJPG {

    public Zwierze(){

    }
    public Zwierze(int x, int y, Swiat s, int sl, int i, String n){
        super(n,x,y,s,sl,i);
    }
    public void akcja(){
        wiek++;
        this.losuj();
        OrganizmJPG o = sw.czyJestOrg(x_t, y_t);
        if (o != null)
        {
            o.kolizja(this);
        }
        else
        {
            this.x = x_t;
            this.y = y_t;
        }
    }
    public void kolizja(OrganizmJPG atakujacy){
        if(atakujacy.getClass().equals(this.getClass())) {
            if(this.wokol()) {
                int a = 0;
                int x_t = this.x, y_t = this.y;
                Random generator = new Random();
                while (a == 0) {
                    int n = generator.nextInt(4);
                    if (n == 0 && this.x < sw.getSizeX()  && sw.czyJestOrg(this.x + 1, this.y) == null) {
                        x_t++;
                        a++;
                    }
                    else if (n == 1 && this.x > 1  && sw.czyJestOrg(this.x - 1, this.y) == null) {
                        x_t--;
                        a++;
                    }
                    else if (n == 2 && this.y < sw.getSizeY()  && sw.czyJestOrg(this.x, this.y + 1) == null) {
                        y_t++;
                        a++;
                    }
				    else if (n == 3 && this.y > 1 && sw.czyJestOrg(this.x, this.y - 1) == null) {
                        y_t--;
                        a++;
                    }
                }
                OrganizmJPG o = null;
                if(this instanceof Lis)
                    o = new Lis(x_t,y_t,sw);
                else if(this instanceof Wilk)
                    o = new Wilk(x_t,y_t,sw);
                else if(this instanceof Zolw)
                    o = new Zolw(x_t,y_t,sw);
                else if(this instanceof Antylopa)
                    o = new Antylopa(x_t,y_t,sw);
                else if(this instanceof Owca)
                    o = new Owca(x_t,y_t,sw);
                else if(this instanceof Czlowiek)
                    o = new Czlowiek(x_t,y_t,sw);
                sw.addOrganizm(o);
            }
        }
        else{
            if(this.getSila() > atakujacy.getSila())
                sw.removeOrganizm(atakujacy);
            else {
                atakujacy.setX(this.getX());
                atakujacy.setY(this.getY());
                sw.removeOrganizm(this);
            }
        }
    }
}
