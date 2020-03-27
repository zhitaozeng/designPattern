package after;

import system.facade.Facade;

/**
 * 使用外观模式后的客户端
 * 通过外观模式来，调用代码生成器系统，生成相应的代码
 * 可以看到客户端只需要与外观模式打交道，调用十分简单
 * 子系统模块的修改，可以被外观模式所消化吸收
 * 所以子系统可以在不影响客户端的前提下，进行扩展和维护
 */
public class Client {
    public static void main(String[] args){
        Facade facade = new Facade();
        facade.generate();
    }
}
