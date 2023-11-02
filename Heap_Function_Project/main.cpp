/******************************************************************************

                              Online C++ Compiler.
               Code, Compile, Run and Debug C++ program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <iostream>
#include <fstream>
#include <string>
#include <stdio.h>
#include <stdlib.h>
//#include "heap.h"
//#include "element.h"
#include "util.h"
using namespace std;
//12
int main()
{ 
    char c;
    int i, v, f; //Command integers
    Util u;
    Heap *heapPointer;
    int heapMade = 0;
    ifstream heapFile;
    
    while (1) {
        c = u.nextCommand(&i, &v, &f);
        switch(c) {
            case 's':
            case 'S':
            {
                printf("COMMAND: %c.\n", c); 
                cout<<"This program is going to be terminated"<<endl;
                exit(1);
            }
            
            case 'c':
            case 'C': //Creates an empty heap with capacity equal to i after calling nextCommand()
            {
                printf("COMMAND: %c %d.\n", c, i);
                heapMade = 1; //Keystone value that is necessary for the other functions to work
                Heap initHeap = heapPointer->initialize(i); //Initializing a heap of size i
                heapPointer = &initHeap; //Assigning global heap pointer to the created heap
                break;
            }
            
            case 'r'://Need to finish, have to do file reading
            case 'R':
            {
                printf("COMMAND: %c.\n", c);
                if (heapMade == 1) { //Only runs if the heap is created
                    int jump = 0; //For exiting the file reading if the capacity is too small
                    int sizeCounter = 0; //Checking to see if the 1st value of HEAPinput is accurate
                    
                    string input; //Will hold the input from the file reading
                    int intInput; //Will hold the int parsed from the input string
                    Element* array[heapPointer->capacity + 1]; //Take all except the first index from input
                   
                    heapFile.open("HEAPinput.txt");
                    if(heapFile.is_open()) {
                        getline(heapFile, input);
                        sscanf(input.c_str(), "%d", &(heapPointer->size));
                        int cap = heapPointer->capacity;
                        if (heapPointer->size > heapPointer->capacity) {
                            cout<<"Sorry!!! It cannot be done. Please increase the capacity of the heap first"<<endl;
                            jump = 1;
                            heapPointer->size = 0;
                        }
                        for(int i = 2;heapFile && jump == 0; i++) {
                            getline(heapFile, input);
                            sscanf(input.c_str(), "%d", &intInput);
                            array[i - 1] = new Element(intInput);
                            sizeCounter++;
                        }
                        if (sizeCounter - 1 != heapPointer->size && jump == 0) { //Checks to see if the first input is incorrect
                            cout<<"Sorry!!! It cannot be done. The number of elements in file is less than as specified in the beginning of file."<<endl;
                            jump = 1;
                            heapPointer->size = 0; //Resetting the incorrectly entered size from the previous loop
                            heapPointer->capacity = cap;
                        }
                        if (jump == 0) { //This section transports the inputs into the heap object
                            heapPointer->capacity = cap;//For some reason the capacity from before resets
                            heapPointer->buildHeap(*heapPointer, array, heapPointer->size);
                            for(int p = 1; p <= heapPointer->size; p++) {
                                delete array[p];
                            }
                        }
                        heapFile.close();
                        jump = 0; //Reset for future file reading
                    }
                    else {
                        cout<<"There was a problem opening file HEAPinput.txt for reading."<<endl;
                    }
                }
                else {
                    cout<<"Sorry!!! It cannot be done. Please initialize the heap first."<<endl;
                } 
                break;
            }
            
            case 'w':
            case 'W':
            {
                printf("COMMAND: %c.\n", c);
                if (heapMade == 1) {
                    heapPointer->printHeap(*heapPointer);
                }
                else {
                    cout<<"Sorry!!! It cannot be done. Please initialize the heap first."<<endl;
                }
                break;            
            }
            
            case 'i':
            case 'I':
            {
                printf("COMMAND: %c %d %d.\n", c, i, v);
                if (heapMade == 1) {
                    heapPointer->insert(*heapPointer, i, v); //i is flag, v is key
                }
                else {
                    cout<<"Sorry!!! It cannot be done. Please initialize the heap first."<<endl;
                }
                break;
            }
            
            case 'd':
            case 'D': 
            {
                printf("COMMAND: %c %d.\n", c, i);
                if (heapMade == 1) {
                    if (heapPointer->size > 0) {
                        cout<<heapPointer->deleteMin(*heapPointer, i)<<endl; //i is flag
                    }
                    else
                        heapPointer->deleteMin(*heapPointer, i);
                }
                else {
                    cout<<"Sorry!!! It cannot be done. Please initialize the heap first and put elements into it."<<endl;
                }
                break;
            }
                
            case 'k':
            case 'K':
            {    
                printf("COMMAND: %c %d %d %d.\n", c, i, v, f);
                if (heapMade == 1 && heapPointer->size >= 1) {
                    heapPointer->decreaseKey(*heapPointer, i, v, f); //i is flag, v is index, f is new key
                }
                else {
                    cout<<"Sorry!!! It cannot be done. Please initialize the heap first and put the elements into it."<<endl;
                }
                break;
            }
            default: break;
        }
    } 
    return 0;
}


