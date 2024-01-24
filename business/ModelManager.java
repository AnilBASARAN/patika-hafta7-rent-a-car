package business;

import dao.ModelDao;
import core.Helper;
import entity.Brand;
import entity.Model;

import java.util.ArrayList;


public class ModelManager {
    private final ModelDao modelDao = new ModelDao();
    public Model getById(int id){
        return this.modelDao.getByID(id);
    }

    public ArrayList<Model> findAll(){
        return this.modelDao.findAll();
    }

    public ArrayList<Object[]>getForTable(int size,ArrayList<Model> modelList){
        ArrayList<Object[]> modelObjList = new ArrayList<>();
        for(Model obj: modelList){
            int i = 0;
            Object[] rowObject = new Object[size];
            rowObject[i++] = obj.getId();
            rowObject[i++] = obj.getBrand().getName();
            rowObject[i++] = obj.getName();
            rowObject[i++] = obj.getType();
            rowObject[i++] = obj.getYear();
            rowObject[i++] = obj.getFuel();
            rowObject[i++] = obj.getGear();
            modelObjList.add(rowObject);
        }
        return modelObjList;
    }

    public boolean save(Model model){
        if(this.getById(model.getId()) != null){
            Helper.showMsg("error");
            return false;
        }
        return this.modelDao.save(model);
    }

    public boolean delete(int id){
        if(this.getById(id) == null){
            Helper.showMsg(id + " ID kayıtlı model bulunamadı");
            return false;
        }
        return this.modelDao.delete(id);
    }

    public boolean update( Model model){
        if (this.getById(model.getId()) == null){
            Helper.showMsg(model.getId() + "ID kayıtlı model bulunamadı");
            return false;
        }
        return this.modelDao.update(model);
    }

    public ArrayList<Model> getByListBrandId(int brandId){
        return this.modelDao.getByBrandListId(brandId);
    }

    public ArrayList<Model> searchForTable(int brandId,Model.Fuel fuel,Model.Gear gear,Model.Type type){
        String select = "SELECT * FROM public.model"  ;
        return this.modelDao.getByBrandListId(brandId);
    }
}
