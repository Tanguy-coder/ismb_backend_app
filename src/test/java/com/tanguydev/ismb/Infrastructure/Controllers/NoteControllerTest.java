package com.tanguydev.ismb.Infrastructure.Controllers;

import com.tanguydev.ismb.Domain.Entity.DomainNote;
import com.tanguydev.ismb.Domain.Presenter.NotePresenterInterface;
import com.tanguydev.ismb.Domain.Response.NoteResponse;
import com.tanguydev.ismb.Domain.UseCases.Notes.CreateNoteUseCaseInterface;
import com.tanguydev.ismb.Domain.UseCases.Notes.FindNoteByParamsUseCaseInterface;
import com.tanguydev.ismb.Domain.UseCases.Notes.UpdateNoteUseCaseInterface;
import com.tanguydev.ismb.Infrastructure.Mapper.NoteMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(NoteController.class)
class NoteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CreateNoteUseCaseInterface create;

    @MockBean
    private FindNoteByParamsUseCaseInterface find;

    @MockBean
    private UpdateNoteUseCaseInterface update;

    @MockBean
    private NotePresenterInterface presenter;

    @MockBean
    private NoteMapper mapper;

    @Test
    @DisplayName("POST /api/notes - doit retourner 200 OK avec une liste vide (squelette)")
    void createNotes_returnsOk() throws Exception {
        Mockito.when(mapper.toDomainList(anyList())).thenReturn(Collections.emptyList());
        Mockito.when(create.execute(anyList())).thenReturn(Collections.emptyList());
        Mockito.when(presenter.presentList(anyList())).thenReturn(Collections.emptyList());

        String json = "[]";
        mockMvc.perform(post("/api/notes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("GET /api/notes - doit retourner 200 OK (squelette)")
    void getNotes_returnsOk() throws Exception {
        Mockito.when(find.findByParams(anyLong(), anyLong(), anyLong(), anyString(), anyInt()))
                .thenReturn(Collections.<DomainNote>emptyList());
        Mockito.when(presenter.presentList(anyList())).thenReturn(Collections.<NoteResponse>emptyList());

        mockMvc.perform(get("/api/notes")
                        .param("anneeId", "1")
                        .param("filiereId", "1")
                        .param("ueId", "1")
                        .param("session", "N")
                        .param("periode", "1"))
                .andExpect(status().isOk());
    }
}
