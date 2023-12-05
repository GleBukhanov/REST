package com.example.rest.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GrpcServer {
    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder
                .forPort(9000)
                .addService(new PerformanceGrpcServiceRealization())
                .build();

        server.start();
        System.out.println("\n--------------\ngRPC server started\n--------------\n");

        server.awaitTermination();
    }
}
