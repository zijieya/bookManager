package bookmanager.web.model;

public class Page {
    private int pageNumber;//当前页
    private int pageSide;//每页显示的条数
    private int totalRecord;//总的记录条数
    private int totalPage;//总的页数
    private int startIndex;//从数据库中取出的第一行数据
   // private int start;//页数起点
   // private int end;//最后一页

    public Page(int pageNumber, int pageSide, int totalRecord) {
        this.pageNumber = pageNumber;
        this.pageSide = pageSide;
        this.totalRecord = totalRecord;
        if(totalRecord%pageSide==0)
            this.totalPage=totalRecord/pageSide;
        else
            this.totalPage=totalRecord/pageSide+1;
        this.startIndex=(pageNumber-1)*pageSide;

    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
    public int getPageSide() {
        return pageSide;
    }

    public void setPageSide(int pageSide) {
        this.pageSide = pageSide;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }
}
