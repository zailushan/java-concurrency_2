package com.cwl.service.part_4.section_22;


import java.io.IOException;
import java.util.Scanner;

/**
 * @author cwl
 * @description: 该线程代表的是主动进行文档编辑的线程，为了增加交互性，我们使用Scnaner
 * @date 2019/12/3015:04
 */
public class DocumentEditThread extends Thread {

    private final String documentPath;

    private final String documentName;

    private final Scanner scanner = new Scanner(System.in);

    public DocumentEditThread(String documentPath, String documentName) {
        super("DocumentEditThread");
        this.documentPath = documentPath;
        this.documentName = documentName;
    }

    @Override
    public void run() {
        try {
            int times = 0;
            Document document = Document.create(documentPath, documentName);
            while (true) {
                //获取用户的键盘输入
                String text = scanner.next();
                if ("quit".equals(text)) {
                    document.close();
                    break;
                }
                //将内容编辑到document中
                document.edit(text);
                if (times == 5) {
                    //用户输入了5次之后进行文档保存
                    document.save();
                    times = 0;
                }
                times++;
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
