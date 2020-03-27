package system.business.impl;

import system.business.Business;
import system.config.ConfigManager;
import system.config.ConfigModel;

/**
 * 逻辑层代码生成器实现类
 */
public class BusinessImpl implements Business {
    @Override
    public void generate() {
        //1.从配置文件中获取相应的配置信息
        ConfigModel cm = ConfigManager.getInstance().getConfigData();
        if (cm.isNeedGenBusiness()){
            //2.根据配置信息的要求生成相应的代码，并保存文件
            System.out.println("正在生成逻辑层代码...");
        }
    }
}
