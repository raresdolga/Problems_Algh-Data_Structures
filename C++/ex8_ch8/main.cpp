#include <bits/stdc++.h>
#include<unordered_map>
using namespace std;
 vector<int> frec; // directly initialized with 0

void perm(unordered_map<char, int> frec, string partial, int sz, vector<string> result){
    if(sz == 0){
        result.push_back(partial);
        return ;
    }
    else{
        for(int i = 'a'; i <= 'z'; i++){
                int cont = frec.find(i);
                if(cont > 0)
                frec.insert(i,cont--);
                perm(frec,partial.push_back(i), sz--, result);
                // add character back for the other branches of the permutation
                frec.insert(i,cont);
        }

    }


 }
int main()
{
    /*string a;
    cin >> a;
   for(int i = 0; i < a.size(); i++){
        frec[a.at(i) - '0']++;
    }*/

    /*for(int i = 0; i < a.size(); i++)
        cout<<c[i];
    cout<<"\n";*/
/*    vector<string> permutations = perm(c,a.size());
    for(int i = 0; i < permutations.size(); i++){
        cout<<permutations.at(i)<<"\n";
    }
    cout << permutations.size();
    */
    return 0;
}
