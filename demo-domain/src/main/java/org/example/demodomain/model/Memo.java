package org.example.demodomain.model;

import java.time.LocalDateTime;
import javax.annotation.Nullable;
import lombok.Getter;
@Getter
public class Memo {

    @Nullable
    private final Long id;
    private String title;
    private String content;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Memo(String title, String content) {
        this.id = null;
        this.title = title;
        this.content = content;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public void edit(String title, String content) {
        this.title = title;
        this.content = content;
        this.updatedAt = LocalDateTime.now();
    }
}
