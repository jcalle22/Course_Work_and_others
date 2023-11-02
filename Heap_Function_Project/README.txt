README
main.cpp:
contains variables above a switch statement for the purpose of using the heap functions
char c - contains the instruction to be executed
int i, v, f - contain the additional parameters of the instructions from util.cpp
Util u - util object meant for executing nextCommand(i, v, f)
heapMade - checks to see whether a heap has been created, prevents fuctions from occuring otherwise
switchstatement:
case s - terminates program
case c - initializes heap and sets heapPointer = new heap
case r - reads file, if there is no file it does not run, if the first value of HEAPinput is incorrect it does not run
if the input is too high for the heap capacity it does not run. Creates temporary element array to copy elements into the 
actual array of the heap object and then deletes the temporary array and closes the filestream.
case w - uses the heapPointer to print the current heap information, does not run if heap is not initialized
case i - inserts element of int v into the heap and displays the information before and after if the flag variable int i
is 2. Does not run if the heap is not initialized
case d - deletes an element of the heap and displays the heap information before and after if the flag variable int i is 2
does not run if the heap is not initialized
case k - decreases the key of an element at index v to new key value of int f and displays the heap information before and after
if the flag variable i is 2. Does not run if the heap is not initialized

heap.h: Contains the prototypes of the functions of heap.cpp, these functions will be explained in heap.cpp
heap.cpp: Contains the function implementation of heap.h
Heap(capacity_input) - constructor takes input of capacity and creates a new heap of the new capacity and sets the size of H to capacity_input + 1
Do not know if necessary. The size is defaulted to zero since no input has been taken.
initialize(capacity) - calls constructor of Heap and returns the created heap
buildHeap(heap, Element* array, size_input) - sets size of created array to size_input and creates temporary array taken from input file
and copies the keys into the array of the heap. Calls minheapify to create min heap out of the input array. Does not run if size is greater than capacity
minHeapify(heap, size, index) - takes heap size and index to create a minHeap out of the element array, makes parent less than both children at every node
insert(heap, flag, key_input) - inserts element with key = key_input into the heap and displays the info before and after if the flag is set to 2. If the 
insertion excedes previous capacity, increases to capacity to the power of 2 closest to previous capacity but still greater
deleteMin(heap, flag) - deletes the element at the first index of the heap and shifts the rest of the nodes accordingly. if flag is 2 then the info is 
displayed before and after
decreaseKey(heap, flag, index, value) - takes element at entered index and decreases the key to the input value. Does not work if the value is greater \
than the inputed index key. If flag is 2 then the information is displayed before and after.
parent(int index) - returns the index of the parent of the inputed index
printHeap(heap) - prints the heap information

element.h: Contains the prototype constructor of the element object
element.cpp: Contains the constructor of the element object
Element(key) - creates an element object and sets the key attribute to the inputed key

util.h: Contains the prototype constructor of the util object 
util.cpp: 
nextCommand(i, v, f) - takes char input and different integer depending on the instruction mentioned in main.cpp
All of the instructions take input from the keyboard and relay the instruction character and the integer inputs into main.cpp
