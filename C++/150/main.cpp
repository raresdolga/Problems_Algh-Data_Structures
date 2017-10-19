//Problem        : Mystery Message
//Language       : C++
//Compiled Using : g++
//Version        : GCC 4.9.1
//Input for your program will be provided from STDIN
//Print out all output from your program to STDOUT

#include <iostream>
#include <string>
#include <algorithm>
#include <climits>

using namespace std;
int findSpace(string input){
    int i;
    for(i = input.size() - 1; i >= 0; i--){
        if(input.at(i) == ' ')
        return i;
    }
    return -1;
}

int main() {

int n;
int k = 0;
string input[6];
int x ;
char y;
int out;
for(int i = 0; i < 6; i++){
    cin >> input[i];

}
    x = input[n - 1].at(0) - input[0].at(0);
    x = (x + 26)%26;
    y = input[n-1].at(1) + x;
    if(input[0].at(1) != y){
        out =  (26 + x)%26;
    }
    else out = x;

cout << out;
    return 0;
}
