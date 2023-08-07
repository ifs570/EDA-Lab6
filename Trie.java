class Trie {
	private TrieNode root;

	public Trie() {
		this.root = new TrieNode();
	}

	public Trie(String text) {
		this.root = new TrieNode();

		String[] palabras = text.split("\\s+");
		for (String palabra : palabras) {
			if (!palabra.isEmpty())
				insert(palabra);
		}
	}

	public void insert(String word) {
		TrieNode current = root;
		for (char c : word.toCharArray()) {
			if (current.getChild(c) == null) {
				current.setChild(c, new TrieNode());
			}
			current = current.getChild(c);
		}
		current.setIsEndWord(true);
	}

	public void delete(String word) {
		TrieNode current = root;
		TrieNode[] parents = new TrieNode[word.length()];
		char[] chars = word.toCharArray();

		for (int i = 0; i < chars.length; i++) {
			parents[i] = current;
			current = current.getChild(chars[i]);
			if (current == null) {
				return;
			}
		}

		if (current.isEndWord()) {
			current.setIsEndWord(false);
		}

		for (int i = chars.length - 1; i >= 0; i--) {
			if (current.getChildrenLength() > 0 || current.isEndWord()) {
				break;
			}
			parents[i].setChild(chars[i], null);
			current = parents[i];
		}
	}

	public void replace(String palabraVieja, String palabraNueva) {
		if (search(palabraVieja)) {
			delete(palabraVieja);
			insert(palabraNueva);
		}

	}

	public boolean search(String word) {
		TrieNode current = root;
		for (char c : word.toCharArray()) {
			if (current.getChild(c) == null) {
				return false;
			}
			current = current.getChild(c);
		}
		return current.isEndWord();
	}

	public boolean startsWith(String prefix) {
		TrieNode current = root;
		for (char c : prefix.toCharArray()) {
			current = current.getChild(c);
			if (current == null) {
				return false;
			}
		}
		return true;
	}

	public boolean isEmpty() {
		for (int i = 0; i < this.root.getChildrenLength(); i++) {
			if (root.getChild((char) i) != null) {
				return false;
			}
		}

		return true;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		collectWords(root, new StringBuilder(), result);
		return result.toString();
	}

	private void collectWords(TrieNode node, StringBuilder currentWord, StringBuilder result) {
		if (node == null) {
			return;
		}

		if (node.isEndWord()) {
			result.append(currentWord).append(" ");
		}

		for (char c = 0; c < node.getChildrenLength(); c++) {
			TrieNode child = node.getChild(c);
			if (child != null) {
				currentWord.append(c);
				collectWords(child, currentWord, result);
				currentWord.deleteCharAt(currentWord.length() - 1);
			}
		}
	}
}
