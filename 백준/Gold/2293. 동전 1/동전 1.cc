#include <cstdio>

using namespace std;

int main(){
    int n,m;
    scanf("%d %d",&n,&m);
    
    int dp[100001]={0};
    int coin[100001]={0};

    for(int i=1; i<=n; i++){
        scanf("%d",&coin[i]);
    }

    dp[0]=1;
    //코인 개수
    for(int i=1; i<=n; i++){
        //금액
        for(int j=1; j<=m; j++){
            if(j -coin[i] >=0) 
                dp[j] = dp[j] + dp[j-coin[i]];
        }
    }

    printf("%d\n", dp[m]);
    return 0;
}
