package br.ufs.dcomp.guia.dataaccess;

import br.ufs.dcomp.guia.model.Acesso;
import br.ufs.dcomp.guia.model.Guia;
import br.ufs.dcomp.guia.model.ItemGuia;
import br.ufs.dcomp.guia.model.usuario.Usuario;

public class FacadeDataAccess implements IDataAccess {
    private static FacadeDataAccess instance;
    public static FacadeDataAccess getInstance(){
        return FacadeDataAccess.instance == null ? 
            FacadeDataAccess.instance = new FacadeDataAccess() :
            FacadeDataAccess.instance;
    }
	@Override
	public boolean createGuia(Guia guia) {
		return false;
	}
	@Override
	public Guia readGuia(Integer id) {
		return null;
	}
	@Override
	public boolean updateGuia(Guia guia) {
		return false;
	}
	@Override
	public boolean deleteGuia(Integer id) {
		return false;
	}
	@Override
	public boolean createItemGuia(ItemGuia itemGuia) {
		return false;
	}
	@Override
	public ItemGuia readItemGuia(Integer id) {
		return null;
	}
	@Override
	public boolean updateItemGuia(ItemGuia itemGuia) {
		return false;
	}
	@Override
	public boolean deleteItemGuia(Integer id) {
		return false;
	}
	@Override
	public boolean createUsuario(Usuario usuario) {
		return false;
	}
	@Override
	public Usuario readUsuario(Integer id) {
		return null;
	}
	@Override
	public boolean updateUsuario(Usuario usuario) {
		return false;
	}
	@Override
	public boolean deleteUsuario(Integer id) {
		return false;
	}
	@Override
	public boolean createAcesso(Acesso acesso) {
		return false;
	}
	@Override
	public Acesso readAcesso(Integer acesso) {
		return null;
	}
	@Override
	public boolean updateAcesso(Acesso acesso) {
		return false;
	}
	@Override
	public boolean deleteAcesso(Integer acesso) {
		return false;
	}


}