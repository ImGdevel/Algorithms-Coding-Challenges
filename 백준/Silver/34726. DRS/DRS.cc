#include <iostream>
#include <vector>
#include <string>
#include <set>
#include <algorithm>

using namespace std;

bool idRange(int n){
    return (0 < n && n <= 1000);
}

int main() {
    cin.tie(NULL);
    ios::sync_with_stdio(false);

    int N, K;
    cin >> N >> K;
    set<string> answers;
    vector<pair<int,string>> data;
    int sum_dist = 0;
    for(int i=0; i<N; i++){
        string name;
        int gap;        
        cin >> name >> gap;
        sum_dist += gap;
        sum_dist %= K;
        data.push_back({K - sum_dist , name});
        if(i == 0){
            data.push_back({0 , name});
        }
    }

    sort(data.begin(), data.end());

    for(int i=0; i < data.size(); i++){
        string current_name = data[i].second;
        int current_dist = data[i].first;
        int idx = i;

        if(answers.find(current_name) != answers.end()) continue;
        // 나보다 빠른차 확인
        for(int j = idx + 1; j < data.size() ; j++){
            if(data[j].second == current_name) continue;
            int gap = abs(data[j].first - current_dist);

            if(idRange(gap)){
                answers.insert(current_name);
                break;
            }
        }
    }

    if(answers.empty()){
        cout << -1;
        return 0;
    }

    for(string name : answers){
        cout << name << " ";
    }

}