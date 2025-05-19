#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

ll mulmod(ll a, ll b, ll mod) {
    __int128 res = (__int128)a * b % mod;
    return (ll)res;
}

ll powmod(ll base, ll exp, ll mod) {
    ll result = 1;
    base %= mod;
    while (exp > 0) {
        if (exp & 1) result = mulmod(result, base, mod);
        base = mulmod(base, base, mod);
        exp >>= 1;
    }
    return result;
}

bool millerRabin(ll n, vector<ll> bases = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37}) {
    if (n < 2) return false;
    if (n == 2 || n == 3) return true;
    if (n % 2 == 0) return false;

    ll d = n - 1;
    int r = 0;
    while (d % 2 == 0) {
        d /= 2;
        r++;
    }

    for (ll a : bases) {
        if (a >= n) break;
        ll x = powmod(a, d, n);
        if (x == 1 || x == n - 1) continue;
        bool continue_outer = false;
        for (int i = 1; i < r; ++i) {
            x = mulmod(x, x, n);
            if (x == n - 1) {
                continue_outer = true;
                break;
            }
        }
        if (continue_outer) continue;
        return false;
    }
    return true;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);

    int T;
    cin >> T;
    while (T--) {
        ll A, B;
        cin >> A >> B;
        ll S = A + B;

        if (S <= 3) {
            cout << "NO\n";
        } else if (S % 2 == 0) {
            cout << "YES\n";
        } else {
            if (millerRabin(S - 2)) cout << "YES\n";
            else cout << "NO\n";
        }
    }
    return 0;
}
