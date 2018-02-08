package br.ufs.dcomp.guia.container;

public class ContentIterator implements IContentIterator {
    private int position;
    private Container container;

    public ContentIterator(Container container) {
        this.container = container;
        this.position = -1;
    }

	@Override
	public boolean hasNext() {
		return this.position >= this.container.getChilds().size() ? false : true;
	}

	@Override
	public Content next() {
        this.position++;
		return this.container.getChilds().get(this.position);
	}

	@Override
	public Content first() {
        this.position = -1;
		return this.next();
	}

}