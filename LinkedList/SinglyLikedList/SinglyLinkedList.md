# Single Linked List

## Why

- For Data insrtionand deletion Arrays can be expensive
- LInkeedList on the other hand has dynamic sie and akes inserion and deletion easy
- One issue wit LinkedList is that there is no order in these type of list so we can not have random acesss

## Operations

### Push (Add New Node to the end of the list)

- First create a new Node
- Check if the list has head
  - If the list does not have head, update the head to be the new Node and the tail to be the new node
  - If the list does have head and the tail is not undefined, in that case updathe current tails next value to point to the new Node and the tail will be the new Node
- Finally increment the size of list

### Pop (Remove the last Node)

- Check if there is no head (Empty List), in this case return undefined
- Initialise a pointer `current` to the head of the list
- Initialise a pointer `newTail` to the head as well
- Traverse the list untill `current` reached the last node (Where `current.next` is null)
  - In each iteration, update the `newTail` to the current node
  - Move the `current` to the next node
- At this point, `current` is the last node in the list
- Update the tail of the list as the `newTail`
- Set the next of the tail to be null
- Decrement the length
- Finally f the list becomes empty, set both head and tail to be null

### Shift (Deleting the first Node)

- Check if there is no head (Empty List), in this case return `undefined`
- If the head is not null, create a new variable and assign the current head to this variable
- Initialise a pointer `currentHead` to the head of the list
- Next, point `this.head` of the list as the pointers next value
- Decrease the length of the list, if this results in length 0, set the tail as `null`
