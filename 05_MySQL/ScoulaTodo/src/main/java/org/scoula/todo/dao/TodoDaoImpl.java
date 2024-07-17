package org.scoula.todo.dao;

import com.mysql.cj.protocol.x.ReusableOutputStream;
import org.scoula.todo.common.JDBCUtil;
import org.scoula.todo.domain.TodoVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TodoDaoImpl implements TodoDao {
    Connection conn = JDBCUtil.getConnection();

    @Override
    public int getTotalCount(String userId) throws SQLException {
        String sql = "select count(*) from todo where userid=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                rs.next();
                return rs.getInt(1);
            }
        }
    }

    @Override
    public int create(TodoVO todo) throws SQLException {
        String sql = "insert into todo(title, description, done, userid) values(?,?,?,?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, todo.getTitle());
            stmt.setString(2, todo.getDescription());
            stmt.setBoolean(3, todo.getDone());
            stmt.setString(4, todo.getUserId());
            return stmt.executeUpdate();
        }
    }

    private TodoVO map(ResultSet rs) throws SQLException {
        TodoVO todo = new TodoVO();
        todo.setId(rs.getLong("id"));
        todo.setTitle(rs.getString("title"));
        todo.setDescription(rs.getString("description"));
        todo.setDone(rs.getBoolean("done"));
        todo.setUserId(rs.getString("userid"));
        return todo;
    }

    private List<TodoVO> mapList(ResultSet rs) throws SQLException {
        List<TodoVO> todoLlist = new ArrayList<TodoVO>();
        while (rs.next()) {
            TodoVO todo = map(rs);
            todoLlist.add(todo);
        }
        return todoLlist;
    }

    @Override
    public List<TodoVO> getList(String userId) throws SQLException {
        String sql = "select * from todo where userid=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, userId);
            try(ResultSet rs = stmt.executeQuery()){
                return mapList(rs);
            }
        }
    }

    @Override
    public Optional<TodoVO> get(String userId, Long id) throws SQLException {
        String sql = "select * from todo where userid=? and id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, userId);
            stmt.setLong(2, id);
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    return Optional.of(map(rs));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<TodoVO> search(String userId, String keyboard) throws SQLException {
        String sql = "select * from todo where userid=? and (title like ? or description like ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, userId);
            stmt.setString(2, keyboard);
            stmt.setString(3, keyboard);
            try(ResultSet rs = stmt.executeQuery()){
                return mapList(rs);
            }
        }
    }

    @Override
    public int update(String userId, TodoVO todo) throws SQLException {
        String sql = "update todo set title=?, description=?, done=? where userId=? and id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, todo.getTitle());
            stmt.setString(2, todo.getDescription());
            stmt.setBoolean(3, todo.getDone());
            stmt.setString(4, userId);
            stmt.setLong(5, todo.getId());
            return stmt.executeUpdate();
        }
    }

    @Override
    public int delete(String userId, Long id) throws SQLException {
        String sql = "delete from todo where userid=? and id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, userId);
            stmt.setLong(2, id);
            return stmt.executeUpdate();
        }
    }
}
