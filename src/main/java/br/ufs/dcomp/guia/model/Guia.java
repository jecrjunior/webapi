package br.ufs.dcomp.guia.model;

import java.util.Date;
import br.ufs.dcomp.guia.container.IContainer;

public class Guia implements IModel{
    private Integer id;
    private String title;
    private Date publication;
    private String descricao;
    private Integer idPai;
    private IContainer guia;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the publication
	 */
	public Date getPublication() {
		return publication;
	}
	/**
	 * @param publication the publication to set
	 */
	public void setPublication(Date publication) {
		this.publication = publication;
	}
	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}
	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	/**
	 * @return the idPai
	 */
	public Integer getIdPai() {
		return idPai;
	}
	/**
	 * @param idPai the idPai to set
	 */
	public void setIdPai(Integer idPai) {
		this.idPai = idPai;
	}
	/**
	 * @return the guia
	 */
	public IContainer getGuia() {
		return guia;
	}
	/**
	 * @param guia the guia to set
	 */
	public void setGuia(IContainer guia) {
		this.guia = guia;
	}
}