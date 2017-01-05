package com.zhong.commons;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Hashtable;

/**
 * Created by zhong on 2016/8/23.
 */
public class QRCodeUtil {
    private static final String CHARSET = "utf-8";
    private static final String FORMAT_NAME = "png";
    private static final int QRCODE_SIZE = 500;
    public static void encode(String content,OutputStream output) throws Exception {
        Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
        // 指定纠错等级
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

        hints.put(EncodeHintType.MARGIN ,1);
        // 指定编码格式
        hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, QRCODE_SIZE, QRCODE_SIZE, hints);
        MatrixToImageWriter.writeToStream(bitMatrix, FORMAT_NAME, output);
    }

    /**
     * 输出图片到文件系统
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        OutputStream out = new FileOutputStream(new File("e://a.png"));
        encode("http://www.hao123.com/?tn=95090524_s_hao_pg",out);
    }
}
