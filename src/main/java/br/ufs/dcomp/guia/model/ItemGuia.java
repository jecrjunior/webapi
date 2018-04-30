package br.ufs.dcomp.guia.model;

import br.ufs.dcomp.guia.container.ILeaf;

public class ItemGuia implements IModel{
    private Integer id;
    private String titulo;
    private String conteudo;
    private Integer idPai;
    private ILeaf itemGuia;

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
	public String getTitulo() {
		return titulo;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitulo(String title) {
		this.titulo = title;
	}
	/**
	 * @return the content
	 */
	public String getConteudo() {
		return conteudo;
	}
	/**
	 * @param content the content to set
	 */
	public void setConteudo(String content) {
		this.conteudo = content;
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
	 * @return the itemGuia
	 */
	public ILeaf getItemGuia() {
		return itemGuia;
	}
	/**
	 * @param itemGuia the itemGuia to set
	 */
	public void setItemGuia(ILeaf itemGuia) {
		this.itemGuia = itemGuia;
	}
}