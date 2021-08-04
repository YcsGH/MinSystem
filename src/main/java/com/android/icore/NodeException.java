package com.android.icore;

import android.text.TextUtils;

public class NodeException {
    private int code = 0;
    private String text;

    public NodeException(String message) {
        this.text = TextUtils.isEmpty(message) ? "未知错误" : message;
    }

    public NodeException(int errorCode, String message) {
        this.code = errorCode;
        this.text = TextUtils.isEmpty(message) ? "未知错误" : message;
    }

    public int getCode() {
        return this.code;
    }

    public String getText() {
        return this.text;
    }
}
