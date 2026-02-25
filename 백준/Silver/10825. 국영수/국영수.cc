#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

struct Node{
    string name;
    int ko_score;
    int en_score;
    int math_score;
};


bool compare(Node a, Node b){
    if(a.ko_score == b.ko_score){
        if(a.en_score == b.en_score){
            if(a.math_score == b.math_score){
                return a.name < b.name;
            }
            return a.math_score > b.math_score;
        }
        return a.en_score < b.en_score;
    }
    return a.ko_score > b.ko_score;
}

int main(){
    cin.tie(nullptr);
    std::ios::sync_with_stdio(false);
    int N;
    cin >> N;
    vector<Node> arr(N);
    for(int i=0; i<N; i++){
        cin >> arr[i].name >> arr[i].ko_score >> arr[i].en_score >> arr[i].math_score;
    }

    sort(arr.begin(), arr.end(), compare);

    for(Node n : arr){
        cout << n.name << "\n";
    }

    return 0;
}