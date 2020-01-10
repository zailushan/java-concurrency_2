package com.cwl.service.part_4.section_17;

/**
 * @author cwl
 * @description: TODO
 * @date 2019/12/279:48
 */
public class ReadWriteLockImpl implements ReadWriteLock{

    //定义对象锁
    private final Object MUTEX = new Object();

    //当前有多少个线程正在写入
    private int writingWriters = 0;

    //当前有多少个线程正在等待写入
    private int waitingWriters = 0;

    //当前有多少个线程正在read
    private int readingReaders = 0;

    //read和write的偏好设置
    private boolean preferWriter;

    //默认情况下preferWriter为true
    public ReadWriteLockImpl() {
        this(true);
    }

    //构造ReadWriteLockImpl并且传入preferWriter
    public ReadWriteLockImpl(boolean preferWriter) {
        this.preferWriter = preferWriter;
    }

    //创建read lock
    @Override
    public Lock readLock() {
        return new ReadLock(this);
    }

    //创建write lock
    @Override
    public Lock writeLock() {
        return new WriteLock(this);
    }

    //使写线程的数量增加
    void incrementWritingWriters() {
        this.writingWriters++;
    }

    //使等待写入的线程数量增加
    void incrementWaitingWriters() {
        this.waitingWriters++;
    }

    //使读线程的数量增加
    void incrementReadingReaders() {
        this.readingReaders++;
    }

    //是写线程的数量减少
    void decrementWritingWriters() {
        this.writingWriters--;
    }

    //使等待获取写入锁的线程减一
    void decrementWaitingWriters() {
        this.waitingWriters--;
    }

    //是读取线程的数量减少
    void decrementReadingReaders() {
        this.readingReaders--;
    }

    @Override
    public int getWritingWriters() {
        return this.writingWriters;
    }

    @Override
    public int getWaittingWriters() {
        return this.waitingWriters;
    }

    @Override
    public int getReadingReaders() {
        return this.readingReaders;
    }

    //获取对象锁
    Object getMutex() {
        return this.MUTEX;
    }

    //获取当前是否偏向锁
    boolean getPreferWriter() {
        return this.preferWriter;
    }

    //设置写锁偏好
    void changePrefer(boolean preferWriter) {
        this.preferWriter = preferWriter;
    }
}
