package controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import model.TreeType;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddNewTreeRequest {
    private TreeType type;
    private String roots;
    private double size;
}
