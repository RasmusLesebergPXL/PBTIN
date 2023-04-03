def get_number_of_participants(heartbeats):
    return len(heartbeats[0])


def get_number_of_tests(heartbeats):
    return len(heartbeats)


def highest_heartrate(heartbeats):
    highest = heartbeats[0][0]
    for row in range(get_number_of_tests(heartbeats)):
        for kol in range(get_number_of_participants(heartbeats)):
            if heartbeats[row][kol] > highest:
                highest = heartbeats[row][kol]
    return highest


def lowest_heartrate(heartbeats):
    lowest = heartbeats[0][0]
    for row in range(get_number_of_tests(heartbeats)):
        for kol in range(get_number_of_participants(heartbeats)):
            if heartbeats[row][kol] < lowest:
                lowest = heartbeats[row][kol]
    return lowest


def average_heartrate(heartbeats):
    averages = []
    for row in range(get_number_of_tests(heartbeats)):
        sum = 0
        for kol in range(get_number_of_participants(heartbeats)):
            sum += heartbeats[row][kol]
        average = sum / get_number_of_participants(heartbeats)
        averages.append(round(average, 2))
    return averages


def heart_rate_difference(heartbeats):
    results = []
    for participant in range(get_number_of_participants(heartbeats)):
        lowest = heartbeats[0][participant]
        highest = heartbeats[0][participant]
        for test in range(1, get_number_of_tests(heartbeats)):
            if heartbeats[test][participant] < lowest:
                lowest = heartbeats[test][participant]
            if heartbeats[test][participant] > highest:
                highest = heartbeats[test][participant]
        results.append(highest - lowest)
    return results


def main():
    results = [[72, 75, 71, 73, 72, 76],
               [91, 90, 94, 93, 88, 91],
               [130, 135, 139, 142, 129, 138],
               [120, 118, 110, 105, 121, 119]]
    print("Aantal deelnemers: ", get_number_of_participants(results))
    print("Aantal testen: ", get_number_of_tests(results))
    print("Hoogste hartslag: ", highest_heartrate(results))
    print("Laagste hartslag: ", lowest_heartrate(results))
    print("Gemiddelde hartslag:", average_heartrate(results))
    print("Verschil hartslag per deelnemer:", heart_rate_difference(results))


if __name__ == '__main__':
    main()
