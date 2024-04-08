package com.github.ad.mysql.constant.OpType;

import com.github.ad.mysql.dto.TableTemplate;
import com.github.shyiko.mysql.binlog.event.EventType;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class BinlogRowData {
    private TableTemplate table;

    private EventType eventType;

    private List<Map<String, String>> after;

    private List<Map<String, String>> before;
}
