package sample.service;

import sample.db.DataBase;
import sample.model.Note;
import sample.model.Visit;

public class NoteService {

    public int generateNoteId() {
        return DataBase.getInstance().getNoteList().size() + 1;
    }

    public Note findById(Integer noteId) {
        for (Note element : DataBase.getInstance().getNoteList()){
            if (element.getId().equals(noteId)) return element;
        }
        return null;
    }

    public boolean addNote(Visit visit, String noteString) {
        if (visit != null && noteString != null) {
            Note note = new Note(generateNoteId(), noteString);
            DataBase.getInstance().getNoteList().add(note);

            visit.setNoteId(note.getId());
            return true;
        }
        return false;
    }
}
