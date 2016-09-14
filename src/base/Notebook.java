package base;

import java.util.ArrayList;

public class NoteBook {
	private ArrayList<Folder> folders;
	public NoteBook(){
		ArrayList<Folder> folders = new ArrayList<Folder>();
	}
	public boolean createTextNote(String folderName, String title){
		TextNote note = new TextNote(title);
		return insertNote(folderName, title);
	}
	private boolean insertNote(String folderName, String title) {
		// TODO Auto-generated method stub
		for (Folder f: folders){
			if(f.getName()==folders.)
		}
		return false;
	}
	public boolean createImageNote(String folderName, String title){
		ImageNote note= new ImageNote(title);
		return insertNote(folderName, title);
	}
	public ArrayList<Folder> getFolders(){
		return folders;
	}
}