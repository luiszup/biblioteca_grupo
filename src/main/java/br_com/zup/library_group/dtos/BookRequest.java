package br_com.zup.library_group.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record BookRequest(
        @NotBlank(message= "Title cannot be empty")
        String title,
        @NotBlank(message= "Author cannot be empty")
        String author,
        @Pattern(regexp = "^(19|20)\\d{2}$", message = "The publication year must be between 1900 and 2099.")
        int publicationYear,

        Genre genre
) {

}
