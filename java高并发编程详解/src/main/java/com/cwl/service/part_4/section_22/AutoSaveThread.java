package com.cwl.service.part_4.section_22;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author cwl
 * @description: TODO
 * @date 2019/12/3014:46
 */
public class AutoSaveThread extends Thread {

    private final Document document;

    public AutoSaveThread(Document document) {
        super("DocumentAutoSaveThread");
        this.document = document;
    }

    @Override
    public void run() {
        while (true) {
            try {
                //每隔一秒自动保存一次文档
                document.save();
                TimeUnit.SECONDS.sleep(1);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
