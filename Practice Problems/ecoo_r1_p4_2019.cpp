#include <bits/stdc++.h>
using namespace std;

int numberOfStops;
int numberOfPassengers;

vector<vector<int>> busses;
vector<vector<int>> passengers;

void process()
{
    int numberOfBusses = 1;
    int currentPassengers = 0;

    for ()

        return;
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> numberOfStops;
    cin >> numberOfPassengers;

    vector<int> passOn;
    vector<int> passOff;

    int temp;

    for (int i = 0; i < numberOfPassengers; i++)
    {
        cin >> temp;
        passOn.push_back(temp);

        cin >> temp;
        passOff.push_back(temp);
    }

    for (int i = 0; i < numberOfStops; i++)
    {
        passengers.push_back({i + 1, count(passOn.begin(), passOn.end(), i + 1), count(passOff.begin(), passOff.end(), i + 1)}); // (stop, numberOn, numberOff)
    }

    return 0;
}