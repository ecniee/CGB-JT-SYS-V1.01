package com.jt.common.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class DateSerializer extends 
       JsonSerializer<Date>{
	public DateSerializer() {
		System.out.println("DateSerializer()");
	}
    @Override
    public void serialize(Date date, 
    		JsonGenerator jsonGenerator, 
    		SerializerProvider arg2)
    		throws IOException, JsonProcessingException {
    	 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	 //System.out.println("==serialize=="); 
    	 String dateStr=sdf.format(date);
    	 jsonGenerator.writeString(dateStr);
    }//课后查一下ThreadLocal
}
