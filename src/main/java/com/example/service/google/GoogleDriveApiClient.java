package com.example.service.google;

import com.example.service.BaseApiClient;

import java.util.Map;

public class GoogleDriveApiClient extends BaseApiClient {

    public GoogleDriveApiClient(String accessToken) {
        super(accessToken);
    }

    public Map<String, Object> getFiles() {
        return restTemplate.getForObject(BASE_URL + "/drive/v2/files", Map.class);
    }
}
