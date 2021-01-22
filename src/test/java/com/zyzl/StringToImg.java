package com.zyzl;

import com.alibaba.fastjson.util.IOUtils;
import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @Author: peter
 * @Date: 2021/1/18 11:10
 */
public class StringToImg {

    public static void main(String[] args) {
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            FileInputStream fileInputStream = new FileInputStream(new File("/Users/piza/work/云渠/滴滴券/imgstr.txt"));
            byte[] bytes = decoder.decodeBuffer(fileInputStream);
            for (int i = 0; i < bytes.length; ++i) {
                if (bytes[i] < 0) {// 调整异常数据
                    bytes[i] += 256;
                }
            }
            // 生成jpeg图片
            OutputStream out = new FileOutputStream("/Users/piza/work/云渠/滴滴券/miniqrcode5.jpg");
            out.write(bytes);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
