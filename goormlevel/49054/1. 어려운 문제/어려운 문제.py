# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
N = int(input())

num = 1;
for n in range(1, N + 1):
	num *= n


while num // 10 != 0:
	temp = str(num)
	num = 0
	for i in range(0, len(temp)):
		 num += int(temp[i])


print(num);