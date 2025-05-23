package com.pm.billingservice.grpc;

import billing.BillingRequest;
import billing.BillingResponse;
import billing.BillingServiceGrpc.BillingServiceImplBase;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService
public class BillingGrpcService extends BillingServiceImplBase {

    private static final Logger log = LoggerFactory.getLogger(BillingGrpcService.class);

    @Override
    public void createBillingAccount(BillingRequest billingRequest
            , StreamObserver<BillingResponse> responseObserver) {

        log.info("createBillingAccount called with request: {}", billingRequest.toString());

        // Some Business Logic, calculation, save to db etc.

        BillingResponse billingResponse = BillingResponse.newBuilder()
                .setAccountId("12345")
                .setStatus("ACTIVE")
                .build();

        log.info("createBillingAccount response: {}", billingResponse.toString());

        // Send the response back to the client
        responseObserver.onNext(billingResponse);
        responseObserver.onCompleted();


    }

}
