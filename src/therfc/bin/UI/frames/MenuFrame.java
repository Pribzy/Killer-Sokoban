package therfc.bin.UI.frames;

import javafx.beans.property.ListPropertyBase;
import therfc.bin.IO.Controller;
import therfc.bin.data.Game;
import therfc.bin.data.Warehouse;
import therfc.res.Resources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class MenuFrame extends JFrame {

    private List<JRadioButton> radioButtons;
    private Game game = Game.GetInstance();

    public MenuFrame() {


        Container pane = this.getContentPane();
        radioButtons = new ArrayList<JRadioButton>();
        this.setBounds(0, 0, 500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        this.setTitle("Killer Sokoban - Main Menu");

        JButton  startGame = new JButton("New Game");
        JButton  exitGame = new JButton("Exit Game");

        JPanel selectWorkerNumber = new JPanel(new GridLayout(1,3,0,0));




        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(15,1));

        this.add(panel);

        JLabel lbl = new JLabel("Select level: ");
        lbl.setVisible(true);

        panel.add(lbl);

        String[] levels = { "Level 1","Level 2", "Level 3","Level 4","Level 5","Level 6"};

        final JComboBox<String> cb = new JComboBox<String>(levels);

        cb.setVisible(true);
        panel.add(cb);

        JLabel lbl2 = new JLabel("Select player number:");
        lbl2.setVisible(true);

        panel.add(lbl2);

        String[] choices = { "Players 2","Players 3","Players 4"};

        final JComboBox<String> cb2 = new JComboBox<String>(choices);

        cb2.setVisible(true);
        panel.add(cb2);

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



        panel.add(startGame, BorderLayout.NORTH);
        panel.add(exitGame, BorderLayout.SOUTH);
        panel.add(selectWorkerNumber, BorderLayout.CENTER);
        this.setResizable(false);
        this.setVisible(true);
    }
    public void NewGame(){
        Warehouse newWarehouse;
        try {
             newWarehouse=SelectLevel();
            game.SetWarehouse(newWarehouse);
            game.GetIO().SetNeighBors(newWarehouse);
            GameFrame gf= new GameFrame(game);
            game.SetGameFrame(gf);
            game.StartGame();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void ExitGame(){
        System.exit(1);
    }
    public Warehouse SelectLevel(){
        Warehouse result = new Warehouse();
        try {
            result=game.GetIO().SetWarehouseFromFile(Resources.Player_4);
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
