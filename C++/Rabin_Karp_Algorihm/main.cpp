/*
Finding a substring S in a string B
*/
#include<stdlib.h>
#include <iostream>
#include<string.h>
#include<string>
#include<math.h>
using namespace std;

const int baze = 128; //number of characters

    int hash_function(char c []){
        int n = 0;
        int length = strlen(c);
        for(int i = 0; i < length; i++){
            n += pow(baze,(length - i - 1))*(c[i] -'0');
        }
        return n;
    }
    int* map_Hash(char str[], int subLength){
        int lengthStr = strlen(str);
        //initialize with 0 as well
        int* hashArr = (int*) calloc(sizeof(int),lengthStr - subLength + 1);
        char subStr [subLength];

        strncpy(subStr,str,subLength);

        *hashArr = hash_function(subStr);

        int previous;
        for(int i = 1; i < lengthStr - subLength + 1; i++){
            //do not make strncpy for each char but subtract the previous and add the char at i+sub -str-length
             previous = *(hashArr + i - 1) - (str[i - 1] - '0')* (pow(baze,(subLength -1)));
            *(hashArr+i) = previous*baze + str[i + subLength - 1]-'0';


        }

        return hashArr;
    }

    bool verifyIfSubString(int * hasedArray, int length, char subString [], char Str [], int encodedSub) {
        int i ;
        int subStrLength = strlen(subString);
        for(i = 0; i < length; i++){
            if(*(hasedArray + i) == encodedSub){
                if(strncmp(Str + i,subString, subStrLength) == 0)
                    return true;
            }
        }

        return false;
    }

int main()
{
    // read in a safe way(over flow) even if it is more costful
    string s1,s2;
    getline(cin,s1);
    getline(cin,s2);
    int n1 = s1.length();
    int n2 = s2.length();

    char str[n1];
    char subStr[n2];

    strcpy(str,s1.c_str());
    strcpy(subStr,s2.c_str());
 cout<<strlen(subStr)<<" ";
    int * hashArr = map_Hash(str,n2);
    int encodedSub = hash_function(subStr);
    cout<<encodedSub<<"\n";
    bool check = verifyIfSubString(hashArr, n1 - n2 +1 , subStr, str, encodedSub);

    cout<<check;
    return 0;
}
