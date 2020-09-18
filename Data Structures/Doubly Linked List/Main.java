
class Node<X> {
   X value;
   Node<X> next;
   Node<X> prev;

   Node(X value) {
      this.value = value;
      this.next = null;
      this.prev = null;
   }

   @Override
   public String toString() {
      return "\tNode value: " + value + "\n";
   }

}

class DLL<X> {
   int length = 0;
   Node<X> head;
   Node<X> tail;

   DLL(X value) {
      this.head = new Node<X>(value);
      this.tail = this.head;
      this.length++;
   }

   // Adds element at the last
   // Constant time complexity
   void append(X value) {
      if (value == null) {
         return;
      }
      Node<X> newNode = new Node<>(value);
      newNode.prev = this.tail;
      this.tail.next = newNode;
      this.tail = newNode;
      this.length++;
   }

   // Adds element at the first
   // Constant time compl
   void prepend(X value) {
      if (value == null) {
         return;
      }
      Node<X> newNode = new Node<>(value);
      newNode.next = this.head;
      this.head.prev = newNode;
      this.head = newNode;
      this.length++;
   }

   // Adds element at an index
   // Linear time complexity O(n)
   void insert(int index, X value) {
      if (index < 0 || index >= this.length) {
         System.out.println("Cannot insert in " + index);
         return;
      }
      Node<X> newNode = new Node<X>(value);
      Node<X> leader = this.traverseToIndex(index - 1);
      Node<X> follower = leader.next;
      leader.next = newNode;
      follower.prev = newNode;
      newNode.prev = leader;
      newNode.next = follower;
      this.length++;
   }

   // Remove element from an index
   // linear time complexity
   void remove(int index) {
      if (this.head == null) {
         System.out.println("Cannot remove : List Empty");
         return;
      }
      if (index < 0 || index >= this.length) {
         System.out.println("Cannot delete in " + index);
         return;
      }
      if (index == 0) {
         System.out.println("Node deleted with value=" + this.head.value);
         this.head = this.head.next;
         this.head.prev = null;
      } else {
         Node<X> leader = this.traverseToIndex(index - 1);
         System.out.println(leader);
         System.out.println("Node deleted with value=" + leader.next.value);
         if (index == this.length - 1) {
            leader.next = null;
            this.tail = leader;
         } else {
            Node<X> follower = leader.next.next;
            leader.next = follower;
            follower.prev = leader;
         }
      }
      this.length--;
   }

   // reverses the linked list
   // linear time complexity
   void reverse() {
      if (this.head == null) {
         System.out.println("Cannot reverse : List Empty");
         return;
      }
      // for only one element : there is no change
      if (this.head.next == null) {
         return;
      }

      Node<X> newTail = this.head;
      Node<X> newHead = this.tail;
      Node<X> current = this.head;
      while (current != null) {
         Node<X> temp = current.prev;
         current.prev = current.next;
         current.next = temp;
         current = current.prev;
      }
      this.head = newHead;
      this.head.prev = null;

      this.tail = newTail;
      this.tail.next = null;
      System.out.println((this.toString()));
   }

   // Traverse to index
   // Linear time complexity
   Node<X> traverseToIndex(int index) {
      Node<X> leader = this.head;
      int iter = 0;
      while (index != iter) {
         iter++;
         leader = leader.next;
      }
      return leader;
   }

   // displays the list
   // linear time complexity
   @Override
   public String toString() {
      Node<X> leader = this.head;
      String result = "\nDLL\nhead: " + head + "length: " + length + "\ntail: " + tail + "\n";
      result += "List:\n";
      while (leader != null) {
         result += leader;
         leader = leader.next;
      }
      return result;
   }

}

class Main {
   public static void main(String[] args) {
      DLL<String> doublyLinkedList = new DLL<>("Banana");
      doublyLinkedList.prepend("Apple");
      doublyLinkedList.append("Orange");
      doublyLinkedList.append("Choco");
      System.out.println(doublyLinkedList);
      doublyLinkedList.insert(2, "kitkat");
      System.out.println(doublyLinkedList);
      doublyLinkedList.remove(2);
      System.out.println(doublyLinkedList);
      doublyLinkedList.reverse();

      DLL<Integer> doublyLinkedList2 = new DLL<>(10);
      doublyLinkedList2.append(25);
      doublyLinkedList2.append(65);
      System.out.println(doublyLinkedList2);
      doublyLinkedList2.reverse();
   }
}