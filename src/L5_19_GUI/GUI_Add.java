package L5_19_GUI;

import com.company.Ant;
import com.company.Butterfly;
import com.company.Caterpillar;
import com.company.Mosquito;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI_Add extends JDialog {
    public GUI_TableModel model;
    JPanel panel;
    JButton btn ;
    JTextField t2,t3,t4,t5,t6;
    private boolean resultDialog;

    private static GUI_Add frame;


    public JComboBox getChoose() {
        return choose;
    }

    JComboBox choose;
    private String[] comboBox = {
            "Муравей",
            "Бабочка",
            "Гусеница",
            "Комар"
    };

    public GUI_Add(GUI_TableModel model, JFrame owner){
        super(owner,  "Добавление", Dialog.ModalityType.DOCUMENT_MODAL);
        gui_setting();
        this.model = model;
        this.setResizable(false);
        this.setSize(250, 300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void gui_setting() {
        //панель
        panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));

        choose = new JComboBox(comboBox);
        panel.add(choose);

        t2 = new JTextField("Количество лапок", 15);
        t2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                t2.setText("");
            }
        });
        t2.setToolTipText("Количество лапок");
        panel.add(t2);
        t3 = new JTextField("Количество глаз", 15);
        t3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                t3.setText("");
            }
        });
        t3.setToolTipText("Количество глаз");
        panel.add(t3);
        t4 = new JTextField("Наличие крыльев", 15);
        t4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                t4.setText("");
            }
        });
        t4.setToolTipText("Наличие крыльев");
        panel.add(t4);
        t5 = new JTextField("Цвет", 15);
        t5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                t5.setText("");
            }
        });
        t5.setToolTipText("Цвет");
        panel.add(t5);
        t6 = new JTextField("Разновидность", 15);
        t6.setToolTipText("Разновидность");
        t6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                t6.setText("");
            }
        });
        panel.add(t6);


        frame = this;

        btn = new JButton("Добавить");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    switch (GUI_Add.this.getChoose().getSelectedItem().toString()) {
                        case "Муравей":
                            frame.model.Add(new Ant(Integer.parseInt(t2.getText()),Integer.parseInt(t3.getText()),t4.getText(),t5.getText(),t6.getText()));
                            break;
                        case "Бабочка" :
                            frame.model.Add(new Butterfly(Integer.parseInt(t2.getText()),Integer.parseInt(t3.getText()),t4.getText(),t5.getText(),t6.getText()));
                            break;
                        case "Гусеница":
                            frame.model.Add(new Caterpillar(Integer.parseInt(t2.getText()),Integer.parseInt(t3.getText()),t4.getText(),t5.getText(),t6.getText()));
                            break;
                        case "Комар":
                            frame.model.Add(new Mosquito(Integer.parseInt(t2.getText()),Integer.parseInt(t3.getText()),t4.getText(),t5.getText(),t6.getText()));
                            break;
                    }
                    GUI_MessageBox form = new GUI_MessageBox(GUI_Add.this,"Готово!");
                    frame.dispose();

                    resultDialog = true;
                    GUI_Add.this.setVisible(false);

                }catch (Exception ex){
                    GUI_MessageBox form = new GUI_MessageBox(GUI_Add.this,"Некорректный ввод!");
                }
            }
        });

        panel.add(btn);



        getContentPane().add(panel);
    }


}

