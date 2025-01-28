package LinkedList.singlylinkedlist.socialmediafriendconnections;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class User {
    int userId;
    String name;
    int age;
    List<Integer> friendIds;

    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
    }
}
