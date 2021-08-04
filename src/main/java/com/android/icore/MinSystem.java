package com.android.icore;

import android.util.Log;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 原子系统基类
 */
public class MinSystem {
    private static final String TAG = "ChildNode";
    private final int nodeId;
    private AtomicBoolean nodeAvailable = new AtomicBoolean(true);

    public MinSystem(int nodeId) {
        this.nodeId = nodeId;
    }

    public void handleException(NodeException exp) {
        if (exp != null) {
            Log.w(TAG, "node id:" + this.nodeId + "#error:" + exp.getText());
        }
    }

    public boolean isNodeAvailable() {
        return this.nodeAvailable.get();
    }

    public void setNodeAvailable(boolean nodeAvailable) {
        this.nodeAvailable.set(nodeAvailable);
    }

    public static String getTAG() {
        return TAG;
    }
}
