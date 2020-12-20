#include <bits/stdc++.h>
using namespace std;

int bothDays = 0;

void occupied(char yd, char td)
{
    if (yd == 'C' && td == 'C')
    {
        bothDays++;
    }
    return;
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int numberOfSpaces;
    cin >> numberOfSpaces;

    string yesterdaySpots;
    string todaySpots;
    cin >> yesterdaySpots;
    cin >> todaySpots;

    for (int i = 0; i < numberOfSpaces; i++)
    {
        occupied(yesterdaySpots[i], todaySpots[i]);
    }

    cout << bothDays << "\n";

    return 0;
}