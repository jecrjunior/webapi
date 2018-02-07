package br.ufs.dcomp.guia.container;

public class ContentIterator implements IContentIterator {
    
    private Container container;

    public ContentIterator(Container container) {
        this.container = container;
    }

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public Content next() {
		return null;
	}

}