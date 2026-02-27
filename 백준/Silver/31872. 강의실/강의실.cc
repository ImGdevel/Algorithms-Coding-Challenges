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

    vector<int> arr(N+1);
    arr[0] = 0;
    for(int i=1; i<=N; i++){
        cin >> arr[i];
    }

    sort(arr.begin(), arr.end());

    vector<int> min(N);

    for(int i = 0; i< N; i++){

        //cout <<  arr [i + 1] << " " << arr[i] << ">" << arr[i + 1] - arr[i] << "\n";
         min[i] = arr[i + 1] - arr[i];
    }
    sort(min.begin(), min.end());

    int sum = 0;
    for(int i=0; i<N - M; i++){
        sum += min[i]; 
    }

    cout << sum << "\n";

    return 0;
}