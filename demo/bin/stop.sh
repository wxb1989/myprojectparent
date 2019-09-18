#!/bin/bash
PATH_DIR=$(dirname $(which $0))
PROCESS_NAME=${PATH_DIR%/*}
kill -9 $(ps -eaf|grep -i "java .*-classpath .*${PROCESS_NAME}/"|grep -v 'grep'|awk '{print $2}')
