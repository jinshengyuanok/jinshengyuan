package com.yuan.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: jinshengyuan
 * Date: 2018-07-09
 * Time: 10:58
 * description:
 **/
public class EasyUITree {
    private String id;//绑定节点的标识值
    private String text;//显示的节点文本
    private String state;//节点状态
    private String checked;//该节点是否被选中
    private String iconCls;//显示的节点图标CSS类ID
    private String pid; //父节点id
    private Map<String,Object> attributes = new HashMap<String, Object>();;//自定义属性
    private List<EasyUITree> children;//子节点数据

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public List<EasyUITree> getChildren() {
        return children;
    }

    public void setChildren(List<EasyUITree> children) {
        this.children = children;
    }
}
