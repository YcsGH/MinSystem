package com.android.icore;

import android.util.Log;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * 字节数组工具类
 */
public class BytesTransfer {

    private final static String TAG = "ChildNode";

    //java 合并两个byte数组
    public static byte[] byteMerger(byte[] byte_1, byte[] byte_2) {
        byte[] byte_3 = new byte[byte_1.length + byte_2.length];
        System.arraycopy(byte_1, 0, byte_3, 0, byte_1.length);
        System.arraycopy(byte_2, 0, byte_3, byte_1.length, byte_2.length);
        return byte_3;
    }

    public static int getUnsignedShort(short data) { //将data字节型数据转换为0~65535 (0xFFFF 即 WORD)。
        return data & 0x0FFFF;
    }

    /**
     * 利用 {@link java.nio.ByteBuffer}实现byte[]转long
     *
     * @param input
     * @param offset
     * @param littleEndian 输入数组是否小端模式
     * @return
     */
    public static long bytesToLong(byte[] input, int offset, boolean littleEndian) {
        // 将byte[] 封装为 ByteBuffer
        ByteBuffer buffer = ByteBuffer.wrap(input, offset, 8);
        if (littleEndian) {
            // ByteBuffer.order(ByteOrder) 方法指定字节序,即大小端模式(BIG_ENDIAN/LITTLE_ENDIAN)
            // ByteBuffer 默认为大端(BIG_ENDIAN)模式
            buffer.order(ByteOrder.LITTLE_ENDIAN);
        }
        return buffer.getLong();
    }


    /**
     * 打印前n个字节
     */
    public static void printfHexBytes(byte[] b, int length) {
        StringBuilder builder = new StringBuilder("<");
        for (int i = 0; i < length; i++) {
            String hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            builder.append(hex.toUpperCase());
        }
        builder.append(">");
        Log.w(TAG, builder.toString());
    }

    /**
     * 打印某个区间的字节
     */
    public static void printfHexBytesBetweenArea(byte[] b, int start, int end) {
        StringBuilder builder = new StringBuilder("<");
        for (int i = start; i < end; i++) {
            String hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            builder.append(hex.toUpperCase());
        }
        builder.append(">");
        Log.w(TAG, builder.toString());
    }

    public static byte[] intToBytes(int n) {
        byte[] b = new byte[4];
        b[3] = (byte) (n & 0xff);
        b[2] = (byte) (n >> 8 & 0xff);
        b[1] = (byte) (n >> 16 & 0xff);
        b[0] = (byte) (n >> 24 & 0xff);
        return b;
    }

    // int转成高字节数组
    public static byte[] intToBytesH(int n) {
        byte[] b = new byte[4];
        b[0] = (byte) (n & 0xff);
        b[1] = (byte) (n >> 8 & 0xff);
        b[2] = (byte) (n >> 16 & 0xff);
        b[3] = (byte) (n >> 24 & 0xff);
        return b;
    }

    public static int bytesToInt(byte[] b) {
        return b[3] & 0xff
                | (b[2] & 0xff) << 8
                | (b[1] & 0xff) << 16
                | (b[0] & 0xff) << 24;
    }

    public static int bytesToInt(byte[] b, int offset) {
        return b[offset + 3] & 0xff
                | (b[offset + 2] & 0xff) << 8
                | (b[offset + 1] & 0xff) << 16
                | (b[offset] & 0xff) << 24;
    }

    // 将高字节数组转换为int
    public static int bytesToIntH(byte[] b, int offset) {
        return b[offset] & 0xff
                | (b[offset + 1] & 0xff) << 8
                | (b[offset + 2] & 0xff) << 16
                | (b[offset + 3] & 0xff) << 24;
    }


    public static byte[] shortToBytes(short n) {
        byte[] b = new byte[2];
        b[0] = (byte) (n & 0xff);
        b[1] = (byte) ((n >> 8) & 0xff);
        return b;
    }

    public static byte[] shortToBytesH(short n) {
        byte[] b = new byte[2];
        b[1] = (byte) (n & 0xff);
        b[0] = (byte) ((n >> 8) & 0xff);
        return b;
    }


    public static short bytesToShort(byte[] b) {
        return (short) (b[1] & 0xff
                | (b[0] & 0xff) << 8);
    }

    public static short bytesToShort(byte[] b, int offset) {
        return (short) (b[offset + 1] & 0xff
                | (b[offset] & 0xff) << 8);
    }

    public static short bytesToShortH(byte[] b, int offset) {
        return (short) (b[offset] & 0xff
                | (b[offset + 1] & 0xff) << 8);
    }

    // 负数byte转成Integer
    public static Integer byteToInteger(Byte b) {
        return 0xff & b;
    }

    public static short[] bytesToShortArray(byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        short[] shorts = new short[bytes.length / 2];
        ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get(shorts);
        return shorts;
    }

    public static byte[] shortToBytesArray(short[] shorts) {
        if (shorts == null) {
            return null;
        }
        byte[] bytes = new byte[shorts.length * 2];
        ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().put(shorts);
        return bytes;
    }

}
