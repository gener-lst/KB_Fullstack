import com.mongodb.client.MongoCollection;
import domain.Todo;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class App {
    public static void main(String[] args) {
        MongoCollection<Todo> collection = Database.getCollection("todo", Todo.class);
        // insertOne
        Todo newtodo = new Todo(null, "POJO", "POJO 테스트 확인", false);
        collection.insertOne(newtodo);
        // insertMany
        List<Todo> newTodos = Arrays.asList(
                new Todo(null, "POJO2", "POJO2 테스트 확인", false),
                new Todo(null, "POJO3", "POJO3 테스트 확인", true),
                new Todo(null, "POJO4", "POJO4 테스트 확인", false)
        );
        collection.insertMany(newTodos);
        // find()
        List<Todo> todos = new ArrayList<>();
        collection.find().into(todos);
        // find() 자리에 BSON 형태의 쿼리를 집어넣어도 동작함 -> 해당 쿼리의 조건대로
        for (Todo todo : todos) {
            System.out.println(todo);
        }
        // findOne()
        String id = "666a6296f4fe57189cd03eea";
        Bson query = eq("_id", new ObjectId(id));
        Todo todo = collection.find(query).first();
        System.out.println("==> findByIdResult : " + todo);
        Database.close();
    }
}