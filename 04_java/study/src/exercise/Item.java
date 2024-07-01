package exercise;

public class Item extends GameObject {
    String type;

    public Item(String name, int x, int y, String type) {
        super(name, x, y);
        this.type = type;
    }

    public void use() {
        System.out.printf("%s is used. It is a %s.", name, type);
    }
}
