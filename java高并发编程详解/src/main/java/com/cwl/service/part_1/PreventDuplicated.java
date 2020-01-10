package com.cwl.service.part_1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author cwl
 * @description: TODO
 * @date 2019/12/1916:07
 */
public class PreventDuplicated {

    private final static String LOCK_PATH = "D:/locks";

    private final static String LOCK_FILE = ".lock";

    private final static String PERMISSIONS = "rw-------";

    public static void main(String[] args) throws IOException {
        checkRunning();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("The program received kill SINGNAL.");
            getLockFile().toFile().delete();
        }));
        for (; ; ) {
            try {
                TimeUnit.MILLISECONDS.sleep(1);
                System.out.println("program is running.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private static void checkRunning() throws IOException {
        Path path = getLockFile();
        if (path.toFile().exists()) {
            throw new RuntimeException("The program already running.");
        }
        Set<PosixFilePermission> perms = PosixFilePermissions.fromString(PERMISSIONS);
        //Files.createFile(path, PosixFilePermissions.asFileAttribute(perms));
        String filePath = LOCK_PATH + LOCK_FILE;
        System.out.println(filePath);
        new File(filePath).createNewFile();
    }

    private static Path getLockFile() {
        return Paths.get(LOCK_PATH, LOCK_FILE);
    }


}
