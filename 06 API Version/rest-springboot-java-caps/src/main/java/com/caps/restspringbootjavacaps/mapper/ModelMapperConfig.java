package com.caps.restspringbootjavacaps.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
	
	private static ModelMapper mapper = new ModelMapper();


	public static <D, O> D parseObject(O origin, Class<D> destination) {
		return mapper.map(origin, destination);
	}

    public static <D, O> List<D> parseListObject(List<O> origin, Class<D> destination) {
    	List<D> destinationObjects = new ArrayList<>();
    	for (O o : origin) {
    		destinationObjects.add(mapper.map(o, destination));
    	}
        return destinationObjects;
    }
}
