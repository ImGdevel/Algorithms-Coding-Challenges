# 입력을 줄 단위로 읽음
lines = []
while True:
    line = input()
    if line == "END":
        break
    lines.append(line)

# 각 줄을 검사
for line in lines:
    letters = line.replace(' ', '')  # 공백 제거
    if len(set(letters)) == len(letters):  # 중복이 없다면
        print(line)
