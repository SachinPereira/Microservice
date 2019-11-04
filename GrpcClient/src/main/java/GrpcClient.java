import com.grpc.clientUser.User;
import com.grpc.clientUser.userGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
public class GrpcClient {
    public static void main(String x[]){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
        userGrpc.userBlockingStub userBlockingStub = userGrpc.newBlockingStub(channel);
        User.LoginRequest request = User.LoginRequest.newBuilder().setUsername("sachin").setPassword("sachin").build();
        userBlockingStub.login(request);
        User.ApiResponse response=userBlockingStub.login(request);
        System.out.println(response.getResponseMessage());

    }
}
