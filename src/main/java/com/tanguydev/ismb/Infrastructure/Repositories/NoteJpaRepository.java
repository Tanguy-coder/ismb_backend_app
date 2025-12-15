package com.tanguydev.ismb.Infrastructure.Repositories;

import com.tanguydev.ismb.Infrastructure.Models.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepositoryJpaRepository extends JpaRepository<Note, Long> {
}
