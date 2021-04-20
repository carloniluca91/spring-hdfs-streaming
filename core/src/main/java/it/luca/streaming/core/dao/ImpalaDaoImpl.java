package it.luca.streaming.core.dao;

import com.cloudera.impala.jdbc.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class ImpalaDaoImpl {

    @Value("${jdbc.impala.url}")
    private String impalaJdbcUrl;

    @Value("${jdbc.impala.driver}")
    private String impalaJdbcDriver;

    private Jdbi impalaJdbi;

    @PostConstruct
    private void initJdbi() throws ClassNotFoundException {

        Class.forName(impalaJdbcDriver);
        DataSource dataSource = new com.cloudera.impala.jdbc.DataSource();
        dataSource.setURL(impalaJdbcUrl);
        impalaJdbi = Jdbi.create(dataSource).installPlugin(new SqlObjectPlugin());
        log.info("Instantiated {} for Impala connection", Jdbi.class.getSimpleName());
    }
}
