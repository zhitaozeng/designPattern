package api.impl;

import api.Api;

/**
 * 接口Api的实现类A
 */
public class ApiImplA implements Api {
    @Override
    public void operation(String s) {
        System.out.println(s + " ： a实现类");
    }
}
