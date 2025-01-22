package io.nuwe.technical.api.grpc;

import io.grpc.stub.StreamObserver;
import io.nuwe.technical.api.lib.NotificationProto.*;
import io.nuwe.technical.api.lib.NotificationServiceGrpc;
import net.devh.boot.grpc.server.service.GrpcService;

import io.nuwe.technical.api.entities.*;
import io.nuwe.technical.api.services.NotificationService;
import io.nuwe.technical.api.grpc.GrpcClientService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class NotificationProtoService extends NotificationServiceGrpc.NotificationServiceImplBase {

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private GrpcClientService grpcClientService;

	private static final Logger log = LoggerFactory.getLogger(NotificationProtoService.class);
	private final Set<String> processingRequests = ConcurrentHashMap.newKeySet();

    /* TODO: TASK 3 - Complete the method to push notifications*/

    @Override
    public void pushNotification(NotificationRequest req, StreamObserver<NotificationResponse> responseObserver) {}


}
