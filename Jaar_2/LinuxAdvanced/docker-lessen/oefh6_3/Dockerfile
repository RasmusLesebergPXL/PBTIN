FROM ubuntu
LABEL maintainer = "rasmus.leseberg@student.pxl.be"
# root privileges needed for installation during image build process
#USER root
RUN groupadd student \
&& useradd -m -g student -s /bin/bash -c "student user" student \
&& echo student:pxl | chpasswd \
&& usermod -aG sudo student
RUN apt update && apt install -y tree sudo
RUN echo root:pxl | chpasswd
RUN yes | unminimize && apt -y install man
# normal privileges for running the container
USER student
WORKDIR /home/student
RUN touch Welcome.txt