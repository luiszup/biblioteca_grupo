package br_com.zup.library_group.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record BookRequest(
        @NotBlank(message= "Title cannot be empty")
        String title,
        @NotBlank(message= "Author cannot be empty")
        String author,
        @NotNull(message= "The year of publication cannot be null")
        LocalDate publicationYear,

}
