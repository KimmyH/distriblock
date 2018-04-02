package com.ming.distriblock.lock;

/**
 * Created by xueming on 2018/4/2.
 */
public class DistribLockSynchronizer {
    private DistribLockFactory factory;

    public DistribLockSynchronizer(){

    }

    public DistribLockSynchronizer(DistribLockFactory factory){
        this.factory = factory;
    }


    public boolean lockByPrimaryKey(String primaryKey){
        return false;
    }
}
