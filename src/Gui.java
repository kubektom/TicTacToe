import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Created by Kuba on 2018-03-03.
 */
public class Gui extends JFrame {


    public Gui(){
        super("TicTacToe");
        this.setSize(400,400);
        this.setLocation(200,200);
        this.initComponents();
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);

    }
    void initComponents(){//Setting components

            buttonsPanel=new JPanel(new GridLayout(3,3));
            buttonsPanel.setSize(400,400);
            newGamePanel=new JPanel();
            statusPanel=new JPanel();
            status2Panel=new JPanel();
            newGameButton =new JButton("Nowa Gra");
            status=new JLabel("Teraz rusza się: ");
            status2=new JLabel();
            status2.setIcon(new ImageIcon("small_O.png"));
            newGamePanel.setLayout(new GridLayout(1,2));
            status2Panel.setLayout(new FlowLayout(FlowLayout.LEFT));
            statusPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            newGamePanel.add(statusPanel);
            newGamePanel.add(status2Panel);
            newGamePanel.setSize(400, 20);
            statusPanel.add(newGameButton);
            status2Panel.add(status);
            status2Panel.add(status2);
            //Reaction OnClick on newGameButton
            newGameButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    newGameF();
                }
            });
        for(int i=0; i<9;i++){

            try {
                tab[i]=new MButton();
                tab[i].flag=""+i;
                tab[i].addActionListener(new MButtonListener());
                tab[i].setBounds(0,0,100,100);
                tab[i].setSize(100,100);
                tab[i].setContentAreaFilled(false);
                buttonsPanel.add(tab[i]);
            }

            catch(NullPointerException e)
            {
                System.out.println(e.getMessage());
            }
        }
        this.getContentPane().add(buttonsPanel,BorderLayout.CENTER);
        this.getContentPane().add(newGamePanel,BorderLayout.SOUTH);

        //
    }
    //Globals##############################################
    private JPanel buttonsPanel;
    private JPanel newGamePanel;
    private JPanel statusPanel;
    private JPanel status2Panel;
    private MButton tab[]=new MButton[9];
    private JButton newGameButton;
    private String whichMove="O";
    private JLabel status;
    private JLabel status2;

//##############################################################
    private class MButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            for(int i=0; i<tab.length;i++){
                tab[i].isEnabled=false;
            }
            if(!((MButton)e.getSource()).flag.equals("O" ) && !((MButton)e.getSource()).flag.equals("X")) {


                ((MButton) e.getSource()).removeActionListener(((MButton) e.getSource()).getActionListeners()[0]);
                ((MButton) e.getSource()).setContentAreaFilled(false);
                ((MButton) e.getSource()).setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                ((MButton) e.getSource()).setFocusable(false);
                ((MButton) e.getSource()).isEnabled=false;
                if(whichMove=="O") {
                    whichMove = "X";
                    ((MButton) e.getSource()).setIcon(new ImageIcon("O.png"));
                    status2.setIcon(new ImageIcon("small_X.png"));

                }
                else{
                    whichMove = "O";
                    ((MButton) e.getSource()).setIcon(new ImageIcon("X.png"));
                    status2.setIcon(new ImageIcon("small_O.png"));

                }
                ((MButton) e.getSource()).flag=whichMove;
                checkIfWin();

                for(int i=0; i<tab.length;i++){
                    tab[i].isEnabled=true;
                }
            }

        }
    }
    //Conditions to win
    public void checkIfWin(){

        if(tab[0].flag.equals(tab[1].flag) && tab[0].flag.equals(tab[2].flag) ||
        tab[3].flag.equals(tab[4].flag) && tab[3].flag.equals(tab[5].flag) ||
        tab[6].flag.equals(tab[7].flag) && tab[6].flag.equals(tab[8].flag) ||
        tab[0].flag.equals(tab[3].flag) && tab[0].flag.equals(tab[6].flag) ||
        tab[1].flag.equals(tab[4].flag) && tab[1].flag.equals(tab[7].flag) ||
        tab[2].flag.equals(tab[5].flag) && tab[2].flag.equals(tab[8].flag) ||
        tab[0].flag.equals(tab[4].flag) && tab[0].flag.equals(tab[8].flag) ||
        tab[2].flag.equals(tab[4].flag) && tab[2].flag.equals(tab[6].flag)) {
            if (whichMove == "O")
                JOptionPane.showMessageDialog(buttonsPanel, "Wygrał krzyżyk");
            else
                JOptionPane.showMessageDialog(buttonsPanel, "Wygrało kółko");

            newGameF();
        }//Conditions to draw
        else{
            if((tab[0].flag.equals("O") || tab[0].flag.equals("X")) &&
            (tab[1].flag.equals("O") || tab[1].flag.equals("X")) &&
            (tab[2].flag.equals("O") || tab[2].flag.equals("X")) &&
            (tab[3].flag.equals("O") || tab[3].flag.equals("X")) &&
            (tab[4].flag.equals("O") || tab[4].flag.equals("X")) &&
            (tab[5].flag.equals("O") || tab[5].flag.equals("X")) &&
            (tab[6].flag.equals("O") || tab[6].flag.equals("X")) &&
            (tab[7].flag.equals("O") || tab[7].flag.equals("X")) &&
            (tab[8].flag.equals("O") || tab[8].flag.equals("X")) ) {
                JOptionPane.showMessageDialog(buttonsPanel, "Remis");
                newGameF();
            }
        }
    }
    //Resetting the board
    public void newGameF() {
            for(int i=0; i<tab.length;i++){
            tab[i].addActionListener(new MButtonListener());
            tab[i].flag=""+i;
            tab[i].isEnabled=true;
            tab[i].setIcon(null);
            tab[i].setContentAreaFilled(false);
            tab[i].setBackground(new Color(255,255,255));
        }

    }
}
