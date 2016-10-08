/* Glory Kim
 * UMUC CMSC 350 Project 3
 * Files: BST.java, Fraction.java, SortG.java
 */

import java.util.*;

public class BST <T extends Comparable<T>> {
   public static void main(String[] args) {
      Integer[] a = {1,5,2,7,4};
      BST<Integer> bst = new BST<Integer>();
      for(Integer n : a) bst.insert(n);

      
      System.out.println(bst.inOrderTraversal());
   }


   private Node<T> root;
   static String val;

   public BST() {
      root = null;
   }


   private int compare(T x, T y) {
      return x.compareTo(y);
   }

   public void insert(T data) {
      root = insert(root, data);
   }

   private Node<T> insert(Node<T> p, T toInsert) {
      if (p == null)
         return new Node<T>(toInsert);
      if (compare(toInsert, p.data) <= 0)
         p.left = insert(p.left, toInsert);
      else
         p.right = insert(p.right, toInsert);

      return p;
   }

   public String inOrderTraversal() {
      val="";
      inOrderHelper(root);
      return val;
   }
   private void inOrderHelper(Node r) {
      if (r != null) {
         inOrderHelper(r.left);
         //System.out.print(r+" ");
         val+=r.toString()+" ";
         inOrderHelper(r.right);
      }
   }

   private class Node<T> {
      private T data;
      private Node<T> left, right;

      public Node(T data, Node<T> l, Node<T> r) {
         left = l; right = r;
         this.data = data;
      }

      public Node(T data) {
         this(data, null, null);
      }

      public String toString() {
         return data.toString();
      }
   } //end of Node
}//end of BST