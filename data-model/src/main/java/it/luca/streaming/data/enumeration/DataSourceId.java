package it.luca.streaming.data.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DataSourceId {

    BANCLL_01(DataSourceType.XML);

    private final DataSourceType dataSourceType;
}

