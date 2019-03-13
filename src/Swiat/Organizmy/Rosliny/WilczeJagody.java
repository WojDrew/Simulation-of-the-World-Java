package Swiat.Organizmy.Rosliny;

import Swiat.Organizmy.*;
import Swiat.*;

public class WilczeJagody extends Roslina {
    public WilczeJagody(int x, int y, Swiat s){
        super(x,y,s,2,1,"WilczeJagody.jpg");
    }

    public void kolizja(OrganizmJPG atakujacy)
    {
        super.kolizja(atakujacy);
        if(!sw.czyJestOrg(this.x,this.y) .getClass().equals( this))
            sw.removeOrganizm(atakujacy);
    }

}
