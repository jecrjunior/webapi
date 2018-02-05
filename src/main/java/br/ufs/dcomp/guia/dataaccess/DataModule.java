package br.ufs.dcomp.guia.dataaccess;

public class DataModule {
    private static FacadeDataAccess instance;
    public static FacadeDataAccess getInstance(){
        return DataModule.instance == null ? 
            DataModule.instance = new FacadeDataAccess() :
            DataModule.instance;
    }
}