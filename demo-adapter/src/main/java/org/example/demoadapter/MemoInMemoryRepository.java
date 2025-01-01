package org.example.demoadapter;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import org.example.demoapplication.ports.output.MemoRepository;
import org.example.demodomain.model.Memo;
import org.springframework.stereotype.Repository;
import org.springframework.util.ReflectionUtils;

@Repository
public class MemoInMemoryRepository implements MemoRepository {

    private final AtomicLong idGenerator = new AtomicLong(0);
    private final Map<Long, Memo> memoMap = new HashMap<>();

    @Override
    public Memo save(Memo memo) {
        Field idField = ReflectionUtils.findField(Memo.class, "id");
        ReflectionUtils.setField(Objects.requireNonNull(idField), memo, idGenerator.incrementAndGet());
        memoMap.put(memo.getId(), memo);
        return memo;
    }

    @Override
    public Optional<Memo> findById(Long id) {
        return Optional.ofNullable(memoMap.get(id));
    }
}
