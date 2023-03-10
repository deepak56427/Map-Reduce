package com.ws;

import java.io.IOException;


import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WSMapper extends Mapper<LongWritable, Text, Text, IntWritable>{ 
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            
            	
                String search = "This";
                String line = value.toString();
                
                for (String w : line.split("\\W+")){
                	if (w == search)
                		context.write(new Text(w), new IntWritable(1));	
                }                      
            
        }    
    }    


