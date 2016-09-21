package base;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;



public class Folder implements Comparable<Folder>{
	private ArrayList<Note> notes;
	private String name;
	
	public Folder(String name) {
		this.name = name;
		notes = new ArrayList<Note>();
	}
	
	public void addNote(Note note) {
		notes.add(note);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Folder other = (Folder) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public ArrayList<Note> getNotes() {
		return notes;
	}
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		int nText = 0;
		int nImage = 0;
		for (int i = 0; i < notes.size(); i++) {
			if (notes.get(i) instanceof TextNote) {
				nText++;
			} else if (notes.get(i) instanceof ImageNote) {
				nImage++;
			}
		}
		return name + ":" + nText + ":" + nImage;
	}

	@Override
	public int compareTo(Folder o) {
		// TODO Auto-generated method stub
		return this.name.compareTo(o.name);
		
	}
	public void sortNotes(){

		Collections.sort(notes);
	}
	public List<Note> searchNotes(String keywords) {
		String key = keywords.toLowerCase();
		String[] list = key.split(" ");
		ArrayList<ArrayList<String>> orList = new ArrayList<ArrayList<String>>();
		ArrayList<Note> returnNote = new ArrayList<Note>();
		int it = 0; 
		while (it < list.length) {
			if (list[it].toLowerCase().equals("or")){
				ArrayList<String> temp = new ArrayList<String>();
				temp.add(list[it-1]);
				temp.add(list[it+1]);
				int index = it;
				while (index + 2 < list.length && list[index + 2].toLowerCase().equals("or")) {
					temp.add(list[index + 3]);
					index+=2;
				}
				it = index;
				orList.add(temp);
			}
			it++;
		}
		
		for (int i = 0; i < notes.size(); i++) {
			boolean allTrue = true;
			for (int j = 0; j < orList.size(); j++) {
				
				allTrue = notes.get(i).containsOr(orList.get(j));
			}
			if (allTrue)
				returnNote.add(notes.get(i));
				
		}
		
		return returnNote;
	}
	/*public List<Note> searchNotes(String keywords){
		String key = keywords.toLowerCase();
		String keys[] = key.split(" ");
		ArrayList<Note> result= new ArrayList<Note>();
		int j=0;
		int i=0;
		
			
			if(keys[i+1] == "or"){
				for(Note n:notes){
					if(n instanceof ImageNote){
						if(n.getTitle().contains(keys[i])==true||n.getTitle().contains(keys[i+2])==true){
							result.add(n);
						}
					}
					if(n instanceof TextNote){
						if(n.getTitle().contains(keys[i])==true||n.getTitle().contains(keys[i+2])==true){
							result.add(n);
						}
					}
				}
				i=i+2;	
			}
			else {
				for(Note n:notes){
					if(n instanceof ImageNote){
						if(n.getTitle().contains(keys[i])==true){
							result.add(n);
						}
					}
					else if(n instanceof TextNote){
						if(n.getTitle().contains(keys[i])==true){
							result.add(n);
						}
					}
				}
				i++;
			}
		
			while(keys[i]!=null){
				if(keys[i+1]=="or"){
					
				}
				else{
					
					for(int r=0; r<result.size();r++){
						
						if(result.get(r).getTitle().contains(keys[i])==true){continue;}
						else result.set(r, null);
					}
				}
			}
		
		
		
		return result;
	}*/
}