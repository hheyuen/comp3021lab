package base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NoteBook {
	private ArrayList<Folder> folders;

	public NoteBook() {
		this.folders = new ArrayList<Folder>();
	}
	
	public boolean createTextNote(String folderName, String title) {
		TextNote note = new TextNote(title);
		return insertNote(folderName, note);
	}
	public boolean createTextNote (String folderName, String title, String content) {
		TextNote note = new TextNote(title, content);
		return insertNote(folderName, note);
	}
	private boolean insertNote(String folderName, Note note) {
		Folder f = null;
		for (Folder f1 : folders) {
			if (f1.equals(new Folder(folderName))){
				f = f1;
			}
		}
		if (f == null) {
			f  = new Folder(folderName);
			folders.add(f);
		}
		for (Note n : f.getNotes()) {
			if (n.equals(note)) {
				System.out.println("Creating note " + n.getTitle() + " under folder " + folderName + " failed");
				return false;
			}
		}
				f.getNotes().add(note);
		return true;
	}

	public boolean createImageNote(String folderName, String title) {
		ImageNote note = new ImageNote(title);
		return insertNote(folderName, note);
	}
	
	public ArrayList<Folder> getFolders() {
		return folders;
	}
	
	public void sortFolders(){
		Collections.sort(folders);
	}
	public List<Note> searchNotes (String keywords) {
		ArrayList<Note> temp = new ArrayList<Note>();
		for (int i = 0; i < folders.size(); i ++) {
			temp.addAll(folders.get(i).searchNotes(keywords));
		}
		return temp;
	}
}