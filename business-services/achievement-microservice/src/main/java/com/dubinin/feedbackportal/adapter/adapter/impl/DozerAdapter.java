package com.dubinin.feedbackportal.adapter.adapter.impl;

import com.dubinin.feedbackportal.adapter.adapter.Adapter;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladyslav_Dubinin on 9/8/2017.
 */
@Component
@Scope("singleton")
public class DozerAdapter implements Adapter {
    private Mapper mapper;

    @PostConstruct
    private void init(){
        final List<String> list = new ArrayList<>();
        list.add("dozer/achievement_message_dozer_mapping.xml");
        list.add("dozer/achievement_dozer_mapping.xml");
        mapper = new DozerBeanMapper(list);
    }

    public  <T> T adapt(Object source, Class<T> destinationClass){
        return mapper.map(source, destinationClass);
    }
}
