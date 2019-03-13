package Swiat;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.*;

public class OknoText extends JFrame{
    private JTextArea text;
    private JPanel jp;
    private Swiat sw;
    public OknoText(Swiat s){
        sw = s;
        setTitle("Wojciech Drewek 171838");
        setResizable(false);
        setSize(400, 100);
        getContentPane().setBackground(Color.green);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        text = new JTextArea();
        text.setLineWrap(true);
        text.setBackground(Color.BLACK);
        text.setFont(new Font("Lucida Console", Font.PLAIN, 13));
        text.setForeground(Color.GREEN);
        text.setBounds(10, 57, 414, 383);
        add(text);

       /* jp = new JPanel();
        jp.add(Button);
        jp.add(textF_1);
        jp.add(textF_2);
        add(jp);*/
        setVisible(true);
    }

    public void addText(String s)
    {
        text.setText(s);
        //revalidate();
    }
}
