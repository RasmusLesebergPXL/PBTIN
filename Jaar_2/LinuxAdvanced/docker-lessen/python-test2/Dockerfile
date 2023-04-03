FROM python:bullseye
RUN apt-get update \
  && apt-get install -y sudo
RUN groupadd -r pythonuser \
  && useradd -r -m -l -g pythonuser -s /sbin/nologin -c "Python user" pythonuser \
  && echo pythonuser:pxl | chpasswd \
  && usermod -aG sudo pythonuser
WORKDIR /home/pythonuser
ADD hello.py .
RUN chown pythonuser:pythonuser hello.py && chmod 755 hello.py
USER pythonuser
CMD python hello.py
