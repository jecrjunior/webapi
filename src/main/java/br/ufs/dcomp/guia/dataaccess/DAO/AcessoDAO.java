package br.ufs.dcomp.guia.dataaccess.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import br.ufs.dcomp.guia.model.Acesso;

public class AcessoDAO extends DataAccessObject<Acesso>{

	@Override
	public Acesso read(Integer id) {
		Acesso acesso = null;
		try {
			ResultSet r = this.dm.executeQuery(this.getSelectStatment(id));
			if (r.next()) {
				acesso = new Acesso();
				acesso.setId(r.getInt("id"));
				acesso.setItemGuia(r.getInt("guia"));
				acesso.setUsuario(r.getInt("usuario"));
				acesso.setMomento(r.getDate("momento"));
			}
		} catch (SQLException e) {
			acesso = null;
			e.printStackTrace();
		}
		return acesso;
	}

	@Override
	public String getInsertStatment(Acesso model) {
		return String.format(
			"INSERT INTO public.tb_acesso(usuario, guia, momento) VALUES (%s, %s, \'%s\');",
			model.getUsuario().toString(), 
			model.getItemGuia().toString(), 
			model.getMomento().toGMTString() 
		);
	}

	@Override
	public String getUpdateStatment(Acesso model) {
		return String.format(
			"UPDATE public.tb_acesso SET usuario=%s, guia=%s, momento=\'%s\' WHERE (id = %s);",
			model.getUsuario().toString(), 
			model.getItemGuia().toString(), 
			model.getMomento().toGMTString(),
			model.getId().toString() 
		);
	}

	@Override
	public String getSelectStatment(Integer id) {
		return String.format(
			this.getSelectAllStatment() +
			" WHERE (id = %s);",
			id.toString() 
		);
	}

	@Override
	public String getDeleteStatment(Integer id) {
		return String.format(
			"DELETE FROM public.tb_acesso WHERE (id = %s);",
			id.toString() 
		);
	}

	@Override
	public List<Acesso> readAll() {
		List<Acesso> lstAcesso = new LinkedList<Acesso>();
		try {
			ResultSet r = this.dm.executeQuery(this.getSelectAllStatment());
			while (r.next()) {
				Acesso acesso = new Acesso();
				acesso.setId(r.getInt("id"));
				acesso.setItemGuia(r.getInt("guia"));
				acesso.setUsuario(r.getInt("usuario"));
				acesso.setMomento(r.getTimestamp("momento"));
				lstAcesso.add(acesso);
			}
		} catch (SQLException e) {
			lstAcesso = null;			
			//e.printStackTrace();
		}		
		return lstAcesso;
	}

	@Override
	public String getSelectAllStatment() {
		return "SELECT id, usuario, guia, momento FROM public.tb_acesso ";
	}

}