#!/bin/bash

ssh student@10.128.102.7 "~/researchproject-2223-snb3/loadtesting/shell/userdb_loadtest.sh > /dev/null 2>&1" &
./locust.sh

