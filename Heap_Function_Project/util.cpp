#include "util.h"
#include <iostream>

using namespace std;

int Util::nextCommand(int *i, int *v, int *f) {
    char c;
    while(1) {
        scanf("%c", &c);
        if(c == ' ' || c == '\t' || c == '\n'){ continue;
        }
        if(c == 'S' || c == 's' || c == 'R' || c == 'r' || c == 'W'|| c == 'w' ){
            return c;
            break; //Exit loop
        }
        if(c == 'C' || c == 'c'){
            scanf("%d", i);
            return c;
            break;
        }
        if(c == 'I' || c == 'i'){ //For I f k input
            scanf("%d", i); scanf("%d", v);
            return c;
            break;
        }
        if(c == 'D' || c == 'd'){ //For D f input
            scanf("%d", i);
            return c;
            break;
        }
        if(c == 'K' || c == 'k'){ //For K f i v input
            scanf("%d", i); scanf("%d", v); scanf("%d", f); 
            return c;
            break;
        }
        cout<<"Invalid Command"<<endl;
    }
    return 0;
}

