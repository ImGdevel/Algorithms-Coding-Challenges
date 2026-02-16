#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

typedef long long ll;

int main(){
    cin.tie(nullptr);
    std::ios::sync_with_stdio(false);
    int T;
    cin >> T;
    while(T--){
        int N;
        cin>> N;
        vector<int> arr(N);
        priority_queue<ll , vector<ll>, greater<ll>> pq;
        for(int i=0; i<N; i++){
            int x;
            cin >> x;
            pq.push(x);
        }

        ll value = 0;
        while (pq.size() > 1)
        {
            ll pice1 = pq.top();
            pq.pop();
            ll pice2 = pq.top();
            pq.pop();

            ll sum = pice1 + pice2;
            value += sum;
            //cout << pice1 << " " << pice2 << " | " << sum << "\n";
            pq.push(sum);
        }   
        cout << value << "\n";
    }

    return 0;
}