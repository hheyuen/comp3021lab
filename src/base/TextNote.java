package base;

import java.util.List;

public class TextNote extends Note {
	private String content;

	public TextNote(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}
	
	public TextNote(String title, String content) {
		super(title);
		this.content = content;
	}

	
	public boolean contains(String key){
		return super.contains(key) || content.toLowerCase().contains(key.toLowerCase());
	}
	
	public boolean containsOr(List<String> keys) {
		for (int i = 0; i < keys.size(); i++){
			if (contains(keys.get(i)))
				return true;
		}
		return false;
	}
}