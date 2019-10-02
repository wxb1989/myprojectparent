#!/bin/bash

# 配置JDK安装路径
JAVA_HOME="/usr/local/java/jdk1.8.0_131"
JAVA_CMD=${JAVA_HOME}/bin/java
# JVM的相关配置
JAVA_OPTION="-Ddefault.client.encoding=UTF-8 -Dfile.encoding=UTF-8 -server -Xms128M -Xmx256M"
COLOR_RED="\\033[1;31m"
COLOR_GREEN="\\033[1;32m"
COLOR_DEFAULT="\\033[0m"

DT_NOW=`date '+%Y%m%d_%H%M%S'`

# 获取当前文件的路径
PATH_DIR=$(dirname $(which $0))
# 项目路径
APP_HOME=${PATH_DIR%/*}
# jar所在路径
APP_LIB="${APP_HOME}/lib"

# 变量并执行所有jar
for libfile in ${APP_LIB}/*.zip ; do
    if [[ -f ${libfile} ]] ; then
        CLASSPATH=${libfile}:${CLASSPATH}
    fi
done
for libfile in ${APP_LIB}/*.jar ; do
    if [[ -f ${libfile} ]] ; then
        CLASSPATH=${libfile}:${CLASSPATH}
    fi
done
CLASSPATH=${APP_HOME}:${CLASSPATH}

# 记录日志
cd ${APP_HOME}
if [[ ! -d "log/" ]]; then
	mkdir log
fi
CMD="${JAVA_CMD} ${JAVA_OPTION} -classpath ${CLASSPATH}\ cn.jtcoding.DemoApplication"
`${CMD} >${APP_HOME}/log/stderr.txt 2>&1 &`

sleep 3
ps -eaf | grep "java" | grep "${APP_HOME}/"