#include <iostream>
#include<stdlib.h>
using namespace std;

typedef struct stackProp{
    int last;
    int sizeS;
    int capacity;
}stack_Prop;

int values [101];

stack_Prop* initializeArray(int n)
{
   stack_Prop *a = (stackProp*) malloc(4*sizeof(stack_Prop));
   //split in 3 parts
   for(int i = 0; i < 2; i++)
   {
    (a+i)->capacity = n/3;
    (a+i)->last = (n/3)*i - 1;
    (a+i)->sizeS = 0;
   }
    (a+2)->capacity = n - 2*(n/3);
    (a+2)->last = 2*(n/3) - 1;
    (a+2)->sizeS = 0;
    return a;
}

bool stackIsFull(stack_Prop *s,int n, int stackNum)
{
    if((s+stackNum)->capacity <= (s+stackNum)->sizeS)
        return true;
    return false;
}

int module(int n){
    if(n < 0)
        return -n;
    return n;
}
bool arrayIsFull(stack_Prop *a, int n)
{
    for(int i = 0; i < 3; i++)
       {
           if(!stackIsFull(a,n,i))
            return false;
          //  cout<<(a+i)->capacity<<" ";
       }
      // cout<<"\n";
    return true;
}
// C++ modulo returns negative for negative numbers, must adjust
int negative_mod(int n, int m)
{
    int a = m%n;
    if(a < 0)
        return n + a;
    else
        return a;
}

bool stackIsEmpty(stack_Prop s)
{
     if(s.last == -1)
            return true;
     return false;
}
void shift(stack_Prop *a, int stackNum, int n)
{
   // cout<<"Here enters"<<stackNum;
    if(stackIsFull(a ,n,stackNum))
    {
        //go to the next partition/stack
        stackNum --;
        cout<<stackNum +1<<"mas"<<"\n";
        shift(a,negative_mod(3,stackNum),n);
    }
    // -1 because started from 0
    int lastCurrent = (a+stackNum)->capacity -1 + n/3*stackNum;

    int prevS = negative_mod(3, stackNum + 1);
    cout<<prevS<<"prev ";
    //shifted just when stack to inserts is full
    (a + prevS)->sizeS ++;
    (a+stackNum)->capacity --;
    (a+prevS)->last = lastCurrent;

}

void insertS(int stackNum, stack_Prop *a, int val,int n)
{
    if(arrayIsFull(a,n))
    {
        cout<<"the array holding the 3 stacks is full";
        return ;
    }

    if(stackIsFull(a,n,stackNum))
        shift(a,negative_mod(3,stackNum - 1),n);
    else
        {
            (a+stackNum)->last ++;
            (a+stackNum)->sizeS ++;
        }
    values[(a+stackNum)->last] = val;
    //cout<<(a+stackNum)->last;

}

int pop(int stackNum, stack_Prop *a)
{
    stack_Prop s = *(a+stackNum);
     if(stackIsEmpty(s))
     {
         cout<<"Stack is empty do not have what to pop";
         return 0;
     }
     int c =  values[s.last];
     values[s.last] = 0;
     s.sizeS --;
     s.last = s.last%s.sizeS + s.last - 1;
    return c;
}

void afis(int n)
{
    for(int i = 0; i < n; i++)
        cout<<values[i]<<" ";
    cout<<"\n";
}
int main()
{
    //n is the size of the array
    int n;
    cin>>n;

    stack_Prop *arr = initializeArray(n);
    //afis(n);
    insertS(2,arr,23,n);
    insertS(2,arr,56,n);
    insertS(2,arr,34,n);
    insertS(2,arr,98,n);
    insertS(2,arr,14,n);
   // insertS(2,arr,39,n);
    afis(n);
    return 0;
}
