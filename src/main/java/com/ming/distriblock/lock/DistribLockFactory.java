package com.ming.distriblock.lock;

/**
 * Created by xueming on 2018/4/2.
 */
public interface DistribLockFactory {
    DistribLock createLock(String primaryId);
}
