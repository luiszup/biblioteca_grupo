package br_com.zup.library_group.dtos;

public enum Genre {
    FICTION,
    NON_FICTION,
    SCIENCE,
    HISTORY,
    FANTASY;

    public static Genre fromString(String string) {
        for (Genre genre : Genre.values()) {
            if (genre.name().equals(string))
                return genre;
        }
        throw new IllegalArgumentException("Invalid Genre");
    }
}
