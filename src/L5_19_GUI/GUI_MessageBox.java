package L5_19_GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_MessageBox extends JDialog {
    private JButton btn;
    JLabel l1;
    private JPanel panel;
    private JPanel panel2;
    public GUI_MessageBox frame;
    public GUI_MessageBox(JDialog owner, String message){
        super(owner,"Результат", Dialog.ModalityType.DOCUMENT_MODAL);
        gui_setting(message);
        this.setResizable(false);
        this.setSize(50, 100);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void gui_setting(String message) {
        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(2,1));
        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        frame = this;

        l1 = new JLabel(message);
        l1.setHorizontalAlignment(JLabel.CENTER);
        panel2.add(l1);
        btn = new JButton("OK");
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        panel.add(btn);
        panel2.add(panel);
        getContentPane().add(panel2);
    }
}
