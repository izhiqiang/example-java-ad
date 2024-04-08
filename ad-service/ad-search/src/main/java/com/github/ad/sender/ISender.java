package com.github.ad.sender;

import com.github.ad.mysql.dto.MySqlRowData;

public interface ISender {
    void sender(MySqlRowData rowData);
}
