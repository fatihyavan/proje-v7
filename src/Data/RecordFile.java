package Data;

public class RecordFile {
    private int value;

    private String name;
    private String country;
    private String category;
    private String year;


    public RecordFile(String year, String name, String country, int value, String category) {
        super();
        this.year = year;
        this.name = name;
        this.country = country;
        this.value = value;
        this.category = category;
    }

    public int getValue() {
        return value;
    }

    public String getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }


}
