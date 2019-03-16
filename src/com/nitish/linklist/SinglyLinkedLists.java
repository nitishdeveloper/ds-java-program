package com.nitish.linklist;

import java.util.Scanner;

class Node {
	protected int data;
	protected Node next;

	public Node() {
		next = null;
		data = 0;
	}

	public Node(int d, Node n) {
		data = d;
		next = n;
	}

	public void setNext(Node n) {
		next = n;
	}

	public void setData(int d) {
		data = d;
	}

	public Node getNext() {
		return next;
	}

	public int getData() {
		return data;
	}
}
 
class linkedList
{
    protected Node head;
    protected Node tail ;
    public int size ;
 
    public linkedList()
    {
        head = null;
        tail = null;
        size = 0;
    }
    /*  Function to check if list is empty  */
    public boolean isEmpty()
    {
        return head == null;
    }
    /*  Function to get size of list  */
    public int getSize()
    {
        return size;
    }    
    /*  Function to insert an element at begining  */
    public void insertAtStart(int val)
    {
        Node newNode = new Node(val, null);    
        size++ ;    
        if(head == null) 
        {
            head = newNode;
            tail = head;
        }
        else 
        {
            newNode.setNext(head);
            head = newNode;
        }
    }
    /*  Function to insert an element at end  */
    public void insertAtEnd(int val)
    {
        Node newNode = new Node(val,null);    
        size++ ;    
        if(head == null) 
        {
            head = newNode;
            tail = head;
        }
        else 
        {
            tail.setNext(newNode);
            tail = newNode;
        }
    }
    /*  Function to insert an element at position  */
    public void insertAtPos(int val , int pos)
    {
        Node newNOde = new Node(val, null);                
        Node ptr = head;
        pos = pos - 1 ;
        for (int i = 1; i < size; i++) 
        {
            if (i == pos) 
            {
                Node tmp = ptr.getNext() ;
                ptr.setNext(newNOde);
                newNOde.setNext(tmp);
                break;
            }
            ptr = ptr.getNext();
        }
        size++ ;
    }
    /*  Function to delete an element at position  */
    public void deleteAtPos(int pos)
    {        
        if (pos == 1) 
        {
            head = head.getNext();
            size--; 
            return ;
        }
        if (pos == size) 
        {
            Node s = head;
            Node t = head;
            while (s != tail)
            {
                t = s;
                s = s.getNext();
            }
            tail = t;
            tail.setNext(null);
            size --;
            return;
        }
        Node ptr = head;
        pos = pos - 1 ;
        for (int i = 1; i < size - 1; i++) 
        {
            if (i == pos) 
            {
                Node tmp = ptr.getNext();
                tmp = tmp.getNext();
                ptr.setNext(tmp);
                break;
            }
            ptr = ptr.getNext();
        }
        size-- ;
    }    
    /*  Function to display elements  */
    public void display()
    {
        System.out.print("\nSingly Linked List = ");
        if (size == 0) 
        {
            System.out.print("empty\n");
            return;
        }    
        if (head.getNext() == null) 
        {
            System.out.println(head.getData() );
            return;
        }
        Node ptr = head;
        System.out.print(head.getData()+ "->");
        ptr = head.getNext();
        while (ptr.getNext() != null)
        {
            System.out.print(ptr.getData()+ "->");
            ptr = ptr.getNext();
        }
        System.out.print(ptr.getData()+ "\n");
    }
}
 
/*  Class SinglyLinkedList  */
public class SinglyLinkedLists
{    
    public static void main(String[] args)
    {             
        Scanner scan = new Scanner(System.in);
        /* Creating object of class linkedList */
        linkedList list = new linkedList(); 
        System.out.println("Singly Linked List Test\n");          
        char ch;
        /*  Perform list operations  */
        do
        {
            System.out.println("\nSingly Linked List Operations\n");
            System.out.println("1. insert at begining");
            System.out.println("2. insert at end");
            System.out.println("3. insert at position");
            System.out.println("4. delete at position");
            System.out.println("5. check empty");
            System.out.println("6. get size");            
            int choice = scan.nextInt();            
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter integer element to insert");
                list.insertAtStart( scan.nextInt() );                     
                break;                          
            case 2 : 
                System.out.println("Enter integer element to insert");
                list.insertAtEnd( scan.nextInt() );                     
                break;                         
            case 3 : 
                System.out.println("Enter integer element to insert");
                int num = scan.nextInt() ;
                System.out.println("Enter position");
                int pos = scan.nextInt() ;
                if (pos <= 1 || pos > list.getSize() )
                    System.out.println("Invalid position\n");
                else
                    list.insertAtPos(num, pos);
                break;                                          
            case 4 : 
                System.out.println("Enter position");
                int p = scan.nextInt() ;
                if (p < 1 || p > list.getSize() )
                    System.out.println("Invalid position\n");
                else
                    list.deleteAtPos(p);
                break;
            case 5 : 
                System.out.println("Empty status = "+ list.isEmpty());
                break;                   
            case 6 : 
                System.out.println("Size = "+ list.getSize() +" \n");
                break;                         
             default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
            /*  Display List  */ 
            list.display();
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');               
    }
}