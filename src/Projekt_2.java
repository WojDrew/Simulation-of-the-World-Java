import Swiat.Swiat;
import java.awt.EventQueue;

public class Projekt_2 {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Swiat();
            }
        });
    }

}
