# Ubuntu-based Image
FROM ubuntu:20.04
ADD hostfile.txt /tmp/
RUN apt update && apt -y upgrade && apt -y install iputils-ping
CMD ["echo", "Container based on Image from Gert Van Waeyenberg"]
