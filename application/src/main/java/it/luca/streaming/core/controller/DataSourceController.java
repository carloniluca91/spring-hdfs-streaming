package it.luca.streaming.core.controller;

import it.luca.streaming.core.dto.DataSourceResponseDto;
import it.luca.streaming.core.service.IngestionService;
import it.luca.streaming.data.model.int002.Int002Specification;
import it.luca.streaming.data.model.jarvis.JarvisSpecification;
import it.luca.streaming.data.model.webdisp.WebdispSpecification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/source")
public class DataSourceController {

    @Autowired
    private IngestionService service;

    /**
     * Receive and store data for dataSource Webdisp
     * @param string input data
     * @return ResponseEntity with small ingestion operation report
     */

    @PostMapping("/webdisp")
    public ResponseEntity<DataSourceResponseDto> webdisp(@RequestBody String string) {

        WebdispSpecification webdispSpecification = new WebdispSpecification();
        return new ResponseEntity<>(service.store(string, webdispSpecification), HttpStatus.OK);
    }

    /**
     * Receive and store data for dataSource Jarvis
     * @param string input data
     * @return ResponseEntity with small ingestion operation report
     */

    @PostMapping("/jarvis")
    public ResponseEntity<DataSourceResponseDto> jarvis(@RequestBody String string) {

        JarvisSpecification jarvisSpecification = new JarvisSpecification();
        return new ResponseEntity<>(service.store(string, jarvisSpecification), HttpStatus.OK);
    }

    /**
     * Receive and store data for dataSource Int002
     * @param string input data
     * @return ResponseEntity with small ingestion operation report
     */

    @PostMapping("/int002")
    public ResponseEntity<DataSourceResponseDto> int002(@RequestBody String string) {

        Int002Specification int002Specification = new Int002Specification();
        return new ResponseEntity<>(service.store(string, int002Specification), HttpStatus.OK);
    }
}
