#include <bits/stdc++.h>
using namespace std;

int steps = 4;
vector<string> sequence = {"AB"};
vector<vector<string>> subs = {
    {"AA", "AB"},
    {"AB", "BB"},
    {"B", "AA"}};
vector<int> ri = {0};
vector<int> pi = {0};
string final_val = "AAAB";
bool kill_switch = 0;

// int steps;
// vector<string> sequence;
// vector<int> ri = {0};
// vector<int> pi = {0};
// vector<vector<string>> subs(3);
// string final_val;
// bool kill_switch = 0;

vector<int> find_all(string str, string substr)
{
    vector<int> pos;

    int found = str.find(substr, 0);
    while (found != string::npos)
    {
        pos.push_back(found);
        found = str.find(substr, found + 1);
    }

    return pos;
}

void search(int n)
{
    if (n == steps + 1 && sequence.size() == steps + 1)
    {
        if (sequence[steps] == final_val)
        {
            for (int i = 1; i < sequence.size(); i++)
            {
                cout << ri[i] << " " << pi[i] << " " << sequence[i] << "\n";
            }

            kill_switch = 1;
            return;
        }
    }
    else if (kill_switch == 1)
    {
        return;
    }
    else
    {
        //O(n^2) time  // fix this
        for (int i = 0; i < subs.size(); i++)
        {
            vector<int> pos = find_all(sequence[n - 1], subs[i][0]);

            for (int j = 0; j < pos.size(); j++)
            {
                string temp = sequence[n - 1];
                temp.replace(pos[j], subs[i][0].length(), subs[i][1]);
                sequence.push_back(temp);
                ri.push_back(i + 1);
                pi.push_back(pos[j] + 1);
                search(n + 1);
                sequence.pop_back();
                ri.pop_back();
                pi.pop_back();
            }
        }
    }
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    // string value;

    // for (int i = 0; i < 3; i++)
    // {
    //     cin >> value;
    //     subs[i].push_back(value);
    //     cin >> value;
    //     subs[i].push_back(value);
    // }

    // cin >> steps;
    // cin >> value;
    // sequence.push_back(value);
    // cin >> final_val;

    search(1);

    return 0;
}