package com.gmail.arthurstrokov.feignclient.gateway;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Артур Александрович Строков
 * @email astrokov@clevertec.ru
 * @created 26.10.2022
 */
@FeignClient(name = "cloud-configuration-server", url = "http://192.168.59.106:30009")
public interface TestFeignClient {

    @GetMapping
    String getConfig();
}
