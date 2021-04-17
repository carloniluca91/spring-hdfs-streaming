package it.luca.streaming.controller;

import it.luca.streaming.enumeration.DataSourceId;
import it.luca.streaming.model.PeopleWrapper;
import it.luca.streaming.model.PersonAvro;
import it.luca.streaming.repository.SourceSpecification;
import it.luca.streaming.service.SourceService;
import it.luca.streaming.utils.DatePattern;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import static it.luca.streaming.utils.Utils.now;

@Slf4j
@RestController
@RequestMapping("/api/v1/source")
public class SourceController {

    @Autowired
    private SourceService sourceService;

    @PostMapping("/people")
    public ResponseEntity<HttpStatus> people(@RequestBody String string) {

        BiFunction<PeopleWrapper, String, List<PersonAvro>> avroFunction = (peopleWrapper, s) ->
                peopleWrapper.getPeople().stream().map(person -> PersonAvro.newBuilder()
                        .setFirstName(person.getFirstName())
                        .setLastName(person.getLastName())
                        .setBirthDate(person.getBirthDate())
                        .setInsertTs(now(DatePattern.DEFAULT_TIMESTAMP))
                        .setInsertDt(now(DatePattern.DEFAULT_DATE))
                        .build()
                ).collect(Collectors.toList());

        Function<PeopleWrapper, List<String>> partitioningFunction = peopleWrapper ->
                Collections.singletonList(peopleWrapper.getDtBusinessDate());
        SourceSpecification<PeopleWrapper, PersonAvro, String> sourceSpecification = SourceSpecification
                .<PeopleWrapper, PersonAvro, String>builder()
                .dataSourceId(DataSourceId.BANCLL_01)
                .tClass(PeopleWrapper.class)
                .avroClass(PersonAvro.class)
                .partitionColumn("dt_business_date")
                .partitionValuesFunction(partitioningFunction)
                .partitionValueRecords(avroFunction)
                .build();

        sourceService.store(string, sourceSpecification);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
