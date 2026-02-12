#include <iostream>
#include <vector>
#include <math.h>


using namespace std;

int main() {
    cin.tie(NULL);
    ios::sync_with_stdio(false);

    int N;
    cin >> N;

    int count = 0;
    
    for(int i=0; i<N; i++){
        string str;
        cin >> str;
        int len = str.length();
        bool find = true;
        for(int j=0; j< len / 2; j++){
            if(str[j] != str[len - 1 - j]){
                find = false;
                break;
            }
        }
        if (find) {
            count++;
        }
        
    }

    

    int answer = (count * (count - 1)) / 2;
    cout << answer * 2 << "\n";

    return 0;
}