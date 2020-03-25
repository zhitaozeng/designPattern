package after;

import api.Api;
import simple.factory.pattern.ApiFactory;

/**
 * 使用简单工厂模式之后的调用方式
 * 虽然看似只是将创建对象的步骤放到了简单工厂中
 * 但是客户端只能接触到工厂和接口，对于具体的实现类就不用关注了
 * 这样就满足了面向接口编程的封装隔离特性
 */
public class Client {
    public static void main(String[] args){
        Api api = ApiFactory.createApi(1);
//        Api api = ApiFactory.createApi(2);
        api.operation("test");
    }
}
