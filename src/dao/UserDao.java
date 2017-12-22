package dao;

import domain.User;

import java.util.List;

public interface UserDao {
    User find (User c);
    User find (String cid);
}
