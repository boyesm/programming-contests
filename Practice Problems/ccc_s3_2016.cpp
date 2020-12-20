#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    // store basic input

    int number_of_restaurants;
    int number_of_pho;

    cin >> number_of_restaurants;
    cin >> number_of_pho;

    vector<int> pho_restaurants;

    // store pho restaurants

    int temp_pho;

    for (int i = 0; i < number_of_pho; i++)
    {
        cin >> temp_pho;
        pho_restaurants.push_back(temp_pho);
    }

    // create adjacency list

    vector<int> adj[number_of_restaurants];

    int temp_in1;
    int temp_in2;

    for (int i = 0; i < number_of_restaurants; i++)
    {
        cin >> temp_in1;
        cin >> temp_in2;
        adj[temp_in1].push_back(temp_in2);
    }

    return 0;
}