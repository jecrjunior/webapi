package br.ufs.dcomp.guia.dataaccess.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import br.ufs.dcomp.guia.model.Guia;

public class GuiaDAO extends StrategyDAO<Guia> {

	@Override
	public Guia read(Integer id) {
		Guia guia = null;
		try {
			ResultSet r = this.dm.executeQuery(this.getSelectStatment(id));
			if (r.next()) {
				guia = new Guia();
				guia.setId(r.getInt("id"));
				guia.setTitle(r.getString("title"));
				guia.setDescricao(r.getString("descricao"));
				guia.setPublication(r.getDate("publication"));
				guia.setIdPai(r.getInt("idpai"));
			}
		} catch (SQLException e) {
			guia = null;
			e.printStackTrace();
		}
		return guia;
	}

	@Override
	public String getInsertStatment(Guia model) {
		return String.format(
			"INSERT INTO public.tb_guia(title, publication, descricao, idpai) VALUES (\'%s\', \'%s\', \'%s\', %s);",
			model.getTitle(), 
			model.getPublication().toGMTString(), 
			model.getDescricao(),
			model.getIdPai().toString() 
		);
	}

	@Override
	public String getUpdateStatment(Guia model) {
		return String.format(
			"UPDATE public.tb_guia SET title=\'%s\', publication=\'%s\', descricao=\'%s\', idpai=%s WHERE (id = %s);",
			model.getTitle(),
			model.getPublication().toGMTString(),
			model.getDescricao(),
			model.getIdPai().toString(),
			model.getId().toString() 
		);
	}

	@Override
	public String getSelectStatment(Integer id) {
		return String.format(
			"SELECT id, title, publication, descricao, idpai FROM public.tb_guia WHERE (id = %s);",
			id.toString() 
		);
	}

	@Override
	public String getDeleteStatment(Integer id) {
		return String.format(
			"DELETE FROM public.tb_guia WHERE (id = %s);",
			id.toString() 
		);
	}

}