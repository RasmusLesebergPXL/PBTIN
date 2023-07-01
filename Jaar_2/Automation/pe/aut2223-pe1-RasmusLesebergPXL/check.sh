#!/bin/bash
vagrant ssh webserver1 -c 'curl 127.0.0.1:5000/hostname'
