package com.example.rest.grpc;

public class PerformanceGrpcServiceRealization extends PerformanceServiceGrpc.PerformanceServiceRealizationBase{
    @Override
    public void getNumber (PerformanceOuterClass.Performance request, StreamObserver<PerformanceOuterClass.Response> responseObserver) {
        PerformanceOuterClass.Response response = PerformanceOuterClass.Response.newBuilder()
                .setStr(request.getName() + " will be the best. Response message. All ok")
                .build();
        System.out.println("Received Performance: \n" + request.getName() + "\n" + request.getDate + "\n" + request.getPerformanceId());
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
