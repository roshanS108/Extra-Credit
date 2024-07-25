public class HashMap<K,V>{
    SinglyLinkedList <K,V>[] arrayBucket; // array that stores K key and V value using linked list;
    int size; // no# of elements in the map
    int cap; // total no# of elements that can be put on map

    @SuppressWarnings("unchecked")
    public HashMap(){  // Default hashmap - set the initial size and cap
        size = 0;
        cap = 5;
        arrayBucket = new SinglyLinkedList[cap]; // create a array of linked list with initial capacity 5
        for( int i = 0 ; i<cap; i++){ // at every cell in the array create a linked list
            /*
             *  |dh0| - | | - | | -
             *  |dh1| - | | -
             *  |dh2| - | | - | | -
             *  |dh3| - | | - | | - | | -
             */
            arrayBucket[i] = new SinglyLinkedList<>();
        }
    }

    @SuppressWarnings("unchecked")
    public HashMap(int c){ // non default - same as default but we change the capacity to be the passed capacity parameter(c)
        size = 0;
        cap = c;
        arrayBucket = new SinglyLinkedList[cap];
        for( int i = 0 ; i<cap; i++){
            arrayBucket[i] = new SinglyLinkedList<>();
        }
    }

    public void put(K key, V value){
        int index = key.hashCode()%cap;
        SingleNode<K, V> curr = arrayBucket[index].dummyhead.next; // using dummy head we start at the first node
        while(curr != null){
            if(curr.data.getKey() == key){
                curr.data.setValue(value);
            }
        }
        arrayBucket[index].insertLast(new Pair<>(key, value));
        size++;

    }

    public V get(K key){
        int index = key.hashCode()%cap;
        SingleNode<K, V> curr = arrayBucket[index].dummyhead.next;
        while(curr != null){
            if(curr.data.getKey() == key){
                return curr.data.getValue();
            }
            curr = curr.next;
        }
        return null;
    }

    public void PrintMap(){ // same, no generic need
        for(int i = 0; i < cap; i++){
            System.out.print(i + " | ");
            arrayBucket[i].printList();
            System.out.println();
        }
    }
}
