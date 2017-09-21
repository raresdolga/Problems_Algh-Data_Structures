#include <bits/stdc++.h>
using namespace std;

void brackets(string partial, int Pair, int sz, vector<string> result){
    if(sz == 0){
        while(Pair > 0){
            partial += ")";
            Pair--;
        }
        cout << partial<<"\n";
        result.push_back(partial);
        return ;
    }
    brackets(partial + "(", Pair+1, sz-1, result);
    while( Pair > 0){
        Pair--;
        brackets(partial + ")", Pair, sz,  result);
        //brackets(partial + "(", c + 1, sz - 1,  result);
    }
}

// solution 2 build with 3 from 1
vector<string> add_onSmaller(int sz){
    vector<string> solution;
    if(sz == 1){
        solution.push_back("()");
        return solution;
    }
    vector<string> smaller_set = add_onSmaller(sz - 1);
    for(int i = 0; i < smaller_set.size(); i++){
        solution.push_back("(" +smaller_set.at(i) + ")");
        solution.push_back("()" + smaller_set.at(i));
        solution.push_back(smaller_set.at(i) + "()");
    }
}
int main()
{
    int nr;
    cin >> nr;
    vector<string> res;
    //brackets("",0,nr,res);
    res = add_onSmaller(nr);
    for(int i = 0; i < res.size(); i++)
        cout << res.at(i) << "\n";
    return 0;
}
