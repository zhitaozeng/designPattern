package log.api;

import log.model.LogModel;

import java.util.List;

/**
 * 日志文件操作接口
 */
public interface LogFileOperate {
    /**
     * 读取日志文件，从里面获取存储的日志列表对象
     * @return 日志列表对象
     */
    public List<LogModel> readLogFile();

    /**
     * 写入日志文件，将日志列表写入到日志文件中
     * @param logModels 日志列表对象
     */
    public void writeLogFile(List<LogModel> logModels);
}
