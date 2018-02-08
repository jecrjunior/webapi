package br.ufs.dcomp.guia.dataaccess;

import br.ufs.dcomp.guia.dataaccess.DAO.AcessoDAO;
import br.ufs.dcomp.guia.dataaccess.DAO.GuiaDAO;
import br.ufs.dcomp.guia.dataaccess.DAO.ItemGuiaDAO;
import br.ufs.dcomp.guia.dataaccess.DAO.UsuarioDAO;
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
		GuiaDAO dao = new GuiaDAO();
		return dao.create(guia);
	}
	@Override
	public Guia readGuia(Integer id) {
		GuiaDAO dao = new GuiaDAO();
		return dao.read(id);
	}
	@Override
	public boolean updateGuia(Guia guia) {
		GuiaDAO dao = new GuiaDAO();
		return dao.update(guia);
	}
	@Override
	public boolean deleteGuia(Integer id) {
		GuiaDAO dao = new GuiaDAO();
		return dao.delete(id);
	}
	@Override
	public boolean createItemGuia(ItemGuia itemGuia) {
		ItemGuiaDAO dao = new ItemGuiaDAO();
		return dao.create(itemGuia);
	}
	@Override
	public ItemGuia readItemGuia(Integer id) {
		ItemGuiaDAO dao = new ItemGuiaDAO();
		return dao.read(id);
	}
	@Override
	public boolean updateItemGuia(ItemGuia itemGuia) {
		ItemGuiaDAO dao = new ItemGuiaDAO();
		return dao.update(itemGuia);
	}
	@Override
	public boolean deleteItemGuia(Integer id) {
		ItemGuiaDAO dao = new ItemGuiaDAO();
		return dao.delete(id);
	}
	@Override
	public boolean createUsuario(Usuario usuario) {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.create(usuario);
	}
	@Override
	public Usuario readUsuario(Integer id) {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.read(id);
	}
	@Override
	public boolean updateUsuario(Usuario usuario) {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.update(usuario);
	}
	@Override
	public boolean deleteUsuario(Integer id) {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.delete(id);
	}
	@Override
	public boolean createAcesso(Acesso acesso) {
		AcessoDAO dao = new AcessoDAO();
		return dao.create(acesso);
	}
	@Override
	public Acesso readAcesso(Integer acesso) {
		AcessoDAO dao = new AcessoDAO();
		return dao.read(acesso);
	}
	@Override
	public boolean updateAcesso(Acesso acesso) {
		AcessoDAO dao = new AcessoDAO();
		return dao.update(acesso);
	}

	@Override
	public boolean deleteAcesso(Integer acesso) {
		AcessoDAO dao = new AcessoDAO();
		return dao.delete(acesso);
	}


}