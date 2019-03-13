package Swiat.Organizmy.Rosliny;

import Swiat.Organizmy.*;
import Swiat.*;

public class Mlecz extends Roslina {
    public Mlecz(int x, int y, Swiat s){
        super(x,y,s,2,1,"Mlecz.jpg");
    }

    public void akcja()
    {
        for(int i = 0; i <3; i++)
            super.akcja();
    }

}
