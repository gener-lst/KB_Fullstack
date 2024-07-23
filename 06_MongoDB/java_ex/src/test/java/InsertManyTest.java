import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertManyResult;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

// JS에서는 배열을 매개변수로 줌
// JAVA에서는 리스트로 줌(-> document에 대한 리스트)
public class InsertManyTest {
    public static void main(String[] args) {
        MongoCollection<Document> collection = Database.getCollection("todo");

        List<Document> insertList = new ArrayList<>();

        Document document1 = new Document();
        Document document2 = new Document();

        document1.append("title", "Dune2 영화보기");
        document1.append("desc", "이번 주말 IMAX로 Dune2 영화보기");
        document1.append("done", false);

        document2.append("title", "Java MongoDB 연동");
        document2.append("desc", "Java로 MongoDB 연동 프로그래밍 연습하기");
        document2.append("done", false);

        insertList.add(document1);
        insertList.add(document2);

        InsertManyResult result = collection.insertMany(insertList);
        System.out.println("==> InsertManyResult : " + result.getInsertedIds());

        Database.close();
    }
}