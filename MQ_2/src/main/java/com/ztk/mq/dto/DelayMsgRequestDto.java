package com.ztk.mq.dto;

import lombok.Data;

@Data
public class DelayMsgRequestDto {
    private String msg;
    private String topic;
    private String keys;
    private String tag;
    private long delayMs = 0l;
}
