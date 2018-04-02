package com.ming.distriblock.lock;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xueming on 2018/4/2.
 * 分布式锁对象，为了多个服务之间的锁协调
 * 多个服务可以采用共享/互斥的方式来获取同一个锁
 */
public class DistribLock implements Serializable {
    /**
     * 分布式锁博旭拥有一个唯一的ID， 由请求锁对象的服务者唯一构造生成
     */
    private String primaryId;
    /**
     * 该锁是否是独占的
     */
    private boolean isExclusive = false;
    /**
     * 真实的锁对象
     */
    private final Lock lock;
    /**
     * 该锁是否被获取
     */
    private volatile AtomicBoolean isAcquired;

    public DistribLock(String primaryId){
        this.primaryId = primaryId;
        this.lock = new ReentrantLock();
        this.isAcquired = new AtomicBoolean(false);
    }

    public DistribLock(String primaryId, boolean isExclusive){
        this.primaryId = primaryId;
        this.isExclusive = isExclusive;
        this.lock = new ReentrantLock();
        this.isAcquired = new AtomicBoolean(false);
    }

    public boolean lock(){
        this.lock.lock();
        this.isAcquired.compareAndSet(false, true);
        return this.isAcquired.get();
    }

    public boolean unlock(){
        this.lock.unlock();
        this.isAcquired.compareAndSet(true, false);
        return this.isAcquired.get();
    }



}
