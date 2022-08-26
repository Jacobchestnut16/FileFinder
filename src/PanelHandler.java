import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.lang.reflect.Field;

public class PanelHandler extends JPanel {
    private JButton[] buttons;
    private Icon icon = new ImageIcon("dir.png");
    private Icon emptyIcon = new ImageIcon("emptyDir.png");
    private Icon fileIcon = new ImageIcon("file.png");
    private Icon txtIcon = new ImageIcon("txtFile.png");
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
                try {
                    if (dir[i].getName().substring(dir[i].getName().length() - 6, dir[i].getName().length() - 1).equalsIgnoreCase(".txt")) {
                        buttons[i] = new JButton(dir[i].getName(), txtIcon);
                    } else
                        buttons[i] = new JButton(dir[i].getName(), fileIcon);
                } catch (StringIndexOutOfBoundsException e){
                    buttons[i] = new JButton(dir[i].getName(), fileIcon);
                }
            }
            buttons[i].setMinimumSize(new Dimension(16,16));
            buttons[i].setMaximumSize(new Dimension(200,200));
            buttons[i].setPreferredSize(new Dimension(200,200));
            super.add(buttons[i]);
        }
    }

    public JButton[] getButtons(){
        return buttons;
    }


}
