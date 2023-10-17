package com.socialbridge.notifications.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {
    @GetMapping
    public void consumeMessage() {

    }
}
