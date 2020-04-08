package adapter;

import log.api.LogDBOperate;
import log.api.LogFileOperate;
import log.model.LogModel;

import java.util.List;

/**
 * 适配器类
 * 使用日志文件操作的接口，来实现日志DB的操作
 */
public class FileToDBAdapter implements LogDBOperate {
    private LogFileOperate adaptee;

    public FileToDBAdapter(LogFileOperate adaptee){
        this.adaptee = adaptee;
    }

    @Override
    public void createLog(LogModel logModel) {
        //取出之前的日志
        List<LogModel> logModels = adaptee.readLogFile();
        //添加新的日志
        logModels.add(logModel);
        //重新写入
        adaptee.writeLogFile(logModels);
    }

    @Override
    public void updateLog(LogModel logModel) {
        //取出之前的日志
        List<LogModel> logModels = adaptee.readLogFile();
        //找到对应的日志，进行更新
        for (int i = 0; i < logModels.size(); i++){
            if (logModels.get(i).getLogId() == logModel.getLogId()){
                logModels.set(i, logModel);
            }
        }
        //重新写入
        adaptee.writeLogFile(logModels);
    }

    @Override
    public void removeLog(LogModel logModel) {
        //找到之前的日志
        List<LogModel> logModels = adaptee.readLogFile();
        //删除对应的日志
        logModels.remove(logModel);
        //重新写入
        adaptee.writeLogFile(logModels);
    }

    @Override
    public List<LogModel> getAllLog() {
        return adaptee.readLogFile();
    }
}
