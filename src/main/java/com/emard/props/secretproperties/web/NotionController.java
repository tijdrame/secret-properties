package com.emard.props.secretproperties.web;

import java.util.Map;

import com.emard.props.secretproperties.config.NotionConfigProperties;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class NotionController {

    private final NotionConfigProperties notionConfig;

    @GetMapping("/notion")
    public Map<String, String> printAllProps() {
        return Map.of("apiUrl", notionConfig.getApiUrl(), "apiVersion", notionConfig.getApiVersion(), "authToken",
                notionConfig.getAuthToken(), "databaseId", notionConfig.getDatabaseId());
    }

}
