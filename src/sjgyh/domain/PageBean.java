package sjgyh.domain;

import java.util.List;
@SuppressWarnings("all")
public class PageBean<T> {
    private int totalCount;     //总记录数
    private int totalPage;      //总页码 totalPage % rows == 0 ? totalPage % rows ? (totalPage % rows + 1)
    private List<T> list;          //要显示的数据集合
    private int currentPage;    //当前页码
    private int row;

    public PageBean() {
    }

    public PageBean(int totalCount, int totalPage, List<T> list, int currentPage, int row) {
        this.totalCount = totalCount;
        this.totalPage = totalPage;
        this.list = list;
        this.currentPage = currentPage;
        this.row = row;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", list=" + list +
                ", currentPage=" + currentPage +
                ", row=" + row +
                '}';
    }
}
