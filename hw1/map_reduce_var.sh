#!/usr/bin/env bash
set -x

HADOOP_STREAMING_JAR=/opt/hadoop-3.2.1/share/hadoop/tools/lib/hadoop-streaming-3.2.1.jar
HDFS_OUTPUT_DIR=/output_var

hdfs dfs -rm -r -skipTrash $HDFS_OUTPUT_DIR

yarn jar $HADOOP_STREAMING_JAR \
        -files mapper_var.py,reducer_var.py \
        -mapper 'python3 mapper_var.py' \
        -reducer 'python3 reducer_var.py' \
	    -numReduceTasks 1 \
        -input /AB_NYC_2019.csv \
        -output $HDFS_OUTPUT_DIR


hdfs dfs -cat $HDFS_OUTPUT_DIR/part-00000