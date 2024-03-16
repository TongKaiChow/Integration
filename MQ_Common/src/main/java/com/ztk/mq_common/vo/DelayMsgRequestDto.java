package com.ztk.mq_common.vo;

import lombok.Data;

@Data
public class DelayMsgRequestDto {
    private String msg;
    private String topic;
    private String keys;
    private String tag;
    private long delayMs = 0l;
}
