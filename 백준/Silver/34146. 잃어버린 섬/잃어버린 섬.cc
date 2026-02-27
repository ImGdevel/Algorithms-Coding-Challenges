#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_map>

using namespace std;

int main(){
    cin.tie(nullptr);
    std::ios::sync_with_stdio(false);

    int N, M;
    cin >> N >> M;

    unordered_map<int, int> count;
    for(int i=0, n; i<N; i++){
        for(int j=0; j<M; j++){
            cin >> n;
            count[n]++;
        }
    }

    int hal = 0, jjack = 0;

    for(auto& p : count){
        int n = p.second;
        if(n % 2 == 0){
            jjack++;
        } else {
            hal++;
        }

        //cout << "n: " << p.first << " count: " << n << " hal: " << hal << " jjack: " << jjack << "\n";
    }



    if(M % 2 == 0){
        if(hal > 0){
            cout << "NO";
        }else{
            cout << "YES";
        }
    }else{
        hal -= N;
        if (hal > 0){
            cout << "NO";
        }else{
            cout << "YES";
        }
    }

    return 0;
}