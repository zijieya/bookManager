package bookmanager.web.model;

public class Book {
    private int bookId;//图书编号
    private String bookName;//图书名称
    private String bookAuthor;//图书作者
    private String bookPress;//图书出版社
    private  float bookPrice;//图书价格
    private String bookDescription;//图书描述
    private String bookPhotoUri;//图书图片地址
    private int  isBorrowed;//是否被借阅

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPress() {
        return bookPress;
    }

    public void setBookPress(String bookPress) {
        this.bookPress = bookPress;
    }

    public float getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(float bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public String getBookPhotoUri() {
        return bookPhotoUri;
    }

    public void setBookPhotoUri(String bookPhotoUri) {
        this.bookPhotoUri = bookPhotoUri;
    }

    public int getIsBorrowed() {
        return isBorrowed;
    }

    public void setIsBorrowed(int isBorrowed) {
        this.isBorrowed = isBorrowed;
    }
}
