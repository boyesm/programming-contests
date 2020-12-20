#include <bits/stdc++.h>
using namespace std;

vector<int> permutation;
vector<vector<int>> all_permutations;

int n = 9;
bool chosen[10];

void search()
{
    if (permutation.size() == n)
    {
        //
    }
    else
    {
        for (int i = 1; i <= n; i++)
        {
            if (chosen[i])
                continue;
            chosen[i] = true;
            permutation.push_back(i);
            search();
            chosen[i] = false;
            permutation.pop_back();
        }
    }
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    search();

    // sort(all_subsets.begin(), all_subsets.end());

    for (int i = 0; i < all_permutations.size(); i++)
    {
        for (int j = 0; j < all_permutations[i].size(); j++)
            cout << all_permutations[i][j] << " ";
        cout << "\n";
    }

    return 0;
}