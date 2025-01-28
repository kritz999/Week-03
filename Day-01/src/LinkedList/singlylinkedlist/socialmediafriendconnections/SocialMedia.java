package LinkedList.singlylinkedlist.socialmediafriendconnections;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;



public class SocialMedia {
    private Node head;

    // Add a new user
    public void addUser(int userId, String name, int age) {
        Node newNode = new Node(new User(userId, name, age));
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("User " + name + " added.");
    }

    // Search for a user by ID
    private Node searchUserById(int userId) {
        Node temp = head;
        while (temp != null) {
            if (temp.user.userId == userId) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Add a friend connection between two users
    public void addFriendConnection(int userId1, int userId2) {
        Node user1 = searchUserById(userId1);
        Node user2 = searchUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        if (!user1.user.friendIds.contains(userId2)) {
            user1.user.friendIds.add(userId2);
        }

        if (!user2.user.friendIds.contains(userId1)) {
            user2.user.friendIds.add(userId1);
        }

        System.out.println("Friend connection added between " + user1.user.name + " and " + user2.user.name);
    }

    // Remove a friend connection
    public void removeFriendConnection(int userId1, int userId2) {
        Node user1 = searchUserById(userId1);
        Node user2 = searchUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        user1.user.friendIds.remove(Integer.valueOf(userId2));
        user2.user.friendIds.remove(Integer.valueOf(userId1));

        System.out.println("Friend connection removed between " + user1.user.name + " and " + user2.user.name);
    }

    // Find mutual friends between two users
    public void findMutualFriends(int userId1, int userId2) {
        Node user1 = searchUserById(userId1);
        Node user2 = searchUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        HashSet<Integer> mutualFriends = new HashSet<>(user1.user.friendIds);
        mutualFriends.retainAll(user2.user.friendIds);

        if (mutualFriends.isEmpty()) {
            System.out.println("No mutual friends found.");
        } else {
            System.out.print("Mutual friends: ");
            for (int id : mutualFriends) {
                System.out.print(id + " ");
            }
            System.out.println();
        }
    }

    // Display all friends of a specific user
    public void displayFriends(int userId) {
        Node user = searchUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.print("Friends of " + user.user.name + ": ");
        if (user.user.friendIds.isEmpty()) {
            System.out.println("No friends.");
        } else {
            for (int friendId : user.user.friendIds) {
                System.out.print(friendId + " ");
            }
            System.out.println();
        }
    }

    // Search for a user by Name or User ID
    public void searchUser(String name, int userId) {
        Node temp = head;
        while (temp != null) {
            if (temp.user.name.equals(name) || temp.user.userId == userId) {
                System.out.println("User found: " + temp.user.name + " (ID: " + temp.user.userId + ")");
                return;
            }
            temp = temp.next;
        }
        System.out.println("User not found.");
    }

    // Count the number of friends for each user
    public void countFriends() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.user.name + " has " + temp.user.friendIds.size() + " friends.");
            temp = temp.next;
        }
    }

    // Display all users
    public void displayAllUsers() {
        Node temp = head;
        while (temp != null) {
            System.out.println("User: " + temp.user.name + ", ID: " + temp.user.userId + ", Age: " + temp.user.age);
            temp = temp.next;
        }
    }
}
