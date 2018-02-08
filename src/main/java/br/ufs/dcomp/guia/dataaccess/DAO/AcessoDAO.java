package br.ufs.dcomp.guia.dataaccess.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import br.ufs.dcomp.guia.model.Acesso;

public class AcessoDAO extends StrategyDAO<Acesso>{

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
			"SELECT id, usuario, guia, momento FROM public.tb_acesso WHERE (id = %s);",
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

}