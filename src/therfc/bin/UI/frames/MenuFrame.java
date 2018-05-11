package therfc.bin.UI.frames;

import javafx.beans.property.ListPropertyBase;
import therfc.bin.IO.Controller;
import therfc.bin.IO.IO;
import therfc.bin.data.Game;
import therfc.bin.data.Warehouse;
import therfc.res.Resources;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MenuFrame extends JFrame {

    private List<JRadioButton> radioButtons;
    private Game game = Game.GetInstance();
    private int playerIndex=2;
    private JLabel picLabel;

    public MenuFrame() {


        Container pane = this.getContentPane();
        radioButtons = new ArrayList<JRadioButton>();
        this.setBounds(0, 0, 500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        picLabel = new JLabel(new ImageIcon(Resources.Level1Pic));


        this.setTitle("Killer Sokoban - Main Menu");

        JButton  startGame = new JButton("New Game");
        JButton  exitGame = new JButton("Exit Game");

        JPanel selectWorkerNumber = new JPanel(new GridLayout(1,3,0,0));




        JPanel panel = new JPanel();
        JPanel felso = new JPanel();
        felso.setLayout(new GridLayout(7,1));
        panel.setLayout(new GridLayout(2,1));

        this.add(panel);

        JLabel lbl = new JLabel("Select level: ");
        lbl.setVisible(true);

        felso.add(lbl);

        String[] levels = { "Level 1","Level 2", "Level 3","Level 4","Level 5","Level 6"};

        final JComboBox<String> cb = new JComboBox<String>(levels);

        cb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int c=cb.getSelectedIndex();
                picLabel.removeAll();
                switch(c){
                    case 0:
                        System.out.println("ittvagyok");
                        picLabel.setIcon(new ImageIcon(Resources.CloseHoleImage));

                        //picLabel = new JLabel(new ImageIcon(Resources.BoxImage));
                        break;
                    case 1:
                        picLabel = new JLabel(new ImageIcon(Resources.OilImage));
                        break;
                    case 2:
                        System.out.println("A kurva anyád");
                        picLabel = new JLabel(new ImageIcon(Resources.InActiveTargetFieldImage));
                        break;
                    case 3:
                        picLabel = new JLabel(new ImageIcon(Resources.HoneyImage));
                        break;
                    case 4:
                        picLabel = new JLabel(new ImageIcon(Resources.Level1Pic));
                        break;
                    default:
                        picLabel = new JLabel(new ImageIcon(Resources.WorkerImage_Player3));
                        break;
                }
                //picLabel.repaint();


            }
        });

        cb.setVisible(true);
        felso.add(cb);


        JLabel lbl2 = new JLabel("Select player number:");
        lbl2.setVisible(true);

        felso.add(lbl2);

        String[] choices = { "Players 2","Players 3","Players 4"};

        final JComboBox<String> cb2 = new JComboBox<String>(choices);


        cb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerIndex=cb2.getSelectedIndex()+2;
                System.out.println(playerIndex);
            }
        });
        cb2.setVisible(true);
        felso.add(cb2);

        startGame.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                NewGame();
            }
        });
        exitGame.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
               ExitGame();
            }
        });
        for (int i = 0; i <radioButtons.size() ; i++) {
            JRadioButton currentButton= radioButtons.get(i);
            currentButton.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    for (int i = 0; i <radioButtons.size() ; i++) {
                        if(radioButtons.get(i)!=currentButton) {
                            radioButtons.get(i).setSelected(false);
                        }
                        else {radioButtons.get(i).setSelected(true);}
                    }
                }
            });
        }


        felso.add(startGame, BorderLayout.NORTH);
        felso.add(exitGame, BorderLayout.SOUTH);
        felso.add(selectWorkerNumber, BorderLayout.CENTER);
        panel.add(felso);
        panel.add(picLabel);
       // panel.add(new ImageIcon(img));
        this.setResizable(false);
        this.setVisible(true);
    }
    public void NewGame(){
        Warehouse newWarehouse;
        try {
            newWarehouse=SelectLevel();
            game.SetWarehouse(newWarehouse);
            game.StartGame();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void ExitGame(){
        System.exit(1);
    }

    public Warehouse SelectLevel(){
        IO io = new IO();
        Warehouse result = new Warehouse();
        try {
            result=io.GetWarehouseFromFile(Resources.Player_4,playerIndex);
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*
            if(radioButtons.get(0).isSelected()){
                try {
                    result=game.GetIO().SetWarehouseFromFile(Resources.Player_2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        else if(radioButtons.get(1).isSelected()){
            try {
                result=game.GetIO().SetWarehouseFromFile(Resources.Player_3);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(radioButtons.get(2).isSelected()){
            try {
                result=game.GetIO().SetWarehouseFromFile(Resources.Player_4);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        */
        return result;
    }


}
