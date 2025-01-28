package LinkedList.singlylinkedlist.inventorymanagementsystem;

public class InventoryManagement {
    private Node head;

    // Add an item at the beginning
    public void addAtBeginning(String itemName, int itemId, int quantity, double price) {
        Node newNode = new Node(new Item(itemName, itemId, quantity, price));
        newNode.next = head;
        head = newNode;
    }

    // Add an item at the end
    public void addAtEnd(String itemName, int itemId, int quantity, double price) {
        Node newNode = new Node(new Item(itemName, itemId, quantity, price));
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Add an item at a specific position
    public void addAtPosition(String itemName, int itemId, int quantity, double price, int position) {
        if (position == 0) {
            addAtBeginning(itemName, itemId, quantity, price);
            return;
        }
        Node newNode = new Node(new Item(itemName, itemId, quantity, price));
        Node temp = head;
        int currentIndex = 0;
        while (temp != null && currentIndex < position - 1) {
            temp = temp.next;
            currentIndex++;
        }
        if (temp == null) {
            System.out.println("Position out of bounds, adding at the end.");
            addAtEnd(itemName, itemId, quantity, price);
        } else {
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    // Remove an item by Item ID
    public void removeByItemId(int itemId) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        if (head.item.itemId == itemId) {
            head = head.next;
            System.out.println("Item with ID " + itemId + " removed.");
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.item.itemId != itemId) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Item with ID " + itemId + " not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Item with ID " + itemId + " removed.");
        }
    }

    // Update the quantity of an item by Item ID
    public void updateQuantity(int itemId, int newQuantity) {
        Node temp = head;
        while (temp != null) {
            if (temp.item.itemId == itemId) {
                temp.item.quantity = newQuantity;
                System.out.println("Updated quantity of Item ID " + itemId + " to " + newQuantity);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item with ID " + itemId + " not found.");
    }

    // Search for an item by Item ID or Item Name
    public void searchItem(String searchKey) {
        Node temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.item.itemName.equalsIgnoreCase(searchKey) || Integer.toString(temp.item.itemId).equals(searchKey)) {
                System.out.println("Item Found: " + temp.item.itemName + " | ID: " + temp.item.itemId +
                        " | Quantity: " + temp.item.quantity + " | Price: " + temp.item.price);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("No item found with key: " + searchKey);
        }
    }

    // Calculate and display the total value of the inventory
    public void calculateTotalValue() {
        Node temp = head;
        double totalValue = 0;
        while (temp != null) {
            totalValue += temp.item.quantity * temp.item.price;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: " + totalValue);
    }

    // Display all items
    public void displayItems() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        Node temp = head;
        System.out.println("Inventory Items:");
        while (temp != null) {
            System.out.println("Name: " + temp.item.itemName + " | ID: " + temp.item.itemId +
                    " | Quantity: " + temp.item.quantity + " | Price: " + temp.item.price);
            temp = temp.next;
        }
    }

    // Sort the inventory by Item Name or Price
    public void sortInventory(String criteria, boolean ascending) {
        if (head == null || head.next == null) return;
        head = mergeSort(head, criteria, ascending);
    }

    private Node mergeSort(Node node, String criteria, boolean ascending) {
        if (node == null || node.next == null) return node;

        Node middle = getMiddle(node);
        Node nextOfMiddle = middle.next;
        middle.next = null;

        Node left = mergeSort(node, criteria, ascending);
        Node right = mergeSort(nextOfMiddle, criteria, ascending);

        return merge(left, right, criteria, ascending);
    }

    private Node merge(Node left, Node right, String criteria, boolean ascending) {
        if (left == null) return right;
        if (right == null) return left;

        int comparison = 0;
        if (criteria.equalsIgnoreCase("name")) {
            comparison = left.item.itemName.compareToIgnoreCase(right.item.itemName);
        } else if (criteria.equalsIgnoreCase("price")) {
            comparison = Double.compare(left.item.price, right.item.price);
        }

        if (ascending ? comparison <= 0 : comparison > 0) {
            left.next = merge(left.next, right, criteria, ascending);
            return left;
        } else {
            right.next = merge(left, right.next, criteria, ascending);
            return right;
        }
    }

    private Node getMiddle(Node node) {
        if (node == null) return null;
        Node slow = node, fast = node.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
