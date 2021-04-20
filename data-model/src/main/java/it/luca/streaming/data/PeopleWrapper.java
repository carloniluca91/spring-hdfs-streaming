package it.luca.streaming.data;

import lombok.Data;

import java.util.List;

@Data
public class PeopleWrapper {

    private String dtBusinessDate;
    private List<Person> people;
}
