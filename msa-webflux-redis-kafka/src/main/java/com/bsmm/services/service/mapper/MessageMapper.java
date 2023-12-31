package com.bsmm.services.service.mapper;

import com.bsmm.services.model.Message;
import com.bsmm.services.service.dto.MessageDTO;
import com.bsmm.services.service.dto.StorageMessage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MessageMapper {
    MessageMapper INSTANCE = Mappers.getMapper(MessageMapper.class);

    @Mapping(target = "version", defaultValue = "1", ignore = true)
    Message toEntity(MessageDTO dto);

    @Mapping(target = "version", defaultValue = "1", ignore = true)
    Message toEntity(StorageMessage dto);

    MessageDTO toDto(Message dto);
    MessageDTO toDto(StorageMessage dto);
}
