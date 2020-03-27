package system.dao.impl;

import system.config.ConfigManager;
import system.config.ConfigModel;
import system.dao.DAO;

public class DAOImpl implements DAO {
    @Override
    public void generate() {
        //1.从配置文件中获取相应的配置信息
        ConfigModel cm = ConfigManager.getInstance().getConfigData();
        if (cm.isNeedGenDAO()){
            //2.根据配置信息的要求生成相应的代码，并保存文件
            System.out.println("正在生成DAO层代码...");
        }
    }
}
