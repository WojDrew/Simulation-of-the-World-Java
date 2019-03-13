package Swiat.Organizmy.Rosliny;

import Swiat.Organizmy.*;
import Swiat.*;

public class BarszczSosnowskiego extends Roslina {
    public BarszczSosnowskiego(int x, int y, Swiat s){
        super(x,y,s,2,1,"BarszczSosnowskiego.jpg");
    }

    public void akcja()
    {
        OrganizmJPG o = sw.czyJestOrg(this.x + 1, this.y);
        if(o != null)
            sw.removeOrganizm(o);
        o = sw.czyJestOrg(this.x - 1, this.y);
        if(o != null)
            sw.removeOrganizm(o);
        o = sw.czyJestOrg(this.x + 1, this.y);
        if(o != null)
            sw.removeOrganizm(o);
        o = sw.czyJestOrg(this.x, this.y - 1);
        if(o != null)
            sw.removeOrganizm(o);
        o = sw.czyJestOrg(this.x, this.y + 1);
        if(o != null)
            sw.removeOrganizm(o);
        o = sw.czyJestOrg(this.x + 1, this.y + 1);
        if(o != null)
            sw.removeOrganizm(o);
        o = sw.czyJestOrg(this.x - 1, this.y + 1);
        if(o != null)
            sw.removeOrganizm(o);
        o = sw.czyJestOrg(this.x + 1, this.y - 1);
        if(o != null)
            sw.removeOrganizm(o);
        o = sw.czyJestOrg(this.x - 1, this.y - 1);
        if(o != null)
            sw.removeOrganizm(o);
    }

    public void kolizja(OrganizmJPG atakujacy)
    {
        super.kolizja(atakujacy);
        if(!sw.czyJestOrg(this.x,this.y) .getClass().equals( this))
            sw.removeOrganizm(atakujacy);
    }

}
