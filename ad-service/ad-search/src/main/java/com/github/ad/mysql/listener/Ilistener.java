package com.github.ad.mysql.listener;

import com.github.ad.mysql.constant.OpType.BinlogRowData;

public interface Ilistener {
    void register();

    void onEvent(BinlogRowData eventData);
}
