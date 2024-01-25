package view;
import business.CarManager;
import business.ModelManager;
import core.ComboItem;
import core.Helper;
import entity.Model;
import entity.Car;
import javax.swing.*;

public class CarView extends Layout{
    private JPanel container;
    private JComboBox<ComboItem> cmb_model;
    private JComboBox<Car.Color> cmb_color;
    private JTextField fld_km;
    private JTextField fld_plate;
    private JButton btn_car_save;
    private Car car;
    private CarManager carManager;
    private ModelManager modelManager;

    public CarView(Car car){
        this.car = car;
        this.carManager = new CarManager();
        this.modelManager = new ModelManager();
        this.add(container);
        this.guiInitilaze(300,400);

        this.cmb_color.setModel(new DefaultComboBoxModel<>(Car.Color.values()));
        for(Model model : this.modelManager.findAll()){
            //this.cmb_model.addItem(model);
        }

    }


}
