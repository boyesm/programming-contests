#include <bits/stdc++.h>
using namespace std;

int dims;
vector<vector<int>> table;

vector<vector<int>> rotateMatrix(vector<vector<int>> matrix)
{
    for (int i = 0; i < dims; ++i)
        for (int j = i + 1; j < dims; ++j)
            swap(matrix[i][j], matrix[j][i]);

    for (int i = 0; i < dims; ++i)
        for (int j = 0; j < dims / 2; ++j)
            swap(matrix[i][j], matrix[i][dims - j - 1]);

    return matrix;
}

void printMatrix(vector<vector<int>> matrix)
{
    for (int i = 0; i < dims; ++i)
    {
        for (int j = 0; j < dims; ++j)
        {
            cout << matrix[i][j] << " ";
        }
        cout << "\n";
    }
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> dims;

    int temp;
    for (int i = 0; i < dims; i++)
    {
        vector<int> temp_vect;
        for (int j = 0; j < dims; j++)
        {
            cin >> temp;
            temp_vect.push_back(temp);
        }
        table.push_back(temp_vect);
    }

    // find smallest value in corner
    int smallcorner;
    int one = table[0][0];
    int two = table[dims - 1][0];
    int three = table[0][dims - 1];
    int four = table[dims - 1][dims - 1];

    if (one < two && one < three && one < four)
    {
        printMatrix(table);
    }
    else if (two < one && two < three && two < four)
    {
        table = rotateMatrix(table);
        printMatrix(table);
    }
    else if (three < one && three < two && three < four)
    {
        table = rotateMatrix(table);
        table = rotateMatrix(table);
        table = rotateMatrix(table);
        printMatrix(table);
    }
    else
    {
        table = rotateMatrix(table);
        table = rotateMatrix(table);
        printMatrix(table);
    }

    return 0;
}