package Swiat;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class PopClickListener extends MouseAdapter {
    private Swiat sw;
    private PopUpDemo menu;
    public PopClickListener(Swiat s)
    {
        sw = s;
    }
    public void mousePressed(MouseEvent e){
        if (e.isPopupTrigger())
            doPop(e);
        int x = e.getX()/50;
        int y = e.getY()/50;
        if(e.getX()%50 > 25)
            x++;
        if(e.getY()%50 > 25)
            y++;
        sw.setXMenu(x);
        sw.setYMenu(y);
    }

    public void mouseReleased(MouseEvent e){
        if (e.isPopupTrigger())
            doPop(e);
    }

    private void doPop(MouseEvent e){
        menu = new PopUpDemo(sw);
        menu.show(e.getComponent(), e.getX(), e.getY());
    }
    public PopUpDemo getMenu()
    {
        return menu;
    }
}
