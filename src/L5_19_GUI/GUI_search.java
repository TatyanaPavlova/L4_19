package L5_19_GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_search extends JDialog {

    private JLabel text;
    private JTextArea data;
    private JButton btn;
    private JPanel panel;
    private static String type;
    private static GUI_search frame;
    public static GUI_TableModel model;

    public GUI_search(GUI_TableModel model,JFrame owner, String tp) {
        super(owner,"Поиск",Dialog.ModalityType.DOCUMENT_MODAL);
        type = tp;
        this.model = model;
        gui_setting();
        this.setResizable(false);
        this.setSize(250, 100);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void gui_setting() {
        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));


        text = new JLabel("Введите разновидность: ");
        panel.add(text);


        data = new JTextArea();
        panel.add(data);

        frame = this;

        btn = new JButton("OK");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (type){
                    case "Поиск":
                       model.setFilter(data.getText());
                      if(model.getInsectsFiltered().size() == 0){
                          GUI_MessageBox form = new GUI_MessageBox(GUI_search.this,"Не найдено!");
                      }else {
                          GUI_MessageBox form = new GUI_MessageBox(GUI_search.this,"Готово!");
                      }

                        break;
                    case "Поймать":

                        if(model.removeData(data.getText()) == null){
                            GUI_MessageBox form2 = new GUI_MessageBox(GUI_search.this,"Не найдено!");
                        }else{
                            GUI_MessageBox form = new GUI_MessageBox(GUI_search.this,"Готово!");
                        }

                        break;
                }

                frame.dispose();
            }
        });
        panel.add(btn);
        getContentPane().add(panel);

    }
}

