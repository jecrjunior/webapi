package br.ufs.dcomp.guia.dataaccess.DAO;

import br.ufs.dcomp.guia.model.IModel;

public abstract class StrategyDAO<IModel> {
    public abstract boolean create(IModel model);
    public abstract IModel read(Integer id);
    public abstract boolean update(IModel model);
    public abstract boolean delete(Integer id);
}