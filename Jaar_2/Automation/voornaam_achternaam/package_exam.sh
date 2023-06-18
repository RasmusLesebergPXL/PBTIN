#!/bin/bash
# prepare exam solution file to upload

# extract current directory name
exam_file=$(basename "$PWD")

cd ..
tar -czvf "$exam_file".tgz --exclude='*.vagrant' --exclude='*documentation' "$exam_file"/

echo -e "\nFile created:"

# get full path and file size
filepath=$(realpath "$exam_file".tgz); echo $filepath $(\ls -lh $filepath | awk '{print $5}')

sha256sum "$exam_file".tgz

# restore current directory
cd $exam_file
