package oldversion;

import log.api.LogFileOperate;
import log.api.impl.LogFileOperateImpl;
import log.model.LogModel;

import java.util.ArrayList;
import java.util.List;

/**
 * 老版本的日志使用的客户端
 * 使用的是日志的文件操作的接口
 */
public class Client {
    public static void main(String[] args){

        LogModel logModel = new LogModel();
        logModel.setLogId(001);
        logModel.setOperateUser("admin");
        logModel.setLogContent("这是一个测试的日志");
        logModel.setOperateTime("2020-04-07 23:53:20");

        List<LogModel> logModels = new ArrayList<>();
        logModels.add(logModel);

        LogFileOperate logFileOperate = new LogFileOperateImpl();
        logFileOperate.writeLogFile(logModels);

        List<LogModel> logModelList = logFileOperate.readLogFile();
        for (LogModel log : logModelList){
            System.out.println(log);
        }

    }
}
