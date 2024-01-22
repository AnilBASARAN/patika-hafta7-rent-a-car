package business;
import java.util.ArrayList;

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
