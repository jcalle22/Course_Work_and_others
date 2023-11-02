#ifndef _HEAP_H
#define _HEAP_H
#include "element.h"
class Heap{
	public:
		int capacity;
		int size;
		Element** H;
		Heap(int capacity_input);//DONE/Works
		Heap initialize(int capacity); //DONE/Works
		void buildHeap(Heap &k, Element* array[], int size_input);//DONE/Works
		void insert(Heap &k, int flag, int key);//DONE/Works
		int deleteMin(Heap &k, int flag);//DONE/NTT
		void minHeapify(Heap &heap, int size, int i);//DONE/Works?
		void decreaseKey(Heap &k, int flag, int index, int value);//DONE/Works
		void printHeap(Heap k);//DONE/Works
		int parent(int index);//DONE/Works
		~Heap();
};
#endif
