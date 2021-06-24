public enum DataForTests {

    NAME("Bard"),
    NAME_FOR_CHANGE("Ray"),
    ID(5),
    STATUS("available");


    private String text;
    private int number;

    DataForTests(String text) {
        this.text = text;
    }
    DataForTests(int number) {
        this.number = number;
    }

    public String getText() {
        return text;
    }

    public int getInt(){
        return number;
    }
}