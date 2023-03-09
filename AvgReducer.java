package com.al;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

public class AvgReducer extends Reducer<Text, IntWritable, Text, DoubleWritable> {


@Override
public void reduce(Text key, Iterable<IntWritable> values, Context context)
  throws IOException, InterruptedException {

double sum = 0, count = 0;


for (IntWritable value : values) {
  
 
  sum += value.get();
  count++;
}
if (count != 0d) {
  
 
  double result = sum / count;
 
 
  context.write(key, new DoubleWritable(result));
}
}
}
