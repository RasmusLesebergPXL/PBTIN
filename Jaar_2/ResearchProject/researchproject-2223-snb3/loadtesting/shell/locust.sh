#!/bin/bash

USER_COUNT_LT=30000 #total amount of users to spawn in locust

if [ ! -d "../loadtest_stats" ]; then
  mkdir "../loadtest_stats"
fi

FILENAME="../loadtest_stats/run_$(date +"%Y-%m-%d_%H-%M-%S").html"
locust --headless --users $USER_COUNT_LT --spawn-rate 30 --run-time 10m --only-summary -f ../run_single_user.py --html "$FILENAME"
