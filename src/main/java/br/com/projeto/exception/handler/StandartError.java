package br.com.projeto.exception.handler;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StandartError implements Serializable {
    private Integer status;
    private String msg;
    private Long timeStamp;
}
