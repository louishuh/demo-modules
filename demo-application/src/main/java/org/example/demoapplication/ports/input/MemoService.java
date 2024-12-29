package org.example.demoapplication.ports.input;

import org.example.demoapplication.MemoDto;
import org.example.demoapplication.MemoUsecase;
import org.example.demoapplication.ports.output.MemoRepository;
import org.example.demodomain.model.Memo;
import org.springframework.stereotype.Service;

@Service
public class MemoService implements MemoUsecase {
    private final MemoRepository memoRepository;
    private final MemoMapper memoMapper;

    public MemoService(MemoRepository memoRepository, MemoMapper memoMapper) {
        this.memoRepository = memoRepository;
        this.memoMapper = memoMapper;
    }

    @Override
    public MemoDto create(String title, String content) {
        Memo newMemo = memoRepository.save(new Memo(title, content));
        return toDto(newMemo);
    }

    @Override
    public MemoDto edit(Long id, String title, String content) {

        Memo memo = load(id);
        memo.edit(title, content);
        memoRepository.save(memo);
        return toDto(memo);
    }

    @Override
    public MemoDto getOne(Long id) {
        return toDto(load(id));
    }

    private Memo load(Long id) {
        return memoRepository.findById(id)
                             .orElseThrow();
    }

    private MemoDto toDto(Memo memo) {
        return memoMapper.toDto(memo);
    }
}
