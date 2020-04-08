package newversion;

import adapter.FileToDBAdapter;
import log.api.LogDBOperate;
import log.api.impl.LogDBOperateImpl;
import log.api.impl.LogFileOperateImpl;
import log.model.LogModel;

import java.util.ArrayList;
import java.util.List;

/**
 * 新版本的日志使用的客户端
 * 使用的是日志的DB操作的接口
 * 但是由于日志DB操作的实现还不太稳定，想继续使用之前的日志文件的接口
 * 为了尽量减少客户端的改动，而且因为之后还是要使用日志DB的操作的
 * 所以采用适配器模式
 */
public class Client2 {
    public static void main(String[] args){

        LogModel logModel = new LogModel();
        logModel.setLogId(001);
        logModel.setOperateUser("admin");
        logModel.setLogContent("这是一个测试的日志");
        logModel.setOperateTime("2020-04-07 23:53:20");

        List<LogModel> logModels = new ArrayList<>();
        logModels.add(logModel);
        //改动开始
        //LogDBOperate logDBOperate = new LogDBOperateImpl();
        LogDBOperate logDBOperate = new FileToDBAdapter(new LogFileOperateImpl());
        //改动结束

        //创建日志
        logDBOperate.createLog(logModel);
        //更新日志
        logModel.setLogContent("修改内容");
        logDBOperate.updateLog(logModel);
        //修改日志
        logDBOperate.removeLog(logModel);
        //获取所有的日志文件
        List<LogModel> allLog = logDBOperate.getAllLog();

    }
}
