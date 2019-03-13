package Swiat.Organizmy.Zwierzeta;

import Swiat.Organizmy.*;
import Swiat.*;

import java.util.Random;

public class Antylopa extends Zwierze {
    public Antylopa(int x, int y, Swiat s){
        super(x,y,s,2,1,"Antylopa.jpg");
    }
    public void akcja() {
        this.losuj();
        super.akcja();
    }
    public void kolizja(OrganizmJPG atakujacy){
        Random generator = new Random();
        int n = generator.nextInt(100);
        if(n < 50)
            this.kolizja(atakujacy);
        else
        {
            if(this.wokol()) {
                OrganizmJPG o = sw.czyJestOrg(this.x_t, this.y_t);
                while (o != null) {
                    this.losuj();
                    o = sw.czyJestOrg(this.x_t, this.y_t);
                }
                this.x = this.x_t;
                this.y = this.y_t;
            }
            else
            {
                this.kolizja(atakujacy);
            }
        }
    }
}
