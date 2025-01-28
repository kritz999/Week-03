package LinkedList.singlylinkedlist.socialmediafriendconnections;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SocialMediaMain {
    public static void main(String[] args) {
        SocialMedia sm = new SocialMedia();

        // Adding users
        sm.addUser(1, "Alice", 25);
        sm.addUser(2, "Bob", 30);
        sm.addUser(3, "Charlie", 22);

        // Adding friend connections
        sm.addFriendConnection(1, 2);
        sm.addFriendConnection(1, 3);

        // Display friends of Alice
        sm.displayFriends(1);

        // Search for a user
        sm.searchUser("Bob", -1);

        // Find mutual friends between Alice and Bob
        sm.findMutualFriends(1, 2);

        // Count the number of friends for each user
        sm.countFriends();

        // Remove a friend connection
        sm.removeFriendConnection(1, 2);

        // Display all users
        sm.displayAllUsers();
    }
}
