package br.ufs.dcomp.guia.container;

import java.util.List;

public class Container extends Content implements IContainer{
    private List<Content> childs;

	/**
	 * @return the childs
	 */
	public List<Content> getChilds() {
		return childs;
	}

	/**
	 * @param childs the childs to set
	 */
	public void setChilds(List<Content> childs) {
		this.childs = childs;
	}
}