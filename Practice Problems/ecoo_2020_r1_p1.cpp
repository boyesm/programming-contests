#include <bits/stdc++.h>
using namespace std;

map<string, int> nmap;

int difnotes(int n1, int n2)
{
    if (n1 > n2)
    {
        n2 += 12;
        return n2 - n1;
    }
    else
    {
        return n2 - n1;
    }
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;
    string note;
    vector<int> difference;
    vector<string> curnotes;
    vector<string> notes = {"C",
                            "C#",
                            "D",
                            "D#",
                            "E",
                            "F",
                            "F#",
                            "G",
                            "G#",
                            "A",
                            "A#",
                            "B"};

    for (int i = 0; i < notes.size(); i++)
    {
        nmap.insert({notes[i], i});
    }

    // cout << difnotes(12, 3);

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < 4; j++)
        {
            cin >> note;
            curnotes.push_back(note);
        }

        for (int k = 1; k < 4; k++)
        {
            difference.push_back(difnotes(nmap[curnotes[k - 1]], nmap[curnotes[k]]));
            // cout << difnotes(nmap[curnotes[k - 1]], nmap[curnotes[k]]) << " ";
        }
        difference.push_back(difnotes(nmap[curnotes[3]], nmap[curnotes[0]]));

        // for (int op = 0; op < 4; op++)
        // {
        //     cout << difference[op] << " ";
        // }
        // cout << "\n";

        if (difference[0] == 4 && difference[1] == 3 && difference[2] == 3)
        {
            cout << "root\n";
            difference.clear();
            curnotes.clear();
            continue;
        }

        rotate(difference.begin(), difference.begin() + difference.size() - 1, difference.end());

        if (difference[0] == 4 && difference[1] == 3 && difference[2] == 3)
        {
            cout << "first\n";
            difference.clear();
            curnotes.clear();
            continue;
        }

        rotate(difference.begin(), difference.begin() + difference.size() - 1, difference.end());

        if (difference[0] == 4 && difference[1] == 3 && difference[2] == 3)
        {
            cout << "second\n";
            difference.clear();
            curnotes.clear();
            continue;
        }

        rotate(difference.begin(), difference.begin() + difference.size() - 1, difference.end());

        if (difference[0] == 4 && difference[1] == 3 && difference[2] == 3)
        {
            cout << "third\n";
            difference.clear();
            curnotes.clear();
            continue;
        }

        cout << "invalid\n";
        difference.clear();
        curnotes.clear();
    }

    return 0;
}