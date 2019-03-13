package Swiat;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.*;

public class Okno extends JFrame implements ActionListener {
    private JTextField textF_1;
    private JTextField textF_2;
    private JButton Button;
    private JPanel jp;
    private Swiat sw;
    public Okno(Swiat s){
        sw = s;
        setTitle("Wojciech Drewek 171838");
        setResizable(false);
        setSize(400, 100);
        getContentPane().setBackground(Color.green);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Button = new JButton();
        Button.setText("Nowa Gra");
        Button.addActionListener(this);
        textF_1 = new JTextField("szerokosc");
        textF_2 = new JTextField("wysokosc");
        jp = new JPanel();
        jp.add(Button);
        jp.add(textF_1);
        jp.add(textF_2);
        add(jp);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent akcja) {
        if (akcja.getSource() == Button) {
            sw.setSizeX(Integer.parseInt(textF_1.getText()));
            sw.setSizeY(Integer.parseInt(textF_2.getText()));
            sw.stworzGre();
        }

    }
    public JTextField getTextF1(){
        return textF_1;
    }
    public JTextField getTextF2(){
        return textF_2;
    }
    public JButton getButton(){
        return Button;
    }

}
