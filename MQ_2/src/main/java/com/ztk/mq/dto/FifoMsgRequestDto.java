package com.ztk.mq.dto;

import lombok.Data;

@Data
public class FifoMsgRequestDto {
    private String msg;
    private String topic;
    private String keys;
    private String tag;
    private String msgGroup;
}
