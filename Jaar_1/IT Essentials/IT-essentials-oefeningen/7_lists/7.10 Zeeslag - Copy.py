from random import randint

board = []

for x in range(3):
    board.append(["O"] * 4)


def print_board(board):
    for row in board:
        print(" ".join(row))


print("Let's play Battleship!")
print_board(board)


def random_row(board):
    return randint(0, len(board) - 1)


def random_col(board):
    return randint(0, len(board[0]) - 1)


ship_row = random_row(board)
ship_col = random_col(board)

for turn in range(10):
    guess_row = int(input("Guess Row:"))
    guess_col = int(input("Guess Col:"))

    if guess_row == ship_row and guess_col == ship_col:
        print("Raak")
        break
    else:
        if (guess_row < 0 or guess_row > 4) or (guess_col < 0 or guess_col > 4):
            print("Buiten het speelveld")
        elif (board[guess_row][guess_col] == "X"):
            print("Deze poging is al geweest")
        else:
            print("Mis")
            board[guess_row][guess_col] = "X"
        print(turn + 1)
        print_board(board)
        if turn > 10:
            print("Game Over")
print("the real ship location is", ship_row)
print(ship_col)
