package com.wco;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class WordCoMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	  @Override
	  public void map(LongWritable key, Text value, Context context)
	      throws IOException, InterruptedException {
	    
	   
	    String line_lc = value.toString().toLowerCase();
	    String last = null;
	    
	    
	    for (String word : line_lc.split("\\W+")) {
	      if (word.length() > 0) {
	        if (last != null) {
	          context.write(new Text(last + "," + word), new IntWritable(1));
	        }
	        last = word;
	      }
	    }
	  }
	}
