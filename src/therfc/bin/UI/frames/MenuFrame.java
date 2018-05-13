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
    private File level = Resources.Level_1_map;
    private JPanel picLabel;
    private BufferedImage img = Resources.Level1;

    public MenuFrame() {


        Container pane = this.getContentPane();
        radioButtons = new ArrayList<JRadioButton>();
        this.setBounds(0, 0, 500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        picLabel = new JPanel(){
            @Override
            protected  void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(img,140,0,null);
            }
        };


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

        String[] levels = { "Endre Bácsi Erdeje","Projlab Penetráló", "Szoftech Szurdok","Goldschmidt Graveyard","Simon Siratója","Szirmay Szoros","Szebi Szivatója"};

        final JComboBox<String> cb = new JComboBox<String>(levels);

        cb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int c=cb.getSelectedIndex()+1;

                switch(c){
                    case 1:
                        img = Resources.Level1;
                        level = Resources.Level_1_map;
                        break;
                    case 2:
                        img = Resources.Level2;
                        level = Resources.Level_2_map;
                        break;
                    case 3:
                        img = Resources.Level3;
                        level = Resources.Level_3_map;
                        break;
                    case 4:
                        img = Resources.Level4;
                        level = Resources.Level_4_map;
                        break;
                    case 5:
                        img = Resources.Level5;
                        level = Resources.Level_5_map;
                        break;
                    case 6:
                        img = Resources.Level6;
                        level = Resources.Level_6_map;
                        break;
                    case 7:
                        img = Resources.Level7;
                        level = Resources.Level_7_map;
                        break;
                    default:
                        img = Resources.Level1;
                        level = Resources.Level_1_map;
                        break;
                }
                picLabel.repaint();
            }
        });

        cb.setVisible(true);
        felso.add(cb);


        JLabel lbl2 = new JLabel("Select player number:");
        lbl2.setVisible(true);

        felso.add(lbl2);

        String[] choices = { "2 players","3 players","4 players"};

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
               dispose();
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
            result=io.GetWarehouseFromFile(level,playerIndex);
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*
            if(radioButtons.get(0).isSelected()){
                try {
                    result=game.GetIO().SetWarehouseFromFile(Resources.Level_1_map);
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
