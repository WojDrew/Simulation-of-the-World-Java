package Swiat.Organizmy.Zwierzeta;

import Swiat.Organizmy.*;
import Swiat.*;

public class Lis extends Zwierze {
    public Lis(int x, int y, Swiat s){
        super(x,y,s,3,7,"lis.jpg");
    }
    public void akcja() {
        this.losuj();
        OrganizmJPG o = sw.czyJestOrg(this.x_t, this.y_t);
        if (o == null) {
            this.x = this.x_t;
            this.y = this.y_t;
        }
        else{
            int i = 0;
            while(o != null && this.sila > o.getSila() && i < 10)
            {
                this.losuj();
                o = sw.czyJestOrg(this.x_t, this.y_t);
                i++;
            }
            if(o != null)
            {
                o.kolizja(this);
            }
            else
            {
                this.x = this.x_t;
                this.y = this.y_t;
            }
        }
    }
}
