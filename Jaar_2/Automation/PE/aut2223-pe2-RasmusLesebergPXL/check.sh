#!/bin/bash

#!/bin/bash
vagrant ssh webserver1 -c 'sudo cat /home/my_user/info.txt'
vagrant ssh webserver1 -c 'echo "pxl" | su -c "whoami" my_user'
vagrant ssh webserver1 -c 'curl 127.0.0.1:80'
