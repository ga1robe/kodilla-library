package com.crud.library.domain.dto;

import com.crud.library.domain.RentalStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookCopyDto {

    private Long id;
    private Long bookId;
    private RentalStatus rentalStatus;
}
