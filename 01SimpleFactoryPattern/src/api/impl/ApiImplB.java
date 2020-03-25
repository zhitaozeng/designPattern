package api.impl;

import api.Api;

/**
 * 接口Api的实现类B
 */
public class ApiImplB implements Api {
    @Override
    public void operation(String s) {
        System.out.println(s + "：b实现类");
    }
}
