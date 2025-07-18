#include <iostream>
#include <vector>
#include <queue>

using namespace std;

#define MAX 1001

char map[MAX][MAX];
//vector<pair<int,int>> start_p;
pair<int,int> end_p;
bool visited[MAX][MAX] = {false};

int main() {

	int R, C;
	cin >> R >> C;

	queue<pair<int,int>> q;

	for(int r = 0; r < R; r++){
		for(int c = 0; c < C; c++){
			cin >> map[r][c];
			char ch = map[r][c];
			if(ch == '&'){
				end_p = {r,c};
			}else if(ch == '@'){
				q.push({r,c});
				visited[r][c] = true;
			}
		}
	}

	int d4[4][2] = {{1,0},{-1,0},{0,1},{0,-1}};
	int days = 0;
	bool find = false;
	while(!q.empty() && !find){

		int size = q.size();
		for(int i=0; i<size && !find; i++){
			pair<int,int> node = q.front();
			q.pop();
			for(int i=0; i<4 && !find; i++){
				int nr = d4[i][0] + node.first;
				int nc = d4[i][1] + node.second;
				if(nr >= 0 && nc >= 0 && nr < R && nc < C 
					&& !visited[nr][nc] && map[nr][nc] != '#'){
					if(map[nr][nc] == '&'){
						find = true;
						break;
					}	
					q.push({nr,nc});
					visited[nr][nc] =- true;
				}
			}
		}
		if(!find){
			days++;
		}
	}
	if(find){
		cout << days;
	}else{
		cout << -1;
	}
	

	return 0;
}