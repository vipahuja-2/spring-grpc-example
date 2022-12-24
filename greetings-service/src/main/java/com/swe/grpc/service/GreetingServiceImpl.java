package com.swe.grpc.service;

import com.swe.grpc.GreetingRequest;
import com.swe.grpc.GreetingResponse;
import com.swe.grpc.GreetingServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

@Slf4j
@GrpcService
public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {
    @Override
    public void greeting(GreetingRequest request, StreamObserver<GreetingResponse> responseObserver) {
        String message = request.getMessage();
        log.info("Message received : {}", message);
        GreetingResponse greetingResponse = GreetingResponse.newBuilder()
                .setMessage("Hello from Greeting Service").build();
        responseObserver.onNext(greetingResponse);
        responseObserver.onCompleted();

    }

}
