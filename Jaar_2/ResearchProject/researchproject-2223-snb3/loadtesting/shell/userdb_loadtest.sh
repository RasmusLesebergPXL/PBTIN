#!/bin/bash

GENERATE_DURATION=600 #seconds

# Delete users if it didn't happen yet
mongo localhost:27017/users ~/userdb_loadtests/delete_users.js

start_time=$(date +%s)
while [ $(( $(date +%s) - $start_time )) -lt $GENERATE_DURATION ]; do
      mongo localhost:27017/users ~/userdb_loadtests/generate_users.js
      sleep 1
done

# Cleanup
mongo localhost:27017/users ~/userdb_loadtests/delete_users.js

