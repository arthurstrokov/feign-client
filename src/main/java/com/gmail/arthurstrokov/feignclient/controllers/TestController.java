package com.gmail.arthurstrokov.feignclient.controllers;

import com.gmail.arthurstrokov.feignclient.gateway.TestFeignClient;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Артур Александрович Строков
 * @email astrokov@clevertec.ru
 * @created 26.10.2022
 */
@RestController
@RequiredArgsConstructor
public class TestController {

    private final RestTemplate restTemplate;
    private final EurekaClient eurekaClient;
    private final TestFeignClient testFeignClient;

    @GetMapping
    public String getConfig() {
        InstanceInfo instanceInfo = eurekaClient
                .getApplication("cloud-configuration-server")
                .getInstances()
                .get(0);
        String hostName = instanceInfo.getHostName();
        int port = instanceInfo.getPort();
        String instanceId = instanceInfo.getInstanceId();
        System.out.println(hostName);
        System.out.println(port);
        System.out.println(instanceId);

        System.out.println(eurekaClient.getApplication("cloud-configuration-server"));

        ResponseEntity<String> albumsResponse = restTemplate.exchange("http://cloud-configuration-server:8888/", HttpMethod.GET, null, String.class);
        System.out.println("---");
        System.out.println(albumsResponse);
        return testFeignClient.getConfig();
    }
}
