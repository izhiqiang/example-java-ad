package com.github.ad.mysql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//参考ad-service/ad-search/src/main/resources/binlog_jsontable.json
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonTable {
    private String tableName;
    private String level;

    private List<Column> insert;
    private List<Column> update;
    private List<Column> delete;
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Column {
        private String column;
    }
}
