class ListNode<T> {
  value: T;
  next: ListNode<T> | null;

  constructor(value: T) {
    this.value = value;
    this.next = null;
  }
}

class SinglyLinkedList<T> {
  head: ListNode<T> | null;
  tail: ListNode<T> | null;
  length: number;

  constructor() {
    this.head = null;
    this.length = 0;
  }

  // Push => Add New Node to the end of the list
  push(value: T) {
    let newNode = new ListNode(value);
    if (!this.head) {
      this.head = newNode;
      this.tail = this.head;
    } else if (this.tail) {
      this.tail.next = newNode;
      this.tail = newNode;
    }
    this.length++;
    return this;
  }

  //Pop => Remove the last Node
  pop() {
    //check if there is no head
    if (!this.head) return undefined;
    let current = this.head;
    let newTail = current;
    while (current.next) {
      newTail = current;
      current = current.next;
    }
    this.tail = newTail;
    this.tail.next = null;
    this.length--;

    if (this.length === 0) {
      this.head = null;
      this.tail = null;
    }
    return current;
  }

  // Shift => Deleting the first Node
  shift() {
    if (!this.head) return undefined;
    let currentHead = this.head;
    this.head = currentHead.next;
    this.length--;
    if (this.length === 0) {
      this.tail = null;
    }
    return currentHead;
  }

  // UnShift => Add new node at the begining of the list
  unshift(value: T) {
    let newNode = new ListNode(value);
    if (!this.head) {
      this.head = newNode;
      this.tail = this.head;
    } else {
      newNode.next = this.head;
      this.head = newNode;
    }
    this.length++;
    return this;
  }

  // GET => get the node at a specified index
  get(index: number) {
    if (index < 0 || index >= this.length) return null;
    let counter = 0;
    let current = this.head;

    while (current && counter !== index) {
      current = current?.next;
      counter++;
    }
    return current;
  }

  // SET => Change the node at a given index
  set(index: number, value: T) {
    let currentNode = this.get(index);
    if (currentNode) {
      currentNode.value = value;
      return currentNode;
    } else {
      return false;
    }
  }
}
