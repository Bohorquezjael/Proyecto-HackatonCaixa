package io.nuwe.technical.api.services;

import io.nuwe.technical.api.entities.*;
import io.nuwe.technical.api.repositories.*;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
public class NotificationService {

    private NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository){
	this.notificationRepository= notificationRepository;
    }

    public List<Notification> getAllNotifications(){
	List<Notification> notifications = notificationRepository.findAll();
	return notifications;
    }

    public void saveNotification(Notification n) {
        Optional<Notification> existingNotification = notificationRepository.findByMessageId(n.getMessageId());
        if (existingNotification.isEmpty()) {
            notificationRepository.save(n);
        }
    }

    public Optional<Notification> getNotificationByMessageId(long messageId) {
        return notificationRepository.findByMessageId(messageId);
    }
    
}
