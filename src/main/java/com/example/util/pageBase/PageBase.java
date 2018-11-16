/**
 * FileName: PageBase
 * Author:   韩旭杰
 * Date:     2018/11/14 14:15
 * Description: 分页配置信息
 */
package com.example.util.pageBase;

/**
 * 说明：〈分页配置信息〉
 * 变量需要根据前台的框架进行改变，layui 是page和limit
 *
 * @author 韩旭杰
 * @create 2018/11/14
 * @since 1.0.0
 */
public class PageBase {
    private int page;
    private int limit;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
