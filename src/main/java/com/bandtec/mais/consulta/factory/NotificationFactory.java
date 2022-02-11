package com.bandtec.mais.consulta.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;

@Component
public class NotificationFactory {

    @Autowired
    private final List<NotificationAdapter> notificationAdapters;

    private final HashMap<String, NotificationAdapter> notificationAdaptersAsHashMap = new HashMap<>();

    public NotificationFactory(List<NotificationAdapter> notificationAdapters) {
        this.notificationAdapters = notificationAdapters;
    }

    @PostConstruct
    void initAdapters() {
        for (NotificationAdapter adapter : notificationAdapters) {
            notificationAdaptersAsHashMap.put(adapter.getType(), adapter);
        }
    }


    public NotificationAdapter getNotificationAdapter(String type) {
        return notificationAdaptersAsHashMap.get(type);
    }

}
