package com.example.controller;

import com.example.service.google.GoogleDriveApiClient;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private GoogleDriveApiClient googleDriveApiClient;

    @RequestMapping("/user")
    public Map<String, String> user(@AuthenticationPrincipal OAuth2User principal) {
        Map<String, String> data = new HashMap<>();
        data.put("name", principal.getAttribute("name"));
        data.put("email", principal.getAttribute("email"));
        data.put("picture", principal.getAttribute("picture"));
        return data;
    }

    @RequestMapping("/files")
    public Map<String, Object> files () {
        return googleDriveApiClient.getFiles();
    }
}
