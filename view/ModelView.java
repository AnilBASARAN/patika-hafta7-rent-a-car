package view;
import business.ModelManager;
import entity.Model;
import javax.swing.*;

public class ModelView extends Layout{
    private JPanel container;
    private JLabel lbl_heading;
    private JComboBox cmb_brand;
    private JTextField fld_model_name;
    private JTextField fld_model_year;
    private JComboBox cmb_model_type;
    private JComboBox cmb_model_fuel;
    private JComboBox cmb_model_gear;

    private Model model;
    private ModelManager modelManager;

    public ModelView(Model model) {
        this.add(container);
        this.model = model;
        this.modelManager = new ModelManager();
        this.guiInitilaze(300,500);

    }
}
