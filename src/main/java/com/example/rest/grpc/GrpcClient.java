package com.example.rest.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9000)
                .usePlaintext()
                .build();

        PerformaceServiceGrpc.PerformanceServiceBlockingStub client =PerformaceServiceGrpc.newBlockingStub(channel);

        PerformanceOuterClass.Performance request = PerformanceOuterClass.Performance.newBuilder()
                .setId("qwertyufdsghthzrsrtjhzddf")
                .setName("Masterinio")
                .setDate(2023-11-25)
                .build();

        PerformanceOuterClass.Response response = client.getNumber(request);
        System.out.println("\nReceived response: " + response.getStr() + "\n");

        channel.shutdown();
    }
}

