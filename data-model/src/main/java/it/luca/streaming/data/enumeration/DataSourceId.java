package it.luca.streaming.data.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DataSourceId {

    INT002(DataSourceType.JSON),
    JARVIS(DataSourceType.XML),
    WEBDISP(DataSourceType.XML);

    private final DataSourceType dataSourceType;
}

