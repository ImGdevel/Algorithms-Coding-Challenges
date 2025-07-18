#include <iostream>
#include <queue>
using namespace std;

#define MAX 2000

int R, C;
int d4[4][2] = {{1,0},{-1,0},{0,1},{0,-1}};
int area[MAX][MAX];
bool visited[MAX][MAX] = {false};


int bfs(int r, int c){

	queue<pair<int,int>> q;
	q.push({r,c});
	visited[r][c] = true;
	int score = (area[r][c] == 0)? 1 : -2;
	
	while(!q.empty()){
		pair<int,int> node = q.front();
		q.pop();
		for(int i=0; i<4; i++){
			int nr = node.first + d4[i][0];
			int nc = node.second + d4[i][1];

			if(nr >= 0 && nc >= 0 && nr < R && nc < C && visited[nr][nc] != true){
				if(area[nr][nc] == 0){