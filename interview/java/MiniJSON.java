package com.yupaopao.bixintech.interview;

/**
 * @author aborn (jiangguobao)
 * @date 2022/10/27 11:45
 */
public class MinJson {

    public static void main(String[] args) {
        String json = "{a: 1, b: \"bvalue\", \"c-obj\": {c1: 1, c2: true, c3: \"v3\"}";
        MinJson minJson = fromJson(json);
        String res = minJson.toJSONString();
        System.out.println(res);
    }

    public static MinJson fromJson(String json) {

        MinJson minJson = new MinJson();
        // todo 这里写功能实现

        return  minJson;
    }

    public String toJSONString() {
        String json = new String();
        // todo 实现将MinJson对象转成 json 字符串功能
        return json;
    }
}
