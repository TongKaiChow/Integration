
package com.ztk.client.feignclient;


import com.ztk.client.feignclient.hystrixclient.MqFeignClientFallback;
import com.ztk.client.feignclient.hystrixclient.MqFeignClientFallbackFactory;
import com.ztk.mq_common.vo.DelayMsgRequestDto;
import org.apache.rocketmq.client.apis.ClientException;
import org.apache.rocketmq.client.apis.producer.SendReceipt;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * value-eureka注册应用服务名(小写，eureka中心显示大写),path-映射服务的base-url(Controller上的requestMapping)
 * fallback=后备箱处理类，fallbackFactory=后备工厂类（调用目标服务方法失败后，调用的方法）二选一
 * configuration属性,当前feignClient配置ribbon
 * defaultConfiguration用在启动类@EnableFeignCLients，全局feignClient配置ribbon
 */
@FeignClient(value = "mq", path = "/mq", fallback = MqFeignClientFallback.class, fallbackFactory = MqFeignClientFallbackFactory.class)
public interface MqFeignClient {
    /**
     * 远程服务的方法体
     */
    @PostMapping("/delay/send")
    SendReceipt sendDelayMsg(@RequestBody DelayMsgRequestDto requestDto) throws ClientException;
}
