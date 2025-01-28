package LinkedList.singlylinkedlist.inventorymanagementsystem;

public class InventoryMain {
    public static void main(String[] args) {
        InventoryManagement inventory = new InventoryManagement();

        inventory.addAtBeginning("Lpatop",101,5,50000.0);
        inventory.addAtEnd("phone",102,10,30000.0);
        inventory.addAtPosition("Tablet",103,7,20000.0,1);
        System.out.println("\nAll Items:");
        inventory.displayItems();

        System.out.println("\nUpdating Quantity:");
        inventory.updateQuantity(102, 15);

        System.out.println("\nSearching for Item with ID 101:");
        inventory.searchItem("101");

        System.out.println("\nCalculating Total Inventory Value:");
        inventory.calculateTotalValue();

        System.out.println("\nSorting by Price in Ascending Order:");
        inventory.sortInventory("price", true);
        inventory.displayItems();

        System.out.println("\nRemoving Item with ID 103:");
        inventory.removeByItemId(103);

        System.out.println("\nAll Items After Removal:");
        inventory.displayItems();
    }

    }

