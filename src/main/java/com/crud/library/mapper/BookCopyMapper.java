package com.crud.library.mapper;

import com.crud.library.domain.BookCopy;
import com.crud.library.domain.dto.BookCopyDto;
import com.crud.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookCopyMapper {

    @Autowired
    private BookRepository bookRepository;

    public BookCopy mapToBookCopies(final BookCopyDto bookCopyDto) {
        return new BookCopy(
                bookCopyDto.getId(),
                bookRepository.findById(bookCopyDto.getBookId()).get(),
                bookCopyDto.getRentalStatus());
    }

    public BookCopyDto mapToBookCopiesDto(final BookCopy bookCopy) {
        return new BookCopyDto(
                bookCopy.getId(),
                bookCopy.getBook().getId(),
                bookCopy.getRentalStatus());
    }

    public List<BookCopyDto> mapToBookCopiesDtoList(final List<BookCopy> bookCopyList) {
        return bookCopyList.stream()
                .map(t -> new BookCopyDto(t.getId(), t.getBook().getId(), t.getRentalStatus()))
                .collect(Collectors.toList());
    }
}
