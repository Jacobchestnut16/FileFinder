import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.lang.reflect.Field;

public class PanelHandler extends JPanel {
    JButton[] buttons;
    Icon icon = new ImageIcon("dir.png");
    Icon emptyIcon = new ImageIcon("emptyDir.png");
    public PanelHandler(File[] dir){
        buttons = new JButton[dir.length];
        for (int i = 0; i < dir.length; i++) {
            if (dir[i].isDirectory()) {
                File[] d = dir[i].listFiles();
                if (d == null || d.length == 0){
                    buttons[i] = new JButton(dir[i].getName(), emptyIcon);
                }else {
                    buttons[i] = new JButton(dir[i].getName(), icon);
                }
            }else{
                buttons[i] = new JButton(dir[i].getName());
            }
            buttons[i].setMinimumSize(new Dimension(16,16));
            buttons[i].setMaximumSize(new Dimension(200,250));
            super.add(buttons[i]);
        }
    }

    public JButton[] getButtons(){
        return buttons;
    }

}
