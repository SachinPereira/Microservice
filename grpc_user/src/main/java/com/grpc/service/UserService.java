package com.grpc.service;

import com.grpc.user.User;
import com.grpc.user.userGrpc.userImplBase;
import io.grpc.stub.StreamObserver;


public class UserService extends userImplBase {
    @Override
    public void login(User.LoginRequest request, StreamObserver<User.ApiResponse> responseObserver) {
        String username,password;
        username=request.getUsername();
        password=request.getPassword();
        User.ApiResponse.Builder response= User.ApiResponse.newBuilder();
        if(username.equals(password)){
            response.setResponseMessage("Sucess").setResponseCode(200);
        }else{
            response.setResponseMessage("Not found").setResponseCode(404);
        }
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void logout(User.Empty request, StreamObserver<User.ApiResponse> responseObserver) {
        super.logout(request, responseObserver);
    }
}

