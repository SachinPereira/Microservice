package com.grpc;

import com.grpc.service.UserService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
public class MainUser {
    public static void main(String x[]) throws IOException, InterruptedException {
        Server serverObj= ServerBuilder.forPort(9090).addService(new UserService()).build();
        serverObj.start();
        System.out.println("Server started"+serverObj.getPort());
        serverObj.awaitTermination();
    }
}
