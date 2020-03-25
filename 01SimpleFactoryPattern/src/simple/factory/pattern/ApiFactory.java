package simple.factory.pattern;

import api.Api;
import api.impl.ApiImplA;
import api.impl.ApiImplB;

/**
 * 接口Api的简单工厂
 * 这里采用的是通过客户端传入参数来指定实现类的方式
 */
public class ApiFactory {

    public static Api createApi(int i){
        switch (i){
            case 1 :
                return new ApiImplA();
            case 2 :
                return new ApiImplB();
            default:
                return new ApiImplA();
        }
    }
}
