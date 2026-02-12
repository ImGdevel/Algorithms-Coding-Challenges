#include <iostream>
#include <math.h>


using namespace std;

int main() {
    cin.tie(NULL);
    ios::sync_with_stdio(false);

    int i = 1;
    while (true)
    {

        long R;
        cin >> R;

        if(!cin) break;
        if (R == 0) break;

        long r, c;
        cin >> r >> c;

        long DD = pow(R , 2) * 4;
        long dd = pow(r, 2) + pow(c, 2);


        if (DD >= dd ){
            cout << "Pizza "<< i << " fits on the table.\n";
        }else{
            cout << "Pizza "<< i  <<" does not fit on the table.\n";   
        }
        i++;
    }



    return 0;
}