package com.example.board.dto;

public class BoardDto {

    private Long id;
    private String title;
    private String content;
    private String writer;
    private String createdAt;
    private int viewCount;

    public BoardDto(
            Long id,
            String title,
            String content,
            String writer,
            String createdAt,
            int viewCount
    ) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.createdAt = createdAt;
        this.viewCount = viewCount;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getWriter() {
        return writer;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public int getViewCount() {
        return viewCount;
    }
}