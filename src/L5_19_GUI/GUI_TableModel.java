package L5_19_GUI;

import com.company.Insects;

import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GUI_TableModel extends AbstractTableModel {
    ArrayList<Insects> insects = new ArrayList<>();
    private String filter = null;

    public void setFilter(String value) {
        this.filter = value;
        this.fireTableDataChanged();
    }

    public void save() throws SQLException, ClassNotFoundException {
        BaseData.deleteFromDB();
        BaseData.CreateDB();
        for (Insects in : insects) {
            BaseData.WriteDB(in);
        }
    }

    public void load() {
        try {
            insects = BaseData.ReadDB();
            this.fireTableDataChanged();
        } catch (Exception ex) {
        }
    }

    public ArrayList<Insects> getInsectsFiltered() {
        if (filter == null) {
            return this.insects;
        } else {
            ArrayList<Insects> search = new ArrayList<Insects>();
            boolean s = false;
            for (Insects in : insects) {
                s = Pattern.compile(filter.toLowerCase()).matcher(in.getVariety().toLowerCase()).find();
                if (s) {
                    search.add(in);
                }
            }
            return search;
        }

    }

    public void Add(Insects insect) {
        insects.add(insect);
        this.fireTableDataChanged();
    }

    public Insects removeData(String variety) {
        Insects del = null;

        for (Insects in : this.insects) {
            if (in.getVariety().equals(variety)) {
                del = in;
                break;
            }
        }
        if (del != null) {
            insects.remove(del);
        }
        this.fireTableDataChanged();
        return del;
    }

    @Override
    public int getRowCount() {
        return this.getInsectsFiltered().size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int r, int c) {
        switch (c) {
            case 0:
                return this.getInsectsFiltered().get(r).getType();
            case 1:
                return this.getInsectsFiltered().get(r).getFeet();
            case 2:
                return this.getInsectsFiltered().get(r).getEyes();
            case 3:
                return this.getInsectsFiltered().get(r).getWings();
            case 4:
                return this.getInsectsFiltered().get(r).getColor();
            case 5:
                return this.getInsectsFiltered().get(r).getVariety();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int c) {
        String сolumn = "";
        switch (c) {
            case 0:
                сolumn = "Тип насекомого";
                break;
            case 1:
                сolumn = "Количесто лапок";
                break;
            case 2:
                сolumn = "Количество глаз";
                break;
            case 3:
                сolumn = "Наличие крыльев";
                break;
            case 4:
                сolumn = "Цвет крыльев";
                break;
            case 5:
                сolumn = "Разновидность";
                break;
        }
        return сolumn;
    }
}
