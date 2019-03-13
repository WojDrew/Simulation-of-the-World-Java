package Swiat.Organizmy;

import Swiat.*;
import Swiat.Organizmy.Rosliny.*;

import java.util.Random;

public class Roslina extends OrganizmJPG {

    public Roslina(){

    }
    public Roslina(int x, int y, Swiat s, int sl, int i, String n){
        super(n,x,y,s,sl,i);
    }
    public void akcja(){
        wiek++;
        Random generator = new Random();
        int szansa = generator.nextInt(100);
        int a = 0;

        if (szansa < 10 ) {
            if (this.wokol()) {
                int x_t = this.x, y_t = this.y;
                while (a == 0) {
                    int n = generator.nextInt(4);
                    if (n == 0 && this.x < sw.getSizeX() && sw.czyJestOrg(this.x + 1, this.y) == null) {
                        x_t++;
                        a++;
                    } else if (n == 1&& this.x > 1 && sw.czyJestOrg(this.x - 1, this.y) == null) {
                        x_t--;
                        a++;
                    } else if (n == 2 && this.y < sw.getSizeY() && sw.czyJestOrg(this.x, this.y + 1) == null) {
                        y_t++;
                        a++;
                    } else if (n == 3 && this.y > 1 && sw.czyJestOrg(this.x, this.y - 1) == null) {
                        y_t--;
                        a++;
                    }
                }
                OrganizmJPG o = null;
                if (this instanceof Trawa) {
                    o = new Trawa(x_t, y_t, sw);
                    sw.setText("Trawa sie rozmnozyla na polu " + x_t + " "+ y_t + "\n");
                }
                else if (this instanceof Mlecz) {
                    o = new Mlecz(x_t, y_t, sw);
                    sw.setText("Mlecz sie rozmnozyl na polu " + x_t + " "+ y_t + "\n");
                }
                else if (this instanceof Guarana) {
                    o = new Guarana(x_t, y_t, sw);
                    sw.setText("Guarana sie rozmnozyla na polu " + x_t + " "+ y_t + "\n");
                }
                else if (this instanceof WilczeJagody) {
                    o = new WilczeJagody(x_t, y_t, sw);
                    sw.setText("Wilcze Jagody sie rozmnozyly na polu " + x_t + " "+ y_t + "\n");
                }
                else if (this instanceof BarszczSosnowskiego) {
                    o = new BarszczSosnowskiego(x_t, y_t, sw);
                    sw.setText("Barszcz Sosnowskiego sie rozmnozyl na polu " + x_t + " " + y_t + "\n");
                }
                sw.addOrganizm(o);
            }
        }
    }
    public void kolizja(OrganizmJPG atakujacy){
        if(this.getSila() > atakujacy.getSila())
            sw.removeOrganizm(atakujacy);
        else {
            atakujacy.setX(this.getX());
            atakujacy.setY(this.getY());
            sw.removeOrganizm(this);
        }
    }
}
