
n = int(input())
# n = int(5)
all_values = ""

while n != 1:
    all_values += str(int(n)) + " "
    if n%2 == 0:
        n/=2
    else:
        n = (n*3)+1

all_values += "1"
print(all_values)