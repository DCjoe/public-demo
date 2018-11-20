package com.fnl.caesar.wechat.model.wechat.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName ArticlesMessage
 * @Description 图文消息
 * @Author dengcheng
 * @Date 2018/11/19 0019 下午 16:14
 **/
@Data
@XStreamAlias("xml")
public class ArticlesMessage extends BaseMessage implements Serializable {
    @XStreamAlias("ArticleCount")
    private int ArticleCount;

    @XStreamAlias("Articles")
    private List<ArticlesItem> Articles;
}
