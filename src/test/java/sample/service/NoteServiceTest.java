package sample.service;

import org.junit.Before;
import org.junit.Test;
import sample.db.DataBase;
import sample.model.Note;
import sample.model.Visit;

import static org.junit.Assert.*;

public class NoteServiceTest {

    private NoteService noteService;

    @Before
    public void setup() {
        noteService = new NoteService();

        DataBase.getInstance().getNoteList().clear();
        DataBase.getInstance().getNoteList().add(new Note(1, "note"));
    }

    @Test
    public void generateIdEquals() {
        assertEquals(2, noteService.generateNoteId());
    }

    @Test
    public void generateIdNotEquals() {
        assertNotEquals(1, noteService.generateNoteId());
    }

    @Test
    public void findByIdNotNull() {
        assertNotNull(noteService.findById(1));
    }

    @Test
    public void findByIdNull() {
        assertNull(noteService.findById(null));
    }

    @Test
    public void addNoteTrue() {
        Visit visit = new Visit();
        String noteString = "test";

        assertTrue(noteService.addNote(visit, noteString));
    }

    @Test
    public void addNoteFalse() {
        Visit visit = null;
        String noteString = "test";

        assertFalse(noteService.addNote(visit, noteString));
    }
}