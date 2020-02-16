package com.xuecheng.search.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticsearchConfig01 {
    @Value("${xuecheng.elasticsearch.hostlist}")
    private static String hostlist;
    @Bean
    public RestClient restClient(){
        String[] split = hostlist.split(",");
        HttpHost[] arr = new HttpHost[split.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new HttpHost(split[i].split(":")[0],Integer.parseInt(split[i].split(":")[1]),"http");
        }
        return RestClient.builder(arr).build();
    }
}
