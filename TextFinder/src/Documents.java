public class Documents {
    private String text;
    private String name;
    private String size;
    private String date;
    private int realSize;

    protected Documents next = null;
    protected Documents prev = null;

    public Documents(String text, String name, String size, String date) {
        this.text = text;
        this.name = name;
        this.size = size;
        this.date = date;
        this.realSize = toInt(this.size);
    }
}
