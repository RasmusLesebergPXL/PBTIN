from os import environ

# default if NTERMS environment variable is empty
NTERMS_DEFAULT = "13"


def PrintFibonacci(length):
    # initial variable for the base case.
    first = 0
    second = 1

    # printing the initial Fibonacci number.
    print(first, second, end=" ")

    # decreasing the length by two because the first 2 Fibonacci numbers
    # already printed.
    length -= 2

    # loop until the length becomes 0.
    while length > 0:

        # printing the next Fibonacci number.
        print(first + second, end=" ")

        # updating the first and second variables for finding the next number.
        temp = second
        second = first + second
        first = temp

        # decreasing length that states the Fibonacci numbers to be printed more
        length -= 1


# main program
if __name__ == "__main__":
    # get NTERMS environment variable
    nterms = int(environ.get('NTERMS', NTERMS_DEFAULT))
    print("Fibonacci Series -", nterms, "terms")
    PrintFibonacci(nterms)
    pass
