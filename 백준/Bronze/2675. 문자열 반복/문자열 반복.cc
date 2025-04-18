#include<iostream>
#include<string>

using namespace std;

int main(){
    int T;
    cin >> T;
    while(T--){
        int S;
        string str;
        cin >> S;
        cin >> str;
        
        string answer;
        
        for(char c : str){
            for(int i = 0; i < S; i++){
                answer += c;    
            }
        }
        cout << answer << endl;
    }
    
    return 0;
}
