package com.crud.library.repository;

import com.crud.library.domain.BookCopy;
import com.crud.library.domain.RentalStatus;
import com.crud.library.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BookCopyRepository extends CrudRepository<BookCopy, Long> {

    @Override
    List<BookCopy> findAll();

    @Override
    BookCopy save(BookCopy bookCopy);

    @Override
    Optional<BookCopy> findById(Long id);

    @Override
    void deleteById(Long id);
}
