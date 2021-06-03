package com.crud.library.mapper;

import com.crud.library.domain.BorrowedBook;
import com.crud.library.domain.dto.BorrowedBookDto;
import com.crud.library.repository.BookCopyRepository;
import com.crud.library.repository.BookRepository;
import com.crud.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BorrowedBookMapper {

    @Autowired
    private BookCopyRepository bookCopyRepository;

    @Autowired
    private UserRepository userRepository;

    public BorrowedBook mapToBorrowedBook(final BorrowedBookDto borrowedBookDto) {
        return new BorrowedBook(
                borrowedBookDto.getId(),
                bookCopyRepository.findById(borrowedBookDto.getBookCopyId()).get(),
                userRepository.findById(borrowedBookDto.getUserId()).get(),
                borrowedBookDto.getBorrowedBookDate(),
                borrowedBookDto.getReturnBookDate());
    }

    public BorrowedBookDto maptoBorrowedBookDto(final BorrowedBook borrowedBook) {
        return new BorrowedBookDto(
                borrowedBook.getId(),
                borrowedBook.getBookCopy().getId(),
                borrowedBook.getUserId().getId(),
                borrowedBook.getBorrowedBookDate(),
                borrowedBook.getReturnBookDate());
    }

    public List<BorrowedBookDto> mapToBorrowedBooksDtoList(final List<BorrowedBook> borrowedBookList) {
        return borrowedBookList.stream()
                .map(t -> new BorrowedBookDto(t.getId(), t.getBookCopy().getId(), t.getUserId().getId(), t.getBorrowedBookDate(), t.getReturnBookDate()))
                .collect(Collectors.toList());
    }
}
