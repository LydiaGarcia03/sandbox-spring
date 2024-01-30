package com.br.findYourPet.utils;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class Mapper<T, K> {

    private final ModelMapper modelMapper = new ModelMapper();

    public Mapper() {
        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT)
                .setPropertyCondition(Conditions.isNotNull());
    }

    public List<T> mapEntityListToDtoList(final List<K> entity, final Class<T> clazz) {
        final List<T> dtoList = new ArrayList<>();

        for (K e : entity) {
            dtoList.add(this.mapEntityToDto(e, clazz));
        }
        return dtoList;
    }

    public K mapDtoToEntity(final T dto, final Class<K> clazz) {
        return this.modelMapper.map(dto, clazz);
    }

    public T mapEntityToDto(final K entity, final Class<T> clazz) {
        return this.modelMapper.map(entity, clazz);
    }
}
