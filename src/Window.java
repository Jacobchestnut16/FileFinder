import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.Scanner;

public class Window extends JFrame {
    public static void main(String[] args) {
        new Window();
    }
    private Surf surf = new Surf();
    private PanelHandler p = new PanelHandler(surf.listFiles());
    private JPanel main = new JPanel();
    private JButton[] dir = p.getButtons();

    private JPanel innerPanel = new JPanel(new GridLayout(2,0));

    public Window(){
        super();
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setSize(1000,1000);
        for (JButton d: dir) {
            d.addMouseListener(ml);
            main.add(d);
        }
        customMenuBar();

        innerPanel.add(cmb);
        innerPanel.add(main);
        super.add(innerPanel);
        super.setFocusable(true);
        super.setVisible(true);
        //super.pack();
    }
    private JPanel cmb = new JPanel(new GridLayout(0,5));

    public void customMenuBar(){
        cmb.setMaximumSize(new Dimension(5000, 20));
        cmb.setPreferredSize(new Dimension(35, 20));
        JButton forward = new JButton("->");
        JButton back = new JButton("<-");
        forward.setMaximumSize(new Dimension(5000, 20));
        forward.setPreferredSize(new Dimension(35, 20));
        back.setMaximumSize(new Dimension(5000, 20));
        back.setPreferredSize(new Dimension(35, 20));
        cmb.add(back);
        cmb.add(forward);
        JTextArea directory = new JTextArea();
        directory.setText(surf.toString());
        cmb.add(directory);
    }

    public void updateFrame(){
        p = new PanelHandler(surf.listFiles());
        for (JButton d: dir) {
            d.removeMouseListener(ml);
            main.remove(d);
        }
        dir = p.getButtons();
        for (JButton d: dir) {
            d.addMouseListener(ml);
            main.add(d);
        }
        main.setVisible(true);
        main.revalidate();
        super.repaint();
    }

    private MouseListener ml = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            for (int i = 0; i < dir.length; i ++) {
                if (e.getSource() == dir[i]){
                    surf.openFile(i);
                    updateFrame();
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    };
}
