import javax.swing.*;
import java.awt.*;

public class TowerMenu extends JPanel {
    JButton normalTower = new JButton("Normal Tower");
    JButton slowTower = new JButton("Slow Tower");

    public TowerMenu() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setVisible(true);
        setBackground(Color.GRAY);

        //normalTower.setBounds(10, 10, 200, 30);
        //slowTower.setBounds(10, 50, 200, 300);
        add(Box.createRigidArea(new Dimension(0, 20)));
        normalTower.setPreferredSize(new Dimension(200, 30));

        slowTower.setPreferredSize(new Dimension(200, 30));
        slowTower.setVerticalAlignment(SwingConstants.CENTER);
        slowTower.setHorizontalAlignment(SwingConstants.CENTER);

        add(normalTower);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(slowTower);
        normalTower.addActionListener(e ->{

        });
        slowTower.addActionListener(e ->{

        });
    }

}
