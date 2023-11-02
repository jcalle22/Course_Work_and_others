#include "heap.h"
#include "cmath"
#include <iostream>
using namespace std;
Heap::Heap(int capacity_input) {
    capacity = capacity_input;
    H = new Element*[capacity_input + 1];
    size = 0;
}

Heap Heap::initialize(int capacity) {
	Heap* newHeap = new Heap(capacity);
	return (*newHeap);
}

void Heap::buildHeap(Heap &k, Element* array[], int size_input) {
    if(size_input <= k.capacity) {
        k.size = size_input;
        for (int i = 1; i <= k.size; i++) {
            Element* newEl = new Element(array[i]->key);
            k.H[i]= newEl;
        }
        for (int j = k.size/2; j >= 1; j--) {
            minHeapify(k, k.size, j);
        }
    }
    else
        cout<<"Error: Size of heap cannot be greater than capacity";
}

void Heap::minHeapify(Heap &heap, int size, int i) {
	int min=i;
	Element* temp; //For swapping
	int left = (2 * i);
	int right = (2 * i) + 1;
	if ((left <= size) && ((heap.H[left]->key) < (heap.H[i]->key))){
	    min = left;
	}
	if ((right <= size) && ((heap.H[right]->key) < (heap.H[min])->key)) {
	    min = right;
	}
	if (min != i) {
		temp = heap.H[i];
	    heap.H[i] = heap.H[min];
		heap.H[min] = temp;
		minHeapify(heap, size, min); //recursive call from root of swapped index
	}
	
}

void Heap::insert(Heap &k, int flag, int key_input) {
    if (flag == 1 || flag == 2) {
        int newCapacity = 2;
        if(flag == 2) {//Printing before the insertion
            cout<<"The capacity is "<<k.capacity<<"."<<endl;
            cout<<"Size is "<<k.size<<"."<<endl;
            for(int i = 1; i <= k.size; i++) {
                cout<<k.H[i]->key<<endl;
            }
        }
        Element* element = new Element(key_input);
        if (k.size + 1 > k.capacity) {
            while(newCapacity <= k.size) {
                newCapacity = newCapacity * 2;
            }
            k.capacity = newCapacity; 
        }
        k.size += 1; //Increasing size of the Heap
        k.H[k.size] = element; //Last element of the heap is set to new element
        for (int j = k.size/2; j >= 1; j--) { //Need to minHeapify 
            minHeapify(k, k.size, j);
        }
        if(flag == 2) {//Printing after the insertion
            cout<<"The capacity is "<<k.capacity<<"."<<endl;
            cout<<"Size is "<<k.size<<"."<<endl;
            for(int i = 1; i <= k.size; i++) {
                cout<<k.H[i]->key<<endl;
            }
        }
    } else
        cout<<"This is not a valid flag value. This operation cannot be completed."<<endl;
}

int Heap::deleteMin(Heap &k, int flag) {
    if (flag == 1 || flag == 2) {
        if(k.size < 1) {
            cout<<"There are no elements in heap to delete.";
            return 0;
        }
        else {
            for (int j = k.size/2; j >= 1; j--) {
                minHeapify(k, k.size, j);
            }
            int min = k.H[1]->key; //Min value is the first value of the Heap
            if(flag == 2) { //Prints the heap before the deletion
                cout<<"The capacity is "<<k.capacity<<"."<<endl;
                cout<<"Size is "<<k.size<<"."<<endl;
                for(int i = 1; i <= k.size; i++) {
                    cout<<k.H[i]->key << "\n";
                }
            }
            k.H[1] = k.H[size];
            k.size--;
            k.minHeapify(k, k.size, 1);
            if(flag == 2) { //Prints the heap after the deletion
                cout<<"The capacity is "<<k.capacity<<"."<<endl;
                cout<<"Size is "<<k.size<<"."<<endl;
                for(int i = 1; i <= k.size; i++) {
                    cout<<k.H[i]->key<<endl;
                }
            }
            return min;
        }
    } else
        cout<<"This is not a valid flag value. This operation cannot be completed."<<endl;
    return 0;
}

void Heap::decreaseKey(Heap &k, int flag, int index, int value) {
    if(index > k.size) {
        cout<<"There are only "<<k.size<<" elements in the heap. Hence this operation cannot be completed"<<endl;
    }
    else if(value > k.H[index]->key) {
        cout<<value<<" cannot be larger than the current value in the heap at index "<<index<<". Hence this operation cannot be completed"<<endl;
    }
    else if (flag != 1 && flag != 2) {
        cout<<"This is not a valid flag value. This operation cannot be completed."<<endl;
    }
    else {
         if(flag == 2) { //Prints the heap before the key decrease
            cout<<"Before Key Decrease"<<endl;
            for(int i = 1; i <= k.size; i++) {
                cout<<k.H[i]->key<<endl;
            }
        }
        k.H[index]->key = value;
        for (int j = ((k.size)/2); j >= 1; j--) {
            minHeapify(k, k.size, j);
        }
        if(flag == 2) { //Prints the heap after the key decrease
            cout<<"After Key Decrease"<<endl;
            for(int i = 1; i <= k.size; i++) {
                cout<<k.H[i]->key <<endl;
            }
        }
        
    }
}

int Heap::parent(int index) {
    int parent;
    if((index % 2) != 0)
        parent = index/2;
    else 
        parent = (index - 1)/2;
    return parent;
}

void Heap::printHeap(Heap k) {
    cout<<"The capacity is "<<k.capacity<< endl;
    cout<<"Size is "<<k.size<< endl;
    for(int i = 1; i <= k.size; i++) {
        cout<<(k.H[i]->key)<< endl;
    }
    
}

Heap::~Heap() {
    //destructor
}
