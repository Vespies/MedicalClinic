package sample.service;

import sample.db.DataBase;
import sample.model.Note;

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
}
