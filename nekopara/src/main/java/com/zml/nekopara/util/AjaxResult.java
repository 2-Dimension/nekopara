package com.zml.nekopara.util;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by zhumeilu on 2017/6/6.
 */
public class AjaxResult {

    @Getter
    @Setter
    private boolean success;
    @Getter
    @Setter
    private String msg;

    public AjaxResult(){

    }
    public AjaxResult(boolean success,String msg){
        this.success = success;
        this.msg = msg;
    }
}
