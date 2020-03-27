package system.config;

/**
 * 示意的配置管理，负责读取配置文件
 * 并把配置文件中的内容设置到model中去，是个单例
 */
public class ConfigManager {
    private static ConfigManager manager = null;
    private static ConfigModel cm = null;

    private ConfigManager(){
        //私有化构造函数，使得无法创造ConfigManager对象
    }

    public static ConfigManager getInstance(){
        if (manager == null){
            manager = new ConfigManager();
            cm = new ConfigModel();
            //省略读取配置文件的步骤，采用默认值
        }
        return manager;
    }

    /**
     * 获取配置的数据
     * @return 配置的数据
     */
    public ConfigModel getConfigData(){
        return cm;
    }
}
