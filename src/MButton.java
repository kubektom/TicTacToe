import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Kuba on 2018-03-04.
 */
public class MButton extends JToggleButton {//
    static int x=0;
        String flag="";
        boolean isEnabled=true;
    public MButton(){
        super();
        this.setSize(100,100);
        this.setBackground(new Color(255,255,255));
        this.addMouseListener(new MouseListener() {//Changing mouse cursor
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if(isEnabled==true)
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        x++;
        }



}
