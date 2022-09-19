package api.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder

public class ErrorDto {
    int code;
    String details;
    String message;
    String timestamp;
}
