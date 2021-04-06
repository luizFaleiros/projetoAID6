package br.com.projeto.domain.dto;

public class GreetingsDTO {

    private final long id;
    private final String content;

    public GreetingsDTO(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

}
