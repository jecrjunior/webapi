package br.ufs.dcomp.guia.dataaccess.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
				guia.setTitle(r.getString("titulo"));
				guia.setDescricao(r.getString("descricao"));
				guia.setPublication(r.getTimestamp("publicacao"));
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
			"INSERT INTO public.tb_guia(titulo, publicacao, descricao, idpai) VALUES (\'%s\', \'%s\', \'%s\', %s);",
			model.getTitle(), 
			model.getPublication().toGMTString(), 
			model.getDescricao(),
			model.getIdPai().toString() 
		);
	}

	@Override	
	public String getUpdateStatment(Guia model) {
		return String.format(
			"UPDATE public.tb_guia SET titulo=\'%s\', publicacao=\'%s\', descricao=\'%s\', idpai=%s WHERE (id = %s);",
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
			this.getSelectAllStatment() +
			" WHERE (id = %s);",
			id.toString() 
		);
	}

	public String getSelectStatmentChildsOf(Integer idPai) {
		return String.format(
			this.getSelectAllStatment() +
			" WHERE (idpai = %s);",
			idPai.toString() 
		);
	}

	public String getSelectAllStatment() {
		return "SELECT id, titulo, publicacao, descricao, idpai FROM public.tb_guia ";
	}

	@Override
	public String getDeleteStatment(Integer id) {
		return String.format(
			"DELETE FROM public.tb_guia WHERE (id = %s);",
			id.toString() 
		);
	}

	@Override
	public List<Guia> readAll() {
		List<Guia> lstGuia = new ArrayList<Guia>();
		try {
			ResultSet r = this.dm.executeQuery(this.getSelectAllStatment());
			while (r.next()) {
				Guia guia = new Guia();
				guia.setId(r.getInt("id"));
				guia.setDescricao(r.getString("descricao"));
				guia.setTitle(r.getString("titulo"));
				guia.setPublication(r.getTimestamp("publicacao"));
				guia.setIdPai(r.getInt("idpai"));
				lstGuia.add(guia);
			}
		} catch (SQLException e) {
			lstGuia = null;
			e.printStackTrace();
		}		
		return lstGuia;
	}

	public List<Guia> readChildsOf(Integer idPai) {
		List<Guia> lstGuia = new ArrayList<Guia>();
		try {
			ResultSet r = this.dm.executeQuery(this.getSelectStatmentChildsOf(idPai));
			while (r.next()) {
				Guia guia = new Guia();
				guia.setId(r.getInt("id"));
				guia.setDescricao(r.getString("descricao"));
				guia.setTitle(r.getString("titulo"));
				guia.setPublication(r.getTimestamp("publicacao"));
				guia.setIdPai(r.getInt("idpai"));
				lstGuia.add(guia);
			}
		} catch (SQLException e) {
			lstGuia = null;
			e.printStackTrace();
		}		
		return lstGuia;
	}
}