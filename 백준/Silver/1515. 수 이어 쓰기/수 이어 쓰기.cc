#include<iostream>
#include<vector>
#include<string>
#include<queue>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);  cout.tie(NULL);
    
    string str;
    cin >> str;

    queue<char> index;
    for (char ch : str) {
        index.push(ch);
    }


    int num = 0;
    while (!index.empty()) {
        int x = ++num;
        string s = to_string(x);
        for (int i = 0; i < s.size(); i++) {
            if (!index.empty() && index.front() == s[i]) {
                index.pop();
            }
        }
    }
    cout << num;
}
