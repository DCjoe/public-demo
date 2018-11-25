package com.fnl.caesar.wechat.commons.utils;

import com.fnl.caesar.wechat.model.wechat.message.BaseMessage;
import com.fnl.caesar.wechat.model.wechat.message.MessageText;
import com.thoughtworks.xstream.XStream;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author dengcheng
 * @Date 2018/11/17
 **/
public class MessageUtil {

    /**
     * 类型
     */
    //文本
    public static final String MESSAGE_TEXT = "text";
    /**
     * 图文消息
     */
    public static final String MESSAGE_NEWS = "news";
    /**
     * 图片消息
     */
    public static final String MESSAGE_IMAGE = "image";
    //音乐
    public static final String MESSAGE_MUSIC = "music";
    //语音消息
    public static final String MESSAGE_VOICE = "voice";
    //视频消息
    public static final String MESSAGE_VIDEO = "video";
    //短视频
    public static final String MESSAGE_SHORTVIDEO = "shortvideo";
    //连接消息
    public static final String MESSAGE_LINK = "link";
    //件推送消息中,上报地理位置事件
    public static final String MESSAGE_LOCATION = "location";
    //事件推送消息
    public static final String MESSAGE_EVENT = "event";
    //事件推送消息中,事件类型,subscribe(订阅)
    public static final String MESSAGE_SUBSCRIBE = "subscribe";
    //事件推送消息中,事件类型,unsubscribe(取消订阅)
    public static final String MESSAGE_UNSUBSCRIBE = "unsubscribe";
    //事件推送消息中,自定义菜单事件,点击菜单拉取消息时的事件推送
    public static final String MESSAGE_CLICK = "CLICK";
    //事件推送消息中,自定义菜单事件,点击菜单跳转链接时的事件推送
    public static final String MESSAGE_VIEW = "VIEW";
    //扫描二维码事件
    public static final String MESSAGE_SCANCODE = "scancode_push";


    public static Map<String,String> xmlToMap(HttpServletRequest request) {
        Map<String,String> map = new HashMap<>();
        SAXReader reader = new SAXReader();

        InputStream in = null;
        try {
            in = request.getInputStream();
            Document doc = reader.read(in);
            Element root = doc.getRootElement();
            List<Element> list = root.elements();
            for (Element element : list) {
                map.put(element.getName(), element.getText());
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            try {
                in.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return map;
    }
    /**
     * 将发送消息封装成对应的xml格式
     */
    public static String messageToxml(MessageText message) {
        XStream xstream  = new XStream();
        xstream.alias("xml", message.getClass());
        return xstream.toXML(message);
    }

    /**
     * 封装发送消息对象,封装时，需要将调换发送者和接收者的关系
     * @param FromUserName
     * @param ToUserName
     */
    public static String initMessage(String FromUserName ,String ToUserName) {

        return null;
    }
}
