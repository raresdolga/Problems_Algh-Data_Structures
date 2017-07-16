#include <iostream>
#include<stdlib.h>

using namespace std;

    typedef struct stackNode {
        int data;
        stackNode *next;
    } node_t;

    typedef struct StackSet {
        int sizeS;
        stackNode *head;
    }stackSet;

    //treat insert in the head as normal stackCreate
    int maxSize, stackNum = -1;

    bool stackIsFull(StackSet *arr) {
        if((arr + stackNum)->sizeS >= maxSize)
            return true;
        return false;
    }

    bool stackIsEmpty(StackSet *arr) {
        //here we used size, but for a normal stack I would have to compare with NULL
        if(arr -> sizeS == 0)
            return true;
        return false;
    }

   void createStack(stackSet *arr, int data) {
        stackNum ++;
        node_t *head = (node_t*) malloc(sizeof(node_t));
        head -> data = data;
        head -> next = NULL;
        (arr+stackNum) -> head =  head;
        (arr+stackNum) -> sizeS = 1;

    }

    void insertS(int data, stackSet* arr){

        if(stackIsFull(arr)) {
            createStack(arr,data);
            return ;
        }

        node_t * newNode = (node_t *) malloc(sizeof(node_t));
        newNode -> data = data;
        newNode -> next = (arr + stackNum) -> head;
        (arr + stackNum) -> head = newNode;
       // cout<<((arr + stackNum) -> head ) -> data;
        (arr + stackNum) -> sizeS ++;
    }

    int popS(stackSet *arr) {
      if(stackIsEmpty(arr + stackNum) && stackNum == 0) {
          cout<<"There are no elements left to pop"<<"\n";
          return 0 ;
      }
      else
      if(stackIsEmpty(arr + stackNum)) {
            stackNum --;
        }
      int aux = ((arr + stackNum) -> head) -> data;
      (arr + stackNum) -> head = ((arr + stackNum) -> head) -> next;

      return aux;
    }

    void afis(stackSet *arr) {
        int index = stackNum;
        while( index >= 0){
            node_t * head = (arr + index) ->head;
            while(head != NULL)
            {
                cout<< head -> data<<" ";
                head = head -> next;
            }
            cout<<"\n";
            index --;
        }
    }

    int popAtS(int nr, stackSet *arr) {
        if(nr > stackNum)
            {
                cout<<"this stack does not exist";
            return 0;
            }
        if(stackIsEmpty((arr + nr)))
           cout<<"this stack is empty, pop from another stack\n";
        int aux = ((arr + nr) -> head) -> data;
        node_t * aux2 = ((arr + nr) -> head) -> next;
        free(((arr + nr) -> head) -> next);
        (arr + nr) -> head = aux2;
        return aux;
    }

int main()
{
    stackSet *arr = (stackSet *) malloc(100*sizeof(stackSet));
    cin >>maxSize;
   /*
   Test data
   */
    // first character inserted is treated in a special case
    createStack(arr,5);

    insertS(7,arr);
    insertS(32,arr);
    insertS(765,arr);
    insertS( -4,arr);
    afis(arr);
    popS(arr);
    afis(arr);
    cout<<popAtS(0,arr)<<"\n";
    afis(arr);
    return 0;
}
