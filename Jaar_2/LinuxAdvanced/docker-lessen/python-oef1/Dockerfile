FROM ubuntu
LABEL maintainer = "rasmus.leseberg@student.pxl.be"
RUN apt update && apt install -y python3 nano
COPY fib.py /
CMD python3 /fib.py
