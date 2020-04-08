package log.api.impl;

import log.api.LogFileOperate;
import log.model.LogModel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 日志文件操作实现类
 */
public class LogFileOperateImpl implements LogFileOperate {

    /**
     * 日志文件的路径和文件名称，默认为此项目根目录下的AdapterLog.log文件
     */
    private String logFileName = "AdapterLog.log";

    public LogFileOperateImpl(){

    }

    /**
     * 构造方法，传入日志文件的路径和文件名称
     * @param logFileName 日志文件的路径和文件名称
     */
    public LogFileOperateImpl(String logFileName) {
        if (logFileName != null && logFileName.trim().length() > 0){
            this.logFileName = logFileName;
        }
    }

    @Override
    public List<LogModel> readLogFile() {
        List<LogModel> logModels = new ArrayList<>();
        ObjectInputStream oin = null;
        try {
            File file = new File(logFileName);
            if (file.exists()){
                oin = new ObjectInputStream(
                        new BufferedInputStream(
                                new FileInputStream(file)
                        )
                );
                logModels = (List<LogModel>) oin.readObject();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (oin != null){
                    oin.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return logModels;
    }

    @Override
    public void writeLogFile(List<LogModel> logModels) {
        File file = new File(logFileName);
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(file)
                    )
            );
            out.writeObject(logModels);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (out != null){
                    out.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
