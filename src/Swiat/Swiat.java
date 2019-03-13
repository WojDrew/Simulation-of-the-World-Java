package Swiat;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
import Swiat.Organizmy.Zwierzeta.*;
import Swiat.Organizmy.Rosliny.*;
import java.util.Random;
import java.util.Collections;


public class Swiat extends JFrame implements KeyListener,ActionListener {
    private int size_x, size_y;
    private int c_x, c_y, tarcza, x_menu, y_menu;
    private Okno okno_pom;
    private Vector<OrganizmJPG> org;
    private OknoText oknotext;
    private String s;
    PopClickListener pop;

    public Swiat() {
        super("Wojciech Drewek 171838");
        c_x = 0;
        c_y = 0;
        tarcza = 0;
        s = "";
        okno_pom = new Okno(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(false);
        addKeyListener(this);
        org = new Vector();
        pop = new PopClickListener(this);
        this.addMouseListener(pop);
    }

    public OrganizmJPG czyJestOrg(int x,int y) {

        for (int i = 0; i < org.size(); i++)
            if (org.get(i).getX() == x && org.get(i).getY() == y)
                return org.get(i);
        return null;
    }

    public void addOrganizm(OrganizmJPG o){
        org.add(o);
        add(o);
        revalidate();
    }

    public void removeOrganizm(OrganizmJPG o){
        org.remove(o);
        remove(o);
        revalidate();
    }

    public void stworzGre(){
        okno_pom.setVisible(false);
        setSize(size_x*50 + 25, size_y*50 + 50);
        getContentPane().setBackground(Color.white);
        setVisible(true);

        oknotext = new OknoText(this);

        Random generator = new Random();
        int x = 1, y = 1 ;
        int m = (size_x*size_y / 11)*3;
        int n = (size_x*size_y / 11)*3/11;
        OrganizmJPG l = null;
        for (int i = 0; i < m-1; i++)
        {
            if (i < n)
            {
                while (czyJestOrg(x, y) != null)
                {
                    x = generator.nextInt(size_x) + 1;
                    y = generator.nextInt(size_y) + 1;
                }
                l = new Lis(x, y, this);

            }
            else if(i < n*2)
            {
                while (czyJestOrg(x, y) != null)
                {
                    x = generator.nextInt(size_x) + 1;
                    y = generator.nextInt(size_y) + 1;
                }
                l = new Wilk(x, y, this);
            }
            else if (i < n * 3)
            {
                while (czyJestOrg(x, y) != null)
                {
                    x = generator.nextInt(size_x) + 1;
                    y = generator.nextInt(size_y) + 1;
                }
                l = new Owca(x, y, this);
            }
            else if (i < n * 4)
            {
                while (czyJestOrg(x, y) != null)
                {
                    x = generator.nextInt(size_x) + 1;
                    y = generator.nextInt(size_y) + 1;
                }
                l = new Zolw(x, y, this);

            }
            else if (i < n * 5)
            {
                while (czyJestOrg(x, y) != null)
                {
                    x = generator.nextInt(size_x) + 1;
                    y = generator.nextInt(size_y) + 1;
                }
                l = new Antylopa(x, y, this);
            }
            else if (i < n * 6)
            {
                while (czyJestOrg(x, y) != null)
                {
                    x = generator.nextInt(size_x) + 1;
                    y = generator.nextInt(size_y) + 1;
                }
                l = new BarszczSosnowskiego(x, y, this);
            }
            else if (i < n * 7)
            {
                while (czyJestOrg(x, y) != null)
                {
                    x = generator.nextInt(size_x) + 1;
                    y = generator.nextInt(size_y) + 1;
                }
                l = new Mlecz(x, y, this);
            }
            else if (i < n * 8)
            {
                while (czyJestOrg(x, y) != null)
                {
                    x = generator.nextInt(size_x) + 1;
                    y = generator.nextInt(size_y) + 1;
                }
                l = new Guarana(x, y, this);
            }
            else if (i < n * 9)
            {
                while (czyJestOrg(x, y) != null)
                {
                    x = generator.nextInt(size_x) + 1;
                    y = generator.nextInt(size_y) + 1;
                }
                l = new WilczeJagody(x, y, this);
            }
            else
            {
                while (czyJestOrg(x, y) != null)
                {
                    x = generator.nextInt(size_x) + 1;
                    y = generator.nextInt(size_y) + 1;
                }
                l = new Trawa(x, y, this);
            }
            if(i == m - 2) {
                while (czyJestOrg(x, y) != null) {
                    x = generator.nextInt(size_x) + 1;
                    y = generator.nextInt(size_y) + 1;
                }
                l = new Czlowiek(x, y, this);
            }
            org.add(l);
        }
        for (int i = 0; i < org.size(); i++) {
            add(org.get(i));
            revalidate();
        }
    }


    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_T) {
            wykonaj_Ture();
        }
        c_x = 0;
        c_y = 0;
        if (e.getKeyCode() == KeyEvent.VK_LEFT ) {
            this.c_x--;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT ) {
            this.c_x++;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP ) {
            this.c_y--;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN ) {
            this.c_y++;
        }
        if (e.getKeyCode() == KeyEvent.VK_A )
        {
            tarcza = 1;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_T) {

        }
    }
    @Override
    public void keyTyped(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_ENTER) {

        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {

        }
    }

    public void rysujSwiat() {
        for (int i = 0; i < org.size(); i++) {
            remove(org.get(i));
            add(org.get(i));
            revalidate();
            repaint();
        }

    }

    public void wykonaj_Ture() {
        Collections.sort(org);
        for (int i = 0; i < org.size(); i++) {
            org.get(i).akcja();
        }
        this.oknotext.addText(this.s);
        s = "";
        this.rysujSwiat();
    }
    @Override
    public void actionPerformed(ActionEvent akcja)
    {
        OrganizmJPG o = null;
        if(akcja.getSource() == pop.getMenu().getLis())
        {
           o = new Lis(x_menu,y_menu,this);
        }
        else if(akcja.getSource() == pop.getMenu().getWilk())
        {
            o = new Wilk(x_menu,y_menu,this);
        }
        else if(akcja.getSource() == pop.getMenu().getOwca())
        {
            o = new Owca(x_menu,y_menu,this);
        }
        else if(akcja.getSource() == pop.getMenu().getZolw())
        {
            o = new Zolw(x_menu,y_menu,this);
        }
        else if(akcja.getSource() == pop.getMenu().getAntylopa())
        {
            o = new Antylopa(x_menu,y_menu,this);
        }
        else if(akcja.getSource() == pop.getMenu().getBarszcz())
        {
            o = new BarszczSosnowskiego(x_menu,y_menu,this);
        }
        else if(akcja.getSource() == pop.getMenu().getGuarana())
        {
            o = new Guarana(x_menu,y_menu,this);
        }
        else if(akcja.getSource() == pop.getMenu().getMlecz())
        {
            o = new Mlecz(x_menu,y_menu,this);
        }
        else if(akcja.getSource() == pop.getMenu().getTrawa())
        {
            o = new Trawa(x_menu,y_menu,this);
        }
        else if(akcja.getSource() == pop.getMenu().getWilczeJagody())
        {
            o = new WilczeJagody(x_menu,y_menu,this);
        }
        addOrganizm(o);
        rysujSwiat();
    }

    public void setText(String s)
    {
        this.s += s;
    }

    public void setSizeX(int x){
        this.size_x = x;
    }

    public void setSizeY(int y){
        this.size_y = y;
    }

    public int getSizeX(){
        return this.size_x;
    }

    public int getSizeY(){
        return this.size_y;
    }
    public int getCX(){
        return this.c_x;
    }

    public int getCY(){
        return this.c_y;
    }
    public int getTarcza(){
        return this.tarcza;
    }
    public void setTarcza(int t){
        this.tarcza = t;
    }
    public void setXMenu(int t){
        this.x_menu = t;
    }
    public void setYMenu(int t){
        this.y_menu = t;
    }
}
