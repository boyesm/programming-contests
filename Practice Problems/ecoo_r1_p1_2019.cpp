#include <bits/stdc++.h>
using namespace std;

// int numberOfShirts = 1;
// int numberOfEvents = 3;
// int numberOfDays = 10;

// vector<int> eventDays = {2, 5, 9};

int numberOfShirts;
int numberOfEvents;
int numberOfDays;

vector<int> eventDays;

void findLaundryDays()
{
    int numberOfLaundryDays = 0;
    int cleanShirts = numberOfShirts;

    for (int i = 0; i < numberOfDays; i++)
    {
        if (cleanShirts == 0)
        {
            numberOfLaundryDays++;
            cleanShirts = numberOfShirts;
        }

        cleanShirts--;

        int numberOfEventsToday = count(eventDays.begin(), eventDays.end(), i + 1);

        numberOfShirts += numberOfEventsToday;
        cleanShirts += numberOfEventsToday;
    }

    cout << numberOfLaundryDays << "\n";

    return;
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    for (int i = 0; i < 10; i++) // loops through all 10 datasets
    {
        cin >> numberOfShirts;
        cin >> numberOfEvents;
        cin >> numberOfDays;

        for (int e = 0; e < numberOfEvents; e++)
        {
            int temp;
            cin >> temp;
            eventDays.push_back(temp);
        }

        findLaundryDays();

        eventDays.clear();
    }

    return 0;
}