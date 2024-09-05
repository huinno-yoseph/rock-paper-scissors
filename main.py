from fastapi import FastAPI, HTTPException
from controller import *

app = FastAPI()


@app.get("/")
async def root():
    return {"message": "Hello World"}


@app.get("/hello/{name}")
async def say_hello(name: str):
    return {"message": f"Hello {name}"}


# GET 메서드: 유저가 '가위'를 선택한 경우
@app.get("/play/scissors")
async def play_scissors():
    user_choice = "가위"
    computer_choice = get_computer_choice()
    result = determine_winner(user_choice, computer_choice)

    return {
        "user_choice": user_choice,
        "computer_choice": computer_choice,
        "result": result
    }


# GET 메서드: 유저가 '바위'를 선택한 경우
@app.get("/play/rock")
async def play_rock():
    user_choice = "바위"
    computer_choice = get_computer_choice()
    result = determine_winner(user_choice, computer_choice)

    return {
        "user_choice": user_choice,
        "computer_choice": computer_choice,
        "result": result
    }


# GET 메서드: 유저가 '보'를 선택한 경우
@app.get("/play/paper")
async def play_paper():
    user_choice = "보"
    computer_choice = get_computer_choice()
    result = determine_winner(user_choice, computer_choice)

    return {
        "user_choice": user_choice,
        "computer_choice": computer_choice,
        "result": result
    }