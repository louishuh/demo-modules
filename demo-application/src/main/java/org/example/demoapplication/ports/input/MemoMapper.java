package org.example.demoapplication.ports.input;

import org.example.demoapplication.MemoDto;
import org.example.demodomain.model.Memo;
import org.mapstruct.Mapper;

@Mapper
public interface MemoMapper {

    MemoDto toDto(Memo memo);
}
