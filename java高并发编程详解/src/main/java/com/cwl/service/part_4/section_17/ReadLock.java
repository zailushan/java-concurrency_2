package com.cwl.service.part_4.section_17;

/**
 * @author cwl
 * @description: TODO
 * @date 2019/12/2710:11
 */
public class ReadLock implements Lock {

    private final ReadWriteLockImpl readWriteLock;

    public ReadLock(ReadWriteLockImpl readWriteLock) {
        this.readWriteLock = readWriteLock;
    }

    @Override
    public void lock() throws InterruptedException {
        //使用MUTEX作为锁
        synchronized (readWriteLock.getMutex()) {
            //若此时有线程在进行写锁，或者有写线程在等待并且偏向写锁的标识为true时，
            // 就会无法获得读锁，只能被挂起
            while (readWriteLock.getWritingWriters() > 0 ||
                    (readWriteLock.getPreferWriter() && readWriteLock.getWaittingWriters() > 0)) {
                readWriteLock.getMutex().wait();
            }
            //成功获得读锁，并且使readingReaders的数量增加
            readWriteLock.incrementReadingReaders();
        }
    }

    @Override
    public void unlock() {
        //使用MUTEX作为锁，并且进行同步
        synchronized (readWriteLock.getMutex()) {
            //释放所的过程就是使得当前reading的数量减一
            //将perferWriter设置为true，可以使得writer的线程获得更多的机会
            //通知唤醒与MUTEX关联的monitor waitset中的线程
            readWriteLock.decrementReadingReaders();
            readWriteLock.changePrefer(true);
            readWriteLock.getMutex().notifyAll();
        }
    }
}
