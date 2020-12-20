init_input = input()
final_square = [[1, 2], [3, 4]]

if (init_input.count("V") % 2) == 1:
    temp = [[1, 2], [3, 4]]

    final_square[0][1] = temp[0][0]
    final_square[0][0] = temp[0][1]
    final_square[1][1] = temp[1][0]
    final_square[1][0] = temp[1][1]

if (init_input.count("H") % 2) == 1:
    temp = final_square
    final_square = [[1, 2], [3, 4]]

    final_square[0][0] = temp[1][0]
    final_square[0][1] = temp[1][1]
    final_square[1][0] = temp[0][0]
    final_square[1][1] = temp[0][1]

print(str(final_square[0][0]) + " " + str(final_square[0][1]))
print(str(final_square[1][0]) + " " + str(final_square[1][1]))
