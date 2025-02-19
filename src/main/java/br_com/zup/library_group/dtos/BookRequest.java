package br_com.zup.library_group.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record BookRequest(
        @NotBlank(message = "Title cannot be empty")
        String title,
        @NotBlank(message = "Author cannot be empty")
        String author,
        int publicationYear,
        @NotBlank
        String genre
) {

}
