package org.example.demoapplication;

public interface MemoUsecase {

    MemoDto create(String title, String content);
    MemoDto edit(Long id, String title, String content);
    MemoDto getOne(Long id);
    void delete(Long id);
}
