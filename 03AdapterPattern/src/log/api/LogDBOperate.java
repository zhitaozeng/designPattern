package log.api;

import log.model.LogModel;

import java.util.List;

/**
 * 日志数据库的操作接口
 */
public interface LogDBOperate {
    /**
     * 新增日志
     * @param logModel 日志文件
     */
    public void createLog(LogModel logModel);

    /**
     * 修改日志文件
     * @param logModel 日志文件
     */
    public void updateLog(LogModel logModel);

    /**
     * 删除日志文件
     * @param logModel 日志文件
     */
    public void removeLog(LogModel logModel);

    /**
     * 获取所有的日志文件
     * @return 所有的日志文件
     */
    public List<LogModel> getAllLog();
}
