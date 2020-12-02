package L5_19_GUI;


import com.company.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;

public class GUI extends JFrame {

    private JLabel welcome;

    public JComboBox getChoose() {
        return choose;
    }

    private JComboBox choose;
    private JButton start;
    private JButton save;
    private JButton load;
    private static JPanel panel, panel1, panel2, panel3;
    private JScrollPane result_back;
    private static JTable result;
    GUI_TableModel insects = new GUI_TableModel();
    private String[] comboBox = {
            "Вывести список всех насекомых",
            "Поиск насекомого",
            "Поймать насекомое",
            "Добавить насекомое"
    };

    private void gui_setting() {
        //Основная панель
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        //Верхняя панель
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel1 = new JPanel();
        panel1.setSize(200, 30);
        panel1.setLayout(new GridLayout(1, 1, 0, 0));

        //Текст
        welcome = new JLabel("Добро пожаловать в лес! Перед Вами насекомые. Выберите действие и нажмите \"Начать\"");
        welcome.setVerticalAlignment(JLabel.TOP);
        welcome.setHorizontalAlignment(JLabel.CENTER);

        //Занос панелей
        panel1.add(welcome);

        //средняя панель
        panel2 = new JPanel();
        panel2.setSize(200, 50);
        panel2.setLayout(new GridLayout(1, 2, 0, 0));

        //комбобокс
        choose = new JComboBox(comboBox);
        panel2.add(choose);

        //кнопка
        start = new JButton("Начать!");
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (GUI.this.getChoose().getSelectedItem().toString()) {
                    case "Вывести список всех насекомых":
                        insects.setFilter(null);
                        insects.getInsectsFiltered();
                        break;
                    case "Поиск насекомого":
                        GUI_search form = new GUI_search(insects, GUI.this, "Поиск");
                        break;
                    case "Поймать насекомое":
                        GUI_search form1 = new GUI_search(insects, GUI.this, "Поймать");
                        break;
                    case "Добавить насекомое":
                        GUI_Add form2 = new GUI_Add(insects, GUI.this);
                        break;
                }
            }
        });
        start.setPreferredSize(new Dimension(50, 50));
        panel2.add(start);

        //кнопка сохранить
        save = new JButton("Сохранить");
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    insects.save();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
        save.setPreferredSize(new Dimension(50, 50));
        panel2.add(save);

        //кнопка загрузить
        load = new JButton("Загрузить");
        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insects.load();
            }
        });
        load.setPreferredSize(new Dimension(50, 50));
        panel2.add(load);

        //нижняя панель
        panel3 = new JPanel();
        panel3.setSize(200, 300);
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));


        //таблица
        insects.Add(new Mosquito(6, 5, "Имеются", "Прозрачный", "Пискун"));
        insects.Add(new Ant(6, 5, "Имеются только у самок", "черно-бурый", "Лесной"));
        insects.Add(new Ant(6, 5, "Имеются только у самок", "черный", "Жнец"));
        insects.Add(new Butterfly(6, 2, "Имеются", "Желтовато-белые", "Капустница"));
        insects.Add(new Butterfly(6, 4, "Имеются", "Светло-серые с коричневым узором", "Агриппа"));
        insects.Add(new Caterpillar(6, 10, "Не имеются", "Древесный", "Гусеница пяденицы"));
        insects.Add(new Caterpillar(16, 10, "Не имеются", "Зеленый с фиолетовым ромбом на спине", "Гусеница большой гарпии"));
        insects.Add(new Mosquito(6, 4000, "Имеются", "Прозрачный", "Кусак"));
        result = new JTable();
        result.setModel(insects);

        result_back = new JScrollPane(result);
        panel3.add(result_back);

        //занос панелей
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        getContentPane().add(panel);

    }

    public GUI() {
        super("Лес");
        gui_setting();
    }

    public static void GUI_main() {
        GUI frame = new GUI();
        frame.setResizable(false);
        frame.setSize(600, 250);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


}

