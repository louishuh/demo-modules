package org.example.demoapi;

import org.example.demoapplication.MemoUsecase;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemoController {

    private final MemoUsecase memoUsecase;

    public MemoController(MemoUsecase memoUsecase) {
        this.memoUsecase = memoUsecase;
    }
}
