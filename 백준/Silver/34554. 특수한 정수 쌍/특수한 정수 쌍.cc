#include <iostream>
#include <vector>
using namespace std;

#define MAX_N 1000001

std::vector<bool> isPrime(MAX_N, true);

void sieve() {
    isPrime[0] = isPrime[1] = false;
    for (int i = 2; i * i <= MAX_N; ++i) {
        if (isPrime[i]) {
            for (int j = i * i; j <= MAX_N; j += i) {
                isPrime[j] = false;
            }
        }
    }
}

int main() {
    cin.tie(NULL);
    ios::sync_with_stdio(false);

    int T;
    cin >> T;

    sieve();

    while(T--){
        int n;
        cin >> n;

        if (isPrime[n+1]) {
            cout << "1\n";
            cout << "1 "<< n+ 1 << "\n";
        } else {
            cout << "0\n";
        }

    }

    return 0;
}