n = int(input())
# n = 20

for i in range(1, n+1):
    if (i%3 == 0) and (i%5 == 0):
        print("fizzbuzz")
    elif i%3 == 0:
        print("fizz")
    elif i%5 == 0:
        print("buzz")

    if (i%3 != 0) and (i%5 != 0):
        print(i)
