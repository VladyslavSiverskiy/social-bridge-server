package com.socialbridge.notifications.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void sentNotification() {
        System.out.println("Sending a notification...");
    }

}
