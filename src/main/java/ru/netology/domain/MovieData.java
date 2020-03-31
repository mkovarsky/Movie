package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MovieData {
    private int id;
    private String title;
    private String genre;
}
