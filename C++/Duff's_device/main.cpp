#include <iostream>

using namespace std;
void foo(int index){
    cout << index <<" ";
}

int main()
{
    int x;
    cin >> x;
    int t = x % 5;
    x /= 5; // important to be before the goto instructions
    int i = 0;
    switch(t){
        case 0: break;
        case 1: goto l5;
        case 2: goto l4;
        case 3: goto l3;
        case 4: goto l2;
    }

   do{ // for loop is wrong because it considers x-- at the end of inner instructions so we have one iteration less
        x--;
        foo(i + 1);
        l2: foo(i + 2);
        l3: foo(i + 3);
        l4: foo(i + 4);
        l5: foo(i + 5);
    }while(x > 0);

    return 0;
}
