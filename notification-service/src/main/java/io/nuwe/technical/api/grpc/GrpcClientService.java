package io.nuwe.technical.api.grpc;


import org.springframework.stereotype.Service;

import java.util.Optional;
import java.time.format.DateTimeFormatter;

import io.grpc.StatusRuntimeException;

import io.nuwe.technical.api.entities.*;

import io.nuwe.technical.api.lib.*;
import io.nuwe.technical.api.lib.NotificationProto.*;
import io.nuwe.technical.api.lib.NotificationServiceGrpc.NotificationServiceBlockingStub;

import net.devh.boot.grpc.client.inject.GrpcClient;


@Service
public class GrpcClientService {

	/* TODO: TASK 3 - Complete the file to fix communication between notification and frontend*/

    @GrpcClient("")
    private NotificationServiceBlockingStub notificationStub;

    public boolean pushNotification(final Notification notification){
	try {
	DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");



		final NotificationResponse res = this.notificationStub.pushNotification(notificationBuilder.build());

		if (res == null || res.getNotificationArrived() == false ){
		    return false;
		}

		return true;

	} catch (final StatusRuntimeException e){
	    return false;
	}
    }
}
