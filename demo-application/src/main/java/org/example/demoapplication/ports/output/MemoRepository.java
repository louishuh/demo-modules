package org.example.demoapplication.ports.output;

import java.util.Optional;
import org.example.demodomain.model.Memo;

public interface MemoRepository {

    Memo save(Memo memo);
    Optional<Memo> findById(Long id);
}
