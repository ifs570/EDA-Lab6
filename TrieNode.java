class TrieNode {
	private TrieNode[] children;
	private boolean isEndWord;

	public TrieNode() {
		this.children = new TrieNode[255];
		this.isEndWord = false;
	}

	public boolean isEndWord() {
		return this.isEndWord;
	}

	public void setIsEndWord(boolean isEndWord) {
		this.isEndWord = isEndWord;
	}

	public TrieNode getChild(char c) {
		return this.children[c];
	}

	public void setChild(char c, TrieNode node) {
		this.children[c] = node;
	}

	public int getChildrenLength() {
		return this.children.length;
	}
}
