package com.yupaopao.bixintech.codereview;

/**
 * @author aborn (jiangguobao)
 * @date 2022/11/01 11:38
 */
public class CityFilter {

    /**
     * 现有的城市有以下情况：
     * "1,2,3,4"  表示城市1，2，3，4都在范围内，  这时 CityFilter.contains(1) -> true;  CityFilter.contains(5) -> false
     * "-1,-2"    表示除去 1, 2 两个城市外其他城市是在范围内  这时 CityFilter.contains(1) -> false;  CityFilter.contains(3) -> true
     * "&"        表示国内城市满足  这时： CityFilter.contains(100) -> true; CityFilter.contains(10001) -> true
     * "$"        表示海外城市满足范围内
     * 说明： 当cityid <= 10000 为国内城市， 当cityid > 10000 海外城市
     */
    private String citys;


    public boolean contains(int city) {
        // todo 自己写逻辑
        /**
         * 实现要求：最小内存使用和CPU计算
         */
        return true;
    }
}
