package br.ufs.dcomp.guia.model;

import java.util.Date;

public class Acesso implements IModel{
    private Integer id;
    private Integer usuario;
    private Integer itemGuia;
    private Date momento;
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
	 * @return the usuario
	 */
	public Integer getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}
	/**
	 * @return the itemGuia
	 */
	public Integer getItemGuia() {
		return itemGuia;
	}
	/**
	 * @param itemGuia the itemGuia to set
	 */
	public void setItemGuia(Integer itemGuia) {
		this.itemGuia = itemGuia;
	}
	/**
	 * @return the momento
	 */
	public Date getMomento() {
		return momento;
	}
	/**
	 * @param momento the momento to set
	 */
	public void setMomento(Date momento) {
		this.momento = momento;
	}
}