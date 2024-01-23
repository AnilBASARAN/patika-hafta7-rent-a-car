package business;
import java.util.ArrayList;
import java.util.Objects;

import core.Helper;
import dao.BrandDao;
import entity.Brand;


public class BrandManager {
    private final BrandDao brandDao;

    public BrandManager() {
        this.brandDao = new BrandDao();
    }


    public ArrayList<Brand> findAll(){
        return this.brandDao.findAll();
    }


    public ArrayList<Object[]> getForTable(int size){
        ArrayList<Object[]> brandRowList = new ArrayList<>();
        for( Brand brand : this.findAll()){
            Object[] rowObject = new Object[size];
            int i = 0;
            rowObject[i++] = brand.getId();
            rowObject[i++] = brand.getName();
            brandRowList.add(rowObject);
        }
        return brandRowList;
    }

    public boolean save(Brand brand){
        if(brand.getId() != 0){
            Helper.showMsg("error");
        }
        return this.brandDao.save(brand);
    }

    public Brand getById(int id){
        return this.brandDao.getById(id);
    }

    public boolean update(Brand brand){
        if(this.getById(brand.getId()) == null ){
            Helper.showMsg("notfound");
        }
        return this.brandDao.update(brand);
    }

}
