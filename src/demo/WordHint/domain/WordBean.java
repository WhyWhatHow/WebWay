package demo.WordHint.domain;

public class WordBean {

	private int id;
	private String word;
	@Override
	public String toString() {
		return "WordBean [id=" + id + ", word=" + word + "]";
	}
	public WordBean(int id, String word) {
		super();
		this.id = id;
		this.word = word;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public WordBean() {
		super();
	}

}
