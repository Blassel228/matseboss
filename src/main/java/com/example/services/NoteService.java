package com.example.services;

import com.example.dtos.NoteResponse;
import com.example.models.Note;
import com.example.repositories.AuthorRepository;
import com.example.repositories.NoteRepository;
import com.example.dtos.NoteRequest;
import com.example.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteService {

    private final NoteRepository noteRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository, AuthorRepository authorRepository) {
        this.noteRepository = noteRepository;
        this.authorRepository = authorRepository;
    }

    public NoteResponse createNote(NoteRequest noteRequest) {
        Author author = authorRepository.findById(noteRequest.getAuthorId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found"));

        Note note = new Note(noteRequest.getTitle(), noteRequest.getContent(), LocalDateTime.now(), author);
        Note savedNote = noteRepository.save(note);

        return new NoteResponse(savedNote.getId(), savedNote.getTitle(), savedNote.getContent(), savedNote.getCreatedAt(), savedNote.getAuthor().getId());
    }

    public List<NoteResponse> getAllNotes() {
        List<Note> notes = noteRepository.findAll();
        return notes.stream()
                .map(note -> new NoteResponse(note.getId(), note.getTitle(), note.getContent(), note.getCreatedAt(), note.getAuthor().getId()))
                .collect(Collectors.toList());
    }

    public NoteResponse getNoteById(Long id) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Note not found"));
        return new NoteResponse(note.getId(), note.getTitle(), note.getContent(), note.getCreatedAt(), note.getAuthor().getId());
    }

    public void deleteNote(Long id) {
        if (!noteRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Note not found");
        }
        noteRepository.deleteById(id);
    }
}
