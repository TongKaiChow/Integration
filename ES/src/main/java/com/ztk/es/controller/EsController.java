package com.ztk.es.controller;

import lombok.RequiredArgsConstructor;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.web.bind.annotation.RestController;

@RestController("/es")
@RequiredArgsConstructor
public class EsController {
    private final RestHighLevelClient restHighLevelClient;


}
