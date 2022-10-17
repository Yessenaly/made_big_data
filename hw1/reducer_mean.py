import sys

s = 0
cnt = 0

for row in sys.stdin:
    mean_i, cnt_i = row.split()
    mean_i = float(mean_i)
    cnt_i = float(cnt_i)
    s += cnt_i * mean_i
    cnt += cnt_i
print(s / cnt)