import sys

cur_var = None
cur_cnt = None
cur_mean = None

for row in sys.stdin:
    var_i, cnt_i, mean_i = row.split()
    var_i = float(var_i)
    mean_i = float(mean_i)
    cnt_i = float(cnt_i)
    if cur_var is None:
        cur_var = var_i
        cur_cnt = cnt_i
        cur_mean = mean_i
        continue

    cur_var = (cur_var * cur_cnt + var_i * cnt_i) / (cur_cnt + cnt_i) + \
        cur_cnt * cnt_i * ((cur_mean - mean_i) / (cur_cnt + cnt_i))**2
    cur_mean = (cur_mean * cur_cnt + mean_i * cnt_i) / (cur_cnt + cnt_i)
    cur_cnt = cur_cnt + cnt_i
print(cur_var)