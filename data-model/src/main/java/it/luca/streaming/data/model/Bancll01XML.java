package it.luca.streaming.data.model;

import lombok.Data;

import java.util.List;

@Data
public class Bancll01XML {

    private String dtBusinessDate;
    private List<Person> people;
}
