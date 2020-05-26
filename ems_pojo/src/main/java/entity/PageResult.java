package entity;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: PageResult
 * @Description: TODO
 * @Autor:13528
 * @Date: 2020/3/16 10:54
 * @Version 1.0
 **/
public class PageResult implements Serializable {
    private int total;
    private List rows;

    public PageResult(int total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
