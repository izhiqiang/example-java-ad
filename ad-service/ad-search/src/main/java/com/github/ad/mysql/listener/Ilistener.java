package com.github.ad.mysql.listener;

import com.github.ad.mysql.dto.BinlogRowData;

public interface Ilistener {
    void register();

    void onEvent(BinlogRowData eventData);
}
