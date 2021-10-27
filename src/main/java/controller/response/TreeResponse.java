package controller.response;

import lombok.*;
import model.TreeType;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TreeResponse {
    private Long id;
    private TreeType type;
    private String roots;
    private double size;
}
