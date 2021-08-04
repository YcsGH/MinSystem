package com.android.icore;

/**
 * 带运行状态的子系统基类
 */
public class BaseChildSystem extends MinSystem {

    protected static final int NODE_INIT = 0x00;
    protected static final int NODE_START = 0x01;
    protected static final int NODE_PAUSE = 0x02;
    protected static final int NODE_STOP = 0x03;
    protected static final int NODE_RELEASED = 0x04;
    protected static final int NODE_ERROR = 0xFF;
    protected int status = 0;

    public BaseChildSystem(int nodeId) {
        super(nodeId);
        reset();
    }

    public void reset() {
        this.status = NODE_INIT;
    }

    public void start() {
        this.status = NODE_START;
    }

    public void stop() {
        this.status = NODE_STOP;
    }

    public void pause() {
        this.status = NODE_PAUSE;
    }

    public void release() {
        this.status = NODE_RELEASED;
    }

    public void setNodeAvailable(boolean nodeAvailable) {
        super.setNodeAvailable(nodeAvailable);
        this.setStatus(NODE_ERROR);
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
