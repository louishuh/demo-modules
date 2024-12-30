package org.example.demoapplication;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.example.demoshared.Category;

@Getter
@Setter
public class MemoDto {
    private Long id;
    private Category category;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
