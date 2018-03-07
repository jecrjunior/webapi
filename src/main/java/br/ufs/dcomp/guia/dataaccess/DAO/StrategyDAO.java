package br.ufs.dcomp.guia.dataaccess.DAO;

import br.ufs.dcomp.guia.dataaccess.DataModule;
import br.ufs.dcomp.guia.model.IModel;
import java.util.List;

public abstract class StrategyDAO<IModel> {
    DataModule dm = DataModule.getInstance();
    
    public boolean create(IModel model) {
        boolean result = false;
        try {
            this.dm.executeStatment(
                this.getInsertStatment(model)
            );
            result = true;                
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;        
    }

    public abstract IModel read(Integer id);
    public abstract List<IModel> readAll();
    
    public boolean update(IModel model) {
        boolean result = false;
        try {
            this.dm.executeStatment(
                this.getUpdateStatment(model)
            );
            result = true;                
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;        
    }

    public boolean delete(Integer id) {
        boolean result = false;
        try {
            this.dm.executeStatment(
                this.getDeleteStatment(id)
            );
            result = true;                
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;        
    }
    //
    public abstract String getInsertStatment(IModel model);
    public abstract String getUpdateStatment(IModel model);
    public abstract String getSelectStatment(Integer id);
    public abstract String getDeleteStatment(Integer id);
    public abstract String getSelectAllStatment(); 
}