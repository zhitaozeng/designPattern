package adapter;

import log.api.LogDBOperate;
import log.api.LogFileOperate;
import log.model.LogModel;

import java.util.List;

/**
 * 双向适配器，同时实现了target和adaptee的接口
 * 内部使用target来实现adaptee的接口，使用adaptee来实现target的接口
 */
public class TwoDirectAdapter implements LogDBOperate, LogFileOperate {

    private LogDBOperate logDBOperate;
    private LogFileOperate logFileOperate;

    /**
     * 双向适配器的构造方法
     * @param logDBOperate 需要被适配的日志数据库操作接口对象
     * @param logFileOperate 需要被适配的日志文件操作接口对象
     */
    public TwoDirectAdapter(LogDBOperate logDBOperate, LogFileOperate logFileOperate){
        this.logDBOperate = logDBOperate;
        this.logFileOperate = logFileOperate;
    }

    /*  以下是使用日志文件操作接口，来实现日志数据库的操作  */
    @Override
    public void createLog(LogModel logModel) {
        //取出之前的日志
        List<LogModel> logModels = logFileOperate.readLogFile();
        //添加新的日志
        logModels.add(logModel);
        //重新写入
        logFileOperate.writeLogFile(logModels);
    }

    @Override
    public void updateLog(LogModel logModel) {
        //取出之前的日志
        List<LogModel> logModels = logFileOperate.readLogFile();
        //找到对应的日志，进行更新
        for (int i = 0; i < logModels.size(); i++){
            if (logModels.get(i).getLogId() == logModel.getLogId()){
                logModels.set(i, logModel);
            }
        }
        //重新写入
        logFileOperate.writeLogFile(logModels);
    }

    @Override
    public void removeLog(LogModel logModel) {
        //找到之前的日志
        List<LogModel> logModels = logFileOperate.readLogFile();
        //删除对应的日志
        logModels.remove(logModel);
        //重新写入
        logFileOperate.writeLogFile(logModels);
    }

    /*  以下是使用日志数据库操作接口，来实现日志文件的操作  */
    @Override
    public List<LogModel> getAllLog() {
        return logFileOperate.readLogFile();
    }

    @Override
    public List<LogModel> readLogFile() {
        return logDBOperate.getAllLog();
    }

    @Override
    public void writeLogFile(List<LogModel> logModels) {
        List<LogModel> allLog = logDBOperate.getAllLog();
        for (LogModel log : allLog){
            logDBOperate.removeLog(log);
        }
        for (LogModel log : logModels){
            logDBOperate.createLog(log);
        }
    }
}
