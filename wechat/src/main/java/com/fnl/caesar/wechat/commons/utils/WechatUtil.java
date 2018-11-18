package com.fnl.caesar.wechat.commons.utils;

import com.alibaba.fastjson.JSONObject;
import com.fnl.caesar.wechat.model.wechat.AccessToken;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName WechatUtil
 * @Description 微信工具类
 * @Author dengcheng
 * @Date 2018/11/16 0016 上午 11:47
 **/
public class WechatUtil {
    // 与接口配置信息中的Token要一致
    private static String token = "dengcheng";
    private static final String APPID = "wxdb27c1bf65011a70";
    private static final String APPSECRET = "1e7b1e3727fc8c6b8d0e7d18ebf7e878";

    /**
     * 验证签名
     *
     * @param signature
     * @param timestamp
     * @param nonce
     * @return
     */
    public static boolean checkSignature(String signature, String timestamp, String nonce) {
        String[] arr = new String[] { token, timestamp, nonce };
        // 将token、timestamp、nonce三个参数进行字典序排序
        // Arrays.sort(arr);
        sort(arr);
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            content.append(arr[i]);
        }
        MessageDigest md = null;
        String tmpStr = null;

        try {
            md = MessageDigest.getInstance("SHA-1");
            // 将三个参数字符串拼接成一个字符串进行sha1加密
            byte[] digest = md.digest(content.toString().getBytes());
            tmpStr = byteToStr(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        content = null;
        // 将sha1加密后的字符串可与signature对比，标识该请求来源于微信
        return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;
    }

    /**
     * @Description 获取access_token
     * @Author dengcheng
     * @Date 2018/11/16 0016
     * @Param []
     * @return java.lang.String
     **/
    public static AccessToken getAccessToken(){
        AccessToken accessToken = null;
        try {
            String accessTokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
                    +APPID+ "&secret="+APPSECRET;

            URL url = new URL(accessTokenUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.connect();

            //获取返回的字符
            InputStream inputStream = connection.getInputStream();
            int size =inputStream.available();
            byte[] bs =new byte[size];
            inputStream.read(bs);
            String message=new String(bs,"UTF-8");

            //获取access_token
            accessToken = JSONObject.parseObject(message, AccessToken.class);
            if(StringUtils.isNotEmpty(accessToken.getErrcode())){
                getAccessToken();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return accessToken;
    }


    /**
     * 将字节数组转换为十六进制字符串
     *
     * @param byteArray
     * @return
     */
    private static String byteToStr(byte[] byteArray) {
        String strDigest = "";
        for (int i = 0; i < byteArray.length; i++) {
            strDigest += byteToHexStr(byteArray[i]);
        }
        return strDigest;
    }

    /**
     * 将字节转换为十六进制字符串
     *
     * @param mByte
     * @return
     */
    private static String byteToHexStr(byte mByte) {
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];
        String s = new String(tempArr);
        return s;
    }
    /**
     * @Description 排序
     * @Author dengcheng
     * @Date 2018/11/16 0016
     * @Param [a]
     * @return void
     **/
    public static void sort(String a[]) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[j].compareTo(a[i]) < 0) {
                    String temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(getAccessToken());
    }

}
