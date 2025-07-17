#include <iostream>
#include <unordered_set>

using namespace std;

int main() {

	unordered_set<int> set;
	int N;
	cin >> N;

	for(int i=0; i<N; i++){
		int n;
		cin >> n;
		if(set.find(-n) == set.end()){
			set.insert(n);
		}else{
			set.erase(-n);
		}
	}

	int sum = 0;
	for(int n : set){
		sum += n;
	}
	cout << sum;
	
	return 0;
}