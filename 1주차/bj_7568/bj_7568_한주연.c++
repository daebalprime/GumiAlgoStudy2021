package bj_7568;
#include <iostream>
#include <vector>
#include <math.h>
#include <array>
#include <algorithm>

using namespace std;

int n;
vector<pair<pair<int, int>,int>> man;
int a, b;

int main() {

	ios::sync_with_stdio(false);
	cin.tie(NULL);
	
	cin >> n;
	for (int i = 1; i <= n; i++) {
		cin >> a;
		cin >> b;
		man.push_back(make_pair(make_pair(a, b),1));
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (i == j)
				continue;
			if (man.at(i).first.first < man.at(j).first.first && man.at(i).first.second < man.at(j).first.second) {
				man.at(i).second++;
			}
		}
	}


	for (int i = 0; i < n; i++) {
		cout << man.at(i).second << " ";
	}
	cout << "\n";
	
	return 0;
}
