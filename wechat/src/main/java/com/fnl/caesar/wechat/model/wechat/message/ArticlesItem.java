package com.fnl.caesar.wechat.model.wechat.message;

import com.fnl.caesar.wechat.commons.annotations.XStreamCDATA;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName ArticlesItem
 * @Description TODO
 * @Author dengcheng
 * @Date 2018/11/19 0019 下午 16:15
 **/
@Data
@XStreamAlias("item")
public class ArticlesItem implements Serializable {
    @XStreamAlias("Title")
    @XStreamCDATA
    private String Title;

    @XStreamAlias("Description")
    @XStreamCDATA
    private String Description;

    @XStreamAlias("PicUrl")
    @XStreamCDATA
    private String PicUrl;

    @XStreamAlias("Url")
    @XStreamCDATA
    private String Url;
}
