from pydantic import BaseModel
import random


# 요청으로 받을 데이터 모델 정의
class Choice(BaseModel):
    choice: str


def get_computer_choice():
    return random.choice(["가위", "바위", "보"])


def determine_winner(user_choice, computer_choice):
    if user_choice == computer_choice:
        return "비겼습니다!"

    if (user_choice == "가위" and computer_choice == "보") or \
            (user_choice == "바위" and computer_choice == "가위") or \
            (user_choice == "보" and computer_choice == "바위"):
        return "유저가 이겼습니다!"

    return "컴퓨터가 이겼습니다!"