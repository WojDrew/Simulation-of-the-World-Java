package Swiat;

import java.lang.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public abstract class OrganizmJPG extends JPanel implements Comparable<OrganizmJPG>{
    private BufferedImage image;
    protected int sila;
    protected int inicjatywa;
    protected int x, y;
    protected int x_t, y_t;
    protected int wiek;
    protected Swiat sw;

    public OrganizmJPG(){

    }

    public OrganizmJPG(String nazwa, int x, int y, Swiat s, int sl, int i ) {
        super();
        this.x = x;
        this.y = y;
        this.x_t = x;
        this.y_t = y;
        this.sw = s;
        this.sila = sl;
        this.inicjatywa = i;
        this.wiek = 0;
        File imageFile = new File("Pliki/"+nazwa);
        try {
            image = ImageIO.read(imageFile);
        } catch (IOException e) {
            System.err.println("Blad odczytu obrazka");
            e.printStackTrace();
        }
        Dimension dimension = new Dimension(image.getWidth(), image.getHeight());
        setPreferredSize(dimension);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image, this.x*50 - 50, this.y*50 - 50, this);
    }

    public boolean wokol()
    {
        if ((x + 1 <= sw.getSizeX() && sw.czyJestOrg(x + 1, y) == null) || (x - 1 > 0 && sw.czyJestOrg(x - 1, y) == null) || (y + 1 <= sw.getSizeX()  && sw.czyJestOrg(x, y + 1) == null) || (y - 1 > 0 && sw.czyJestOrg(x, y - 1) == null))
        {
            return true;
        }
        else
            return false;
    }

    public void losuj()
    {
        this.x_t = this.x;
        this.y_t = this.y;
        Random generator = new Random();
        int a = 0;
        while (a == 0)
        {
            int n = generator.nextInt(4);
            if (n == 0 && this.x < sw.getSizeX())
            {
                x_t++;
                a++;
            }
		    else if (n == 1 && this.x > 1)
            {
                x_t--;
                a++;
            }
		    else if (n == 2 && this.y < sw.getSizeY())
            {
                y_t++;
                a++;
            }
		    else if (n == 3 && this.y > 1)
            {
                y_t--;
                a++;
            }
        }
    }

    public void boostStr(int s)
    {
        for(int i = 0; i < s; i++)
            this.sila++;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public int getSila(){
        return sila;
    }
    public int getInicjatywa(){
        return inicjatywa;
    }
    public int getWiek(){
        return sila;
    }
    @Override
    public int compareTo(OrganizmJPG o) {

        if(this.inicjatywa == o.getInicjatywa())
            return o.getWiek() - this.wiek;
        else
            return o. getInicjatywa() - this.inicjatywa;
    }

    public abstract void akcja();
    public abstract void kolizja(OrganizmJPG atakujacy);
}
