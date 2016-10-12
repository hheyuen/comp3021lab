package base;

import java.util.HashMap;
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
	public Character countLetters(){
		HashMap<Character,Integer> count = new HashMap<Character,Integer>();
		String a = this.getTitle() + this.getContent();
		int b = 0;
		Character r = ' ';
		for (int i = 0; i < a.length(); i++) {
			Character c = a.charAt(i);
			if (c <= 'Z' && c >= 'A' || c <= 'z' && c >= 'a') {
				if (!count.containsKey(c)) {
					count.put(c, 1);
				} else {
					count.put(c, count.get(c) + 1);
					if (count.get(c) > b) {
						b = count.get(c);
						r = c;
					}
				}
			}
		}
		return r;
	}

	private String getContent() {
		// TODO Auto-generated method stub
		return this.content;
	}
}