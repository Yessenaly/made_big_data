import sys

def get_num_from_string(x):
    if x == "price" or x == "":
        return None
    return float(x)

s = 0
cnt = 0
cur_string = ""

for row in sys.stdin:
    cur_string += row
    values = cur_string.split(',')
    if len(values) >= 16:
        num = get_num_from_string(values[-7])
        if num is not None:
            cnt += 1
            s += num
        cur_string = ""
    else:
        continue

print(s / cnt, cnt)