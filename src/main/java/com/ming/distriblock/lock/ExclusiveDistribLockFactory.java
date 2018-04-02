package com.ming.distriblock.lock;

/**
 * Created by xueming on 2018/4/2.
 */
public class ExclusiveDistribLockFactory implements DistribLockFactory {

    @Override
    public DistribLock createLock(String primaryId) {
        DistribLock distribLock = new DistribLock(primaryId, true);
        return distribLock;
    }
}
