#include <iostream>
#include <vector>

using namespace std;

int timeToInt(int h, int m){
    return h * 60 + m;
}

string toTimeStr(int n){
    string h = to_string(n / 60).length() == 1 ? "0" + to_string(n / 60) : to_string(n / 60);
    string m = to_string(n % 60).length() == 1 ? "0" + to_string(n % 60) : to_string(n % 60);
    return h + ":" + m;
}


int main() {
    cin.tie(NULL);
    ios::sync_with_stdio(false);

    int T;
    cin >> T;

    

    while (T--)
    {
        int N;
        cin >> N;
        int time = timeToInt(6,0); 
        N += 1;
        while (N > 0)
        {
            time += 6;
            N -= 50;
            if(N <= 0) break;
            time += 6;
        }
        cout << toTimeStr(time) << "\n";
    }
    
    return 0;
}