package com.wuzi.vo;

import lombok.Data;

/**
 * @program: sell
 * @author: HM
 * @create: 2018-03-24 13:35
 * @description: 返回的对外层对象
 **/
@Data
public class ResultVO<T> {

    /**
     * 状态码
     */
    private Integer code;


    /**
     * 提示信息
     */
    private String msg;

    /**
     * 返回的具体内容
     */
    private T data;

    public ResultVO(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 创建执行成功的的返回码
     *
     * @return
     */
    public static ResultVO createRightResult() {
        return new ResultVO(0, "执行成功");
    }


    /**
     * 创建操作失败的返回码
     *
     * 失败的提示码 “操作失败”
     * @return
     */
    public static ResultVO createErrorResult() {
        return new ResultVO(-0, "操作失败");
    }

    public static ResultVO createErrorResult(String msg) {
        return new ResultVO(-0, msg);
    }

}
