package org.example;
import com.example.grpc.GreatingService;
import com.example.grpc.GreetingServiceGrpc;
import io.grpc.stub.StreamObserver;

public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {

    @Override
    public void knockKnock(GreatingService.HelloRequest request, StreamObserver<GreatingService.HelloResponse> responseObserver) {
        System.out.println(request);
        GreatingService.HelloResponse response = GreatingService.HelloResponse.newBuilder().setKnockKnock("Who is there? " + request.getText()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
