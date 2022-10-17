import sys

def get_num_from_string(x):
    if x == "price" or x == "":
        return None
    return float(x)

nums = []
cur_string = ""

for row in sys.stdin:
    cur_string += row
    values = cur_string.split(',')
    if len(values) >= 16:
        num = get_num_from_string(values[-7])
        if num is not None:
            nums.append(num)
        cur_string = ""
    else:
        continue

s = sum(nums)
cnt = len(nums)
mean = s / cnt
res = 0
for num in nums:
    res += (num - mean)**2
res /= cnt

print(res, cnt, mean)