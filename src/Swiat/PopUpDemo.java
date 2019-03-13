package Swiat;
import javax.swing.*;

class PopUpDemo extends JPopupMenu {
    private JMenuItem owca;
    private JMenuItem wilk;
    private JMenuItem lis;
    private JMenuItem zolw;
    private JMenuItem antylopa;
    private JMenuItem trawa;
    private JMenuItem mlecz;
    private JMenuItem wilczeJagody;
    private JMenuItem guarana;
    private JMenuItem barszcz;

    public JMenuItem getOwca() {
        return owca;
    }

    public JMenuItem getWilk() {
        return wilk;
    }

    public JMenuItem getLis() {
        return lis;
    }

    public JMenuItem getZolw() {
        return zolw;
    }

    public JMenuItem getAntylopa() {
        return antylopa;
    }

    public JMenuItem getTrawa() {
        return trawa;
    }

    public JMenuItem getMlecz() {
        return mlecz;
    }

    public JMenuItem getWilczeJagody() {
        return wilczeJagody;
    }

    public JMenuItem getGuarana() {
        return guarana;
    }

    public JMenuItem getBarszcz() {
        return barszcz;
    }

    public PopUpDemo(Swiat sw){
        owca = new JMenuItem("Owca");
        owca.addActionListener(sw);
        add(owca);
        wilk = new JMenuItem("Wilk");
        wilk.addActionListener(sw);
        add(wilk);
        zolw = new JMenuItem("Zolw");
        zolw.addActionListener(sw);
        add(zolw);
        lis = new JMenuItem("Lis");
        lis.addActionListener(sw);
        add(lis);
        antylopa = new JMenuItem("Antylopa");
        antylopa.addActionListener(sw);
        add(antylopa);
        trawa = new JMenuItem("Trawa");
        trawa.addActionListener(sw);
        add(trawa);
        mlecz = new JMenuItem("Mlecz");
        mlecz.addActionListener(sw);
        add(mlecz);
        wilczeJagody = new JMenuItem("WilczeJagody");
        wilczeJagody.addActionListener(sw);
        add(wilczeJagody);
        guarana = new JMenuItem("Guarana");
        guarana.addActionListener(sw);
        add(guarana);
        barszcz = new JMenuItem("BarszczSosnowskiego");
        barszcz.addActionListener(sw);
        add(barszcz);
    }
}