package system.config;

/**
 * 示意配置的描述model，真实的配置数据会很多
 */
public class ConfigModel {
    /**
     * 是否需要生成表现层的代码，默认为true
     */
    private boolean needGenPresentation = true;

    /**
     * 是否需要生成逻辑层的代码，默认为true
     */
    private boolean needGenBusiness = true;

    /**
     * 是否需要生成DAO的代码，默认为true
     */
    private boolean needGenDAO = true;

    public boolean isNeedGenPresentation() {
        return needGenPresentation;
    }

    public void setNeedGenPresentation(boolean needGenPresentation) {
        this.needGenPresentation = needGenPresentation;
    }

    public boolean isNeedGenBusiness() {
        return needGenBusiness;
    }

    public void setNeedGenBusiness(boolean needGenBusiness) {
        this.needGenBusiness = needGenBusiness;
    }

    public boolean isNeedGenDAO() {
        return needGenDAO;
    }

    public void setNeedGenDAO(boolean needGenDAO) {
        this.needGenDAO = needGenDAO;
    }
}
