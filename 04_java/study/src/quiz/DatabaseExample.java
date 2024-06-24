package quiz;

public class DatabaseExample {
    public static void main(String[] args) {
        Database database = new Database();
        System.out.println("데이터베이스: " + database.connect());
        database.close();
    }
}
