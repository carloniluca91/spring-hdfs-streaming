package it.luca.streaming.core.controller;

import it.luca.streaming.core.model.ControllerResponse;
import it.luca.streaming.core.service.SourceService;
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
public class SourceController {

    @Autowired
    private SourceService sourceService;

    /**
     * Receive and store data for dataSource Webdisp
     * @param string input data
     * @return ResponseEntity with small ingestion operation report
     */

    @PostMapping("/webdisp")
    public ResponseEntity<ControllerResponse> webdisp(@RequestBody String string) {

        WebdispSpecification webdispSpecification = new WebdispSpecification();
        return new ResponseEntity<>(sourceService.store(string, webdispSpecification), HttpStatus.OK);
    }

    /**
     * Receive and store data for dataSource Jarvis
     * @param string input data
     * @return ResponseEntity with small ingestion operation report
     */

    @PostMapping("/jarvis")
    public ResponseEntity<ControllerResponse> jarvis(@RequestBody String string) {

        JarvisSpecification jarvisSpecification = new JarvisSpecification();
        return new ResponseEntity<>(sourceService.store(string, jarvisSpecification), HttpStatus.OK);
    }
}
