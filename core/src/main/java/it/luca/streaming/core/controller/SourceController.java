package it.luca.streaming.core.controller;

import it.luca.streaming.data.model.Bancll01Avro;
import it.luca.streaming.data.model.PeopleWrapper;
import it.luca.streaming.core.service.SourceService;
import it.luca.streaming.core.utils.DatePattern;
import it.luca.streaming.core.utils.Utils;
import it.luca.streaming.data.enumeration.DataSourceId;
import it.luca.streaming.core.repository.SourceSpecification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

import static it.luca.streaming.core.utils.Utils.now;

@Slf4j
@RestController
@RequestMapping("/api/v1/source")
public class SourceController {

    @Value("${jdbc.table.prefix}")
    private String tableNamePrefix;

    @Autowired
    private SourceService sourceService;

    private String tableName(DataSourceId dataSourceId) {

        return tableNamePrefix.toLowerCase() + dataSourceId.name().toLowerCase();
    }

    @PostMapping("/bancll01")
    public ResponseEntity<HttpStatus> people(@RequestBody String string) {

        BiFunction<PeopleWrapper, String, List<Bancll01Avro>> avroFunction = (peopleWrapper, s) ->
                peopleWrapper.getPeople().stream().map(person -> Bancll01Avro.newBuilder()
                        .setFirstName(person.getFirstName())
                        .setLastName(person.getLastName())
                        .setBirthDate(person.getBirthDate())
                        .setInsertTs(Utils.now(DatePattern.DEFAULT_TIMESTAMP))
                        .setInsertDt(Utils.now(DatePattern.DEFAULT_DATE))
                        .build()
                ).collect(Collectors.toList());

        Function<PeopleWrapper, List<String>> partitioningFunction = peopleWrapper -> Collections.singletonList(peopleWrapper.getDtBusinessDate());
        SourceSpecification<PeopleWrapper, Bancll01Avro, String> sourceSpecification = SourceSpecification
                .<PeopleWrapper, Bancll01Avro, String>builder()
                .dataSourceId(DataSourceId.BANCLL_01)
                .tClass(PeopleWrapper.class)
                .avroClass(Bancll01Avro.class)
                .tableName(tableName(DataSourceId.BANCLL_01))
                .partitionColumn("dt_business_date")
                .partitionColumnType("string")
                .avroSchemaFile("bancll01.avsc")
                .partitionValuesFunction(partitioningFunction)
                .partitionValueRecords(avroFunction)
                .build();

        sourceService.store(string, sourceSpecification);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
