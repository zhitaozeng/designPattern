package before;


import api.Api;
import api.impl.ApiImplA;

/**
 * 不使用简单工厂模式之前的调用方式
 * 可以看到，客户端能虽然是使用接口的方式来多态调用
 * 但是还是能够知道具体的实现类，不满足封装隔离的原则
 */
public class Client {
    public static void main(String[] args){
        Api api = new ApiImplA();
//        api.Api api = new ApiImplB();
        api.operation("test");
    }
}
