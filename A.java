import java.util.*;
class CircularLinkedList{
    private Node head;

    class Node{
        Node next;
        int value;
        Node(int value){
            this.value = value;
        }
    }  //Circular Linked list 

    public void searchElement(int value){
        if(head == null){
            System.out.println("empty list..");
        }else if(head.next == head && head.value == value){
            System.out.println("found");
        }else{
            boolean flag = false;
            Node tmp = head;
            while(tmp.next != head){
                if(tmp.value == value){
                    System.out.println("found");
                    return;
                }
                tmp = tmp.next;
            }
            if(tmp.value == value){
                System.out.println("found");
                return;
            }
            if(flag != true){
                System.out.println("not found");
            }
        }
    }
    //reverse your list
    public void reverseRecords(Node rr){
        if(rr == null){
            System.out.println("empty list..");
        }else if(rr.next == head){
            System.out.println(rr.value);
        }else{
            reverseRecords(rr.next);
            System.out.println(rr.value);
        }
    }

    //delete a node
    public void deleteRecord(int position){
        if(position >= 0 && head!=null){
            Node tmp = head;
            Node tmp2 = head;
            if(position == 0){
                tmp = head;
                if(head.next == head){
                    head = null;
                    return;
                }
                while(tmp.next != head){
                    tmp = tmp.next;
                }
                head = head.next;
                tmp.next = head;
                return;
            }else{
                int index = 0;
                while(tmp.next != head && index<=position){
                    index++;
                    tmp2 = tmp;
                    tmp = tmp.next;
                }
                System.out.println(position+" "+index);
                if(position-index>1){
                    System.out.println("please provide sahi index..");
                    return;
                }
                
                // System.out.println(position+" "+index);

                if(tmp.next == head && position == index){
                    System.out.println("last index h bhai");
                    tmp2.next = head;
                    tmp.next = null;
                    return;
                }else if(tmp.next != head && position == index-1){
                    tmp = head;
                    tmp2 = head; index = 0;
                    while(index < position){
                        index++;
                        tmp2 = tmp;
                        tmp = tmp.next;
                    }
                    tmp2.next = tmp.next;
                    tmp.next = null;
                    return;
                }
            }
        }else{
            System.out.println("please provide sahi postition");
            System.out.println("ya to pahle record dal do list me bhai");
        }
    }

    //insert into a postion
    public void insertRecords(int position,int value){
        int index = 0;
        Node newNode = new Node(value);
        if(position == 0 && head.next == head){
            newNode.next = head;
            head = newNode;
            newNode.next.next = head;
            return;
        }else{
            Node tmp = head;
            Node tmp2 = head;
            while(tmp.next != head && index < position){
                index++;
                tmp2 = tmp;
                tmp = tmp.next;
            }
            if(index-position == index  && head.next != head){
                // System.out.println("ram ram");
                tmp = head;
                while(tmp.next != head){
                    tmp = tmp.next;
                }

                newNode.next = head;
                tmp.next = newNode;
                head = newNode;
                return;
            }
            if(tmp.next == head && index == position ){
                tmp2.next = newNode;
                newNode.next = tmp;
            }else if(tmp.next != head && position == index){
                newNode.next = tmp;
                tmp2.next = newNode;
            }else if(tmp.next == head && position == index+1){
                tmp.next = newNode;
                newNode.next = head;
            }else if((position-index)>1){
                throw new ArrayIndexOutOfBoundsException("glat bat bete sahi index do");
            }
            
        }
    }

    //add some records//
    public void add(int value){
        Node newNode = new Node(value);
        if(head == null){
            head = newNode;
            newNode.next = head;
        }else{
            Node tmp = head;
            while(tmp.next != head){
                tmp = tmp.next;
            }
            tmp.next = newNode;
            newNode.next = head;
        }

    }
    //show my records
    public void showRecords(){
        Node tmp = head;
        if(head == null){
            System.out.println("you have entered empty list here..");
        }else{
            while(tmp.next != head){
                System.out.println(tmp.value);
                tmp = tmp.next;
            }
            System.out.println(tmp.value);
        }
    }
    //public getter method to acces the private variable head
    public Node getHead(){
        return this.head;
    }
}
class A{
    static Scanner sc = new Scanner(System.in);
    public static void main(String args[]){
        CircularLinkedList list = new CircularLinkedList();
        while(true){
            System.out.println("please enter 1 if you want to add records..");
            System.out.println("please enter 2 if you want to insert a records in an specific index..");
            System.out.println("please enter 3 if yor want to revers the list..");
            System.out.println("please enter 4 if you want to delete a record into a specific index..");
            System.out.println("please enter 5 if you want to search a record");
            System.out.println("please enter 6 if you want to show Records..");

            int val = sc.nextInt();
            if(val == 1){
                System.out.println("please enter some value that have to add..");
                int value = sc.nextInt();
                list.add(value);
            }else if(val == 2){
                System.out.println("please enter some value that you have to insert into the list..");
                int value = sc.nextInt();
                System.out.println("please enter index");
                int index= sc.nextInt();
                list.insertRecords(index,value);
            }else if(val == 3){
                System.out.println("your reverse list is ..");

                list.reverseRecords(list.getHead());
            }else if(val == 4){
                System.out.println("please enter the index where you want to delete the records..");
                int index= sc.nextInt();
                list.deleteRecord(index);
            }else if(val == 5){
                System.out.println("please enter the record that have to search..");
                int index= sc.nextInt();
                list.searchElement(index);
            }else if(val == 6){
                list.showRecords();
            }   
        }
        
    }
}
