#include <bits/stdc++.h>
using namespace std;

vector<int> xcoords, ycoords;

void split(string str)
{
    int x, y;
    string tmp = "";

    for (int i = 0; i < str.length(); i++)
    {
        if (str[i] == ',')
        {
            istringstream iss(tmp);
            iss >> x;
            tmp = "";

            continue;
        }

        tmp += str[i];
    }

    istringstream iss(tmp);
    iss >> y;

    xcoords.push_back(x);
    ycoords.push_back(y);

    return;
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n_paintdrops;
    string temp;
    vector<int> corner1, corner2;

    cin >> n_paintdrops;

    for (int i = 0; i < n_paintdrops; i++)
    {
        cin >> temp;
        split(temp);
    }

    sort(xcoords.begin(), xcoords.end());
    sort(ycoords.begin(), ycoords.end());

    corner1.push_back(xcoords[0] - 1);
    corner1.push_back(ycoords[0] - 1);

    corner2.push_back(xcoords[n_paintdrops - 1] + 1);
    corner2.push_back(ycoords[n_paintdrops - 1] + 1);

    cout << corner1[0] << "," << corner1[1] << "\n"
         << corner2[0] << "," << corner2[1];

    return 0;
}