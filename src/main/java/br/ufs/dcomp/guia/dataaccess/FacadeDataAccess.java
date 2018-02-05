package br.ufs.dcomp.guia.dataaccess;

public class FacadeDataAccess implements IDataAccess {
    private static FacadeDataAccess instance;
    public static FacadeDataAccess getInstance(){
        return FacadeDataAccess.instance == null ? 
            FacadeDataAccess.instance = new FacadeDataAccess() :
            FacadeDataAccess.instance;
    }


}