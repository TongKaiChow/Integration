package com.ztk.registrycentereureka.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRenewedEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaServerStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EurekaStatusEventListener {
    @EventListener
    public void eurekaServerStartupListener(EurekaInstanceRegisteredEvent event){
        log.info("up");
    }

    @EventListener
    public void eurekaServerStartupListener(EurekaInstanceRenewedEvent event){
        log.info("renew");
    }

    @EventListener
    public void eurekaServerStartupListener(EurekaInstanceCanceledEvent event){
        log.info("cancel");
    }

    @EventListener
    public void eurekaServerStartupListener(EurekaServerStartedEvent event){
        log.info("server start");
    }
}
