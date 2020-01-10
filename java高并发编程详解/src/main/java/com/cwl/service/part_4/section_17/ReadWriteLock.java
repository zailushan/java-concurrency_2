package com.cwl.service.part_4.section_17;

/**
 * @author cwl
 * @description: TODO
 * @date 2019/12/279:43
 */
public interface ReadWriteLock {

    //创建reader锁
    Lock readLock();

    //创建write锁
    Lock writeLock();

    //获取当前有多少线程正在执行写操作
    int getWritingWriters();

    //获取当前有多少线程正在等待获取写入锁
    int getWaittingWriters();

    //获取当前有多少线程在等待获取reader锁
    int getReadingReaders();

    //工厂方法，创建ReaderWriteLock
    static ReadWriteLock readWriteLock() {
        return new ReadWriteLockImpl();
    }

    //工厂方法，创建ReaderWriteLock，并且传入preferWriter
    static ReadWriteLock readWriteLock(boolean preferWriter) {
        return new ReadWriteLockImpl(preferWriter);
    }

}