package br_com.zup.library_group.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record BookRequest(
        @NotBlank(message = "Title cannot be empty")
        String title,
        @NotBlank(message = "Author cannot be empty")
        String author,
        @Pattern(regexp = "^(19|20)\\d{2}$", message = "The publication year must be between 1900 and 2099.")
        int publicationYear,
        @NotBlank
        String genre
) {

}
