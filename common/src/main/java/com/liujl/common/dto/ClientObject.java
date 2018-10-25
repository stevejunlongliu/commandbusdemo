package com.liujl.common.dto;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据抽象
 * Created by junlong_liu on 2018/7/31.
 */
public class ClientObject {

    private static final long serialVersionUID = 1L;





    //拓展值
    protected Map<String, Object> extValues = new HashMap<String, Object>();

    public Object getExtField(String key){
        if(extValues != null){
            return extValues.get(key);
        }
        return null;
    }

    public void putExtField(String fieldName, Object value){
        this.extValues.put(fieldName, value);
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Map<String, Object> getExtValues() {
        return extValues;
    }

    public void setExtValues(Map<String, Object> extValues) {
        this.extValues = extValues;
    }
}
